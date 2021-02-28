package studie.three.o.eight.management.domain.calendar;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import studie.three.o.eight.management.domain.Client;
import studie.three.o.eight.management.domain.Planning;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class CalendarEventBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(CalendarEventBuilder.class);
    private final Calendar calendar;


    @Inject
    public CalendarEventBuilder(Calendar calendar) {
        this.calendar = calendar;
    }

    public void createEventForClient(Client client, String calendarId) {
        LocalDateTime startTime = client.getAvailableFrom();
        LocalDateTime endTime = client.getAvailableTo();
        ArrayList<Planning> plannings = client.getPlannings();
        for (Planning planning : plannings) {
            try {
                Event event = new Event();
                // Set Location
                if (client.getCity() != null && client.getRoadName() != null && client.getZipCode() > 0) {
                    event.setLocation(String.format("%s, %s, %s", client.getRoadName(),
                            client.getCity(), client.getZipCode()));
                }
                if (planning.getPortraitDate() != null) {
                    event.setDescription(String.format("Portræt fotografering for %s", client.getName()));

                    DateTime portraitCalendarDateTime = createGoogleCalendarEventDateTime(planning.getPortraitDate(), startTime);
                    EventDateTime start = new EventDateTime()
                            .setDateTime(portraitCalendarDateTime)
                            .setTimeZone("Europe/Copenhagen");
                    event.setStart(start);

                    DateTime endPortraitCalendarDateTime = createGoogleCalendarEventDateTime(planning.getPortraitDate(), endTime);
                    EventDateTime end = new EventDateTime()
                            .setDateTime(endPortraitCalendarDateTime)
                            .setTimeZone("Europe/Copenhagen");
                    event.setEnd(end);

                    calendar.events().insert(calendarId, event);
                }
            } catch (Exception ex) {
                LOG.error("Failed to insert event for {}", client.getName(), ex);
            }
        }
    }

    private DateTime createGoogleCalendarEventDateTime(LocalDate planningDate, LocalDateTime time) {
        LocalDateTime endPortraitDateTime = new LocalDateTime(
                planningDate.getYear(),
                planningDate.getMonthOfYear(),
                planningDate.getDayOfMonth(),
                time.getHourOfDay(),
                time.getMinuteOfHour(),
                time.getSecondOfMinute()
        );
        long epochEndTime = endPortraitDateTime.toDateTime(DateTimeZone.UTC).getMillis();
        return new DateTime(epochEndTime);
    }
}
