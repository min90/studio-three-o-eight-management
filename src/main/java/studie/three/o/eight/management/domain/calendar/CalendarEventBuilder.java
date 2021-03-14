package studie.three.o.eight.management.domain.calendar;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Colors;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import studie.three.o.eight.management.domain.Client;
import studie.three.o.eight.management.domain.Planning;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

@Singleton
public class CalendarEventBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(CalendarEventBuilder.class);
    private final Calendar calendar;

    @Inject
    public CalendarEventBuilder(Calendar calendar) {
        this.calendar = calendar;
    }

    public void createEventForClient(Client client, String calendarId, String colorId) {
        ArrayList<Planning> plannings = client.getPlannings();
        for (Planning planning : plannings) {
            try {
                Event event = new Event();
                // Set Location
                if (client.getCity() != null && client.getRoadName() != null && client.getZipCode() != null) {
                    event.setLocation(String.format("%s, %s, %s", client.getRoadName(),
                            client.getCity(), client.getZipCode()));
                }
                if (planning.getPortraitDate() != null) {
                    event.setSummary("Portræt fotografering");
                    event.setDescription(String.format("Portræt fotografering for %s", client.getName()));

                    DateTime portraitCalendarDate = createGoogleCalendarEventDateTime(planning.getPortraitDate());
                    EventDateTime start = new EventDateTime()
                            .setDate(portraitCalendarDate)
                            .setTimeZone("Europe/Copenhagen");
                    event.setStart(start);
                    event.setEnd(start);
                    event.setColorId(colorId);

                    calendar.events().insert(calendarId, event).execute();
                }
            } catch (Exception ex) {
                LOG.error("Failed to insert event for {}", client.getName(), ex);
            }
        }
    }

    public Colors getCalendarColors() {
        try {
            return calendar.colors().get().execute();
        } catch (IOException ex) {
            LOG.error("Failed to retrieve event colors from Google Calendar API");
        }
        return null;
    }

    private DateTime createGoogleCalendarEventDateTime(LocalDate planningDate) {
        LocalDate localDate = new LocalDate(
                planningDate.getYear(),
                planningDate.getMonthOfYear(),
                planningDate.getDayOfMonth()
        );
        Locale locale = new Locale("Europe/Copenhagen");
        String parsedDate = localDate.toString("yyyy-MM-dd", locale);
        return new DateTime(parsedDate);
    }
}
