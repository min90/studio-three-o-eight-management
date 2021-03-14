package studie.three.o.eight.management.domain.persistence;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import studie.three.o.eight.management.domain.Client;
import studie.three.o.eight.management.domain.exception.BadRequestException;
import studie.three.o.eight.management.domain.mapper.ClientMapper;
import studie.three.o.eight.management.service.dto.ClientRequest;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.*;

@Singleton
public class DynamoDBClientPersistenceBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(DynamoDBClientPersistenceBuilder.class);
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    ClientMapper clientMapper;

    @Inject
    public DynamoDBClientPersistenceBuilder(AmazonDynamoDB amazonDynamoDB) {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
    }

    public List<Client> getClients(int offset, int limit) {
        // Might need to use offset and limit
        try {
            DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
            return dynamoDBMapper.scan(Client.class, scanExpression);
        } catch (Exception ex) {
            LOG.error("Failed to retrieve clients from DB with error", ex);
            return Collections.emptyList();
        }
    }

    public Client getClient(String clientId) {
        try {
            Map<String, String> nameMap = new HashMap<>();
            nameMap.put("#Id", "Id");

            Map<String, AttributeValue> valueMap = new HashMap<>();
            valueMap.put(":Id", new AttributeValue().withS(clientId));

            DynamoDBQueryExpression dynamoDBQueryExpression = new DynamoDBQueryExpression()
                    .withKeyConditionExpression("#Id = :Id")
                    .withExpressionAttributeNames(nameMap)
                    .withExpressionAttributeValues(valueMap)
                    .withConsistentRead(false);

            List<Client> clients = dynamoDBMapper.query(Client.class, dynamoDBQueryExpression);
            if (clients.isEmpty()) {
                return null;
            }
            return clients.get(0);
        } catch (Exception ex) {
            LOG.error("Failed to retrieve client from DynamoDB with ID {}", clientId, ex);
            return null;
        }
    }

    public Client createClient(ClientRequest clientRequest) {
        try {
            Client client = clientMapper.build(clientRequest);

            Client existingClient = getClientByName(client.getName());

            if (existingClient != null) {
                return null;
            }

            String id = UUID.randomUUID().toString();
            client.setId(id);

            HashMap<String, ExpectedAttributeValue> expectedAttributes = new HashMap<>();
            expectedAttributes.put("Id", new ExpectedAttributeValue(new AttributeValue().withS(id)).withComparisonOperator(ComparisonOperator.BEGINS_WITH));

            DynamoDBMapperConfig saveConfig = new DynamoDBMapperConfig.Builder().withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.CLOBBER).build();
            DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression()
                    .withExpected(expectedAttributes);
            dynamoDBMapper.save(client, saveExpression, saveConfig);
            return client;
        } catch (Exception ex) {
            LOG.error("Failed to save client with {}", clientRequest.getName(), ex);
            return null;
        }
    }


    public Client updateClient(ClientRequest clientRequest) throws BadRequestException {
        try {
            Client client = clientMapper.build(clientRequest);
            if (client.getId() == null) {
                throw new BadRequestException("No client id given");
            }

            DynamoDBMapperConfig saveConfig = new DynamoDBMapperConfig.Builder()
                    .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES).build();
            dynamoDBMapper.save(client, saveConfig);
            return client;
        } catch (Exception ex) {
            if (ex instanceof BadRequestException) {
                throw new BadRequestException("No client id given");
            }
            LOG.error("Failed to update client with {}", clientRequest.getId(), ex);
            return null;
        }
    }

    public Client deleteClient(String clientId) throws BadRequestException {
        try {
            if (clientId == null) {
                throw new BadRequestException("No client id given");
            }
            Client client = new Client();
            client.setId(clientId);

            dynamoDBMapper.delete(client);
            return client;
        } catch (Exception ex) {
            if (ex instanceof BadRequestException) {
                throw new BadRequestException("No client id given");
            }
            LOG.error("Failed to delete client with {}", clientId, ex);
            return null;
        }
    }

    private Client getClientByName(String name) {
        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("#Name", "Name");

        Map<String, AttributeValue> valueMap = new HashMap<>();
        valueMap.put(":Name", new AttributeValue().withS(name));

        DynamoDBQueryExpression dynamoDBQueryExpression = new DynamoDBQueryExpression()
                .withKeyConditionExpression("#Name = :Name")
                .withIndexName("client-name-id-index")
                .withExpressionAttributeNames(nameMap)
                .withExpressionAttributeValues(valueMap)
                .withConsistentRead(false);

        List<Client> clients = dynamoDBMapper.query(Client.class, dynamoDBQueryExpression);
        if (clients.isEmpty()) {
            return null;
        }
        return clients.get(0);
    }
}
