package studie.three.o.eight.management.service;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import studie.three.o.eight.management.domain.Client;
import studie.three.o.eight.management.domain.exception.BadRequestException;
import studie.three.o.eight.management.domain.persistence.DynamoDBClientPersistenceBuilder;
import studie.three.o.eight.management.service.dto.ClientRequest;

import javax.inject.Inject;
import java.util.List;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/client")
public class ClientService {

    @Inject
    DynamoDBClientPersistenceBuilder dynamoDBClientPersistenceBuilder;

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> getClients(@QueryValue(defaultValue = "10") int offset, @QueryValue(defaultValue = "10") int limit) {
        List<Client> clients = dynamoDBClientPersistenceBuilder.getClients(offset, limit);
        return HttpResponse.ok(clients);
    }

    @Get(value = "/{clientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> getClient(String clientId) {
        Client client = dynamoDBClientPersistenceBuilder.getClient(clientId);
        if(client == null) {
            return HttpResponse.status(HttpStatus.NOT_FOUND);
        }
        return HttpResponse.ok(client);
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> createClient(@Body ClientRequest clientRequest) {
        Client createdClient = dynamoDBClientPersistenceBuilder.createClient(clientRequest);
        if (createdClient == null) {
            return HttpResponse.status(HttpStatus.BAD_REQUEST);
        }
        return HttpResponse.created(createdClient);
    }

    @Put
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> updateClient(@Body ClientRequest clientRequest) {
        try {
            Client updatedClient = dynamoDBClientPersistenceBuilder.updateClient(clientRequest);
            if (updatedClient == null) {
                return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return HttpResponse.ok(updatedClient);
        } catch (Exception ex) {
            if (ex instanceof BadRequestException) {
                return HttpResponse.status(HttpStatus.BAD_REQUEST);
            }
            return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Delete(value = "/{clientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> deleteClient(String clientId) {
        try {
            Client deletedClient = dynamoDBClientPersistenceBuilder.deleteClient(clientId);
            if (deletedClient == null) {
                return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return HttpResponse.ok(deletedClient);
        } catch (Exception ex) {
            if (ex instanceof BadRequestException) {
                return HttpResponse.status(HttpStatus.BAD_REQUEST);
            }
            return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
