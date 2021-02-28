package studie.three.o.eight.management.service.dto;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import studie.three.o.eight.management.domain.Client;
import studie.three.o.eight.management.domain.calendar.CalendarEventBuilder;
import studie.three.o.eight.management.domain.persistence.DynamoDBClientPersistenceBuilder;

import javax.inject.Inject;

@Controller("/calendar")
public class CalendarService {
    private static final Logger LOG = LoggerFactory.getLogger(CalendarService.class);

    @Inject
    CalendarEventBuilder calendarEventBuilder;

    @Inject
    DynamoDBClientPersistenceBuilder dynamoDBClientPersistenceBuilder;

    @Put(value = "/{clientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<?> syncClientWithGoogleCalendar(String clientId) {
        try {
            Client client = dynamoDBClientPersistenceBuilder.getClient(clientId);
            calendarEventBuilder.createEventForClient(client, "jems.minor@gmail.com");
            return HttpResponse.status(HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Failed to sync calendar with client {}", clientId, ex);
            return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
