package studie.three.o.eight.management.domain.persistence;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import studie.three.o.eight.management.domain.AdminUser;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class DynamoDBAdminUserPersistenceBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(DynamoDBAdminUserPersistenceBuilder.class);
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public DynamoDBAdminUserPersistenceBuilder(AmazonDynamoDB amazonDynamoDB) {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
    }

    public AdminUser storeAdminUser(String username, String hashedPassword, String email) {
        try {
            AdminUser adminUser = new AdminUser(username, hashedPassword, email);
            dynamoDBMapper.save(adminUser);
            return adminUser;
        } catch (Exception ex) {
            LOG.error("Failed to store admin user with error", ex);
            return null;
        }
    }

    public AdminUser findAdminUser(String username) {
        try {
            Map<String, String> nameMap = new HashMap<>();
            nameMap.put("#username", "username");

            Map<String, AttributeValue> valueMap = new HashMap<>();
            valueMap.put(":username", new AttributeValue().withS(username));

            DynamoDBQueryExpression dynamoDBQueryExpression = new DynamoDBQueryExpression()
                    .withKeyConditionExpression("#username = :username")
                    .withExpressionAttributeNames(nameMap)
                    .withExpressionAttributeValues(valueMap)
                    .withConsistentRead(false);
            List<AdminUser> adminUsers = dynamoDBMapper.query(AdminUser.class, dynamoDBQueryExpression);
            if (adminUsers.isEmpty()) {
                return null;
            }
            return adminUsers.get(0);
        } catch (Exception ex) {
            LOG.error("Failed retrieving admin user by username {}", username, ex);
            return null;
        }
    }
}
