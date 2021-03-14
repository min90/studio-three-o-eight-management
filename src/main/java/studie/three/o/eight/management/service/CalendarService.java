package studie.three.o.eight.management.service;

import com.google.api.services.calendar.model.Colors;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
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
    @Secured(SecurityRule.IS_ANONYMOUS)
    public HttpResponse<?> syncClientWithGoogleCalendar(String clientId, @QueryValue String calendarId, @QueryValue String colorId) {
        try {
            Client client = dynamoDBClientPersistenceBuilder.getClient(clientId);
            calendarEventBuilder.createEventForClient(client, calendarId, colorId);
            return HttpResponse.status(HttpStatus.OK);
        } catch (Exception ex) {
            LOG.error("Failed to sync calendar with client {}", clientId, ex);
            return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Get(value = "/calendar-colors")
    @Produces(MediaType.APPLICATION_JSON)
    @Secured(SecurityRule.IS_ANONYMOUS)
    public HttpResponse<?> getCalendarColors() {
        try {
            Colors eventColors = calendarEventBuilder.getCalendarColors();
            return HttpResponse.ok(eventColors);
        } catch (Exception ex) {
            LOG.error("Failed to get calendar events", ex);
            return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
