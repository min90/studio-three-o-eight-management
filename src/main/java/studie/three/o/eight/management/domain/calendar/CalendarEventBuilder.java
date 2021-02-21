package studie.three.o.eight.management.domain.calendar;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
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
        ArrayList<Planning> plannings = client.getPlannings();
        for (Planning planning : plannings) {
            try {
                Event event = new Event();
                if (client.getCity() != null && client.getRoadName() != null && client.getZipCode() > 0) {
                    event.setLocation(String.format("%s, %s, %s", client.getRoadName(),
                            client.getCity(), client.getZipCode()));
                }
                if (planning.getPortraitDate() != null) {
                    event.setDescription(String.format("Portræt fotografering for %s", client.getName()));
                    DateTime portraitDateTime = new DateTime(planning.getPortraitDate().toDate());
                    EventDateTime start = new EventDateTime()
                            //.setDateTime(portraitDateTime)
                            .setDate(portraitDateTime)
                            .setTimeZone("Europe/Copenhagen");
                    event.setStart(start);

//                    DateTime endPortraitDateTime = new DateTime(planning.getPortraitDate().toString());
//                    EventDateTime end = new EventDateTime()
//                            .setDateTime(endPortraitDateTime)
//                            .setTimeZone("Europe/Copenhagen");
//                    event.setEnd(end);
                    calendar.events().insert(calendarId, event);
                }
            } catch (Exception ex) {
                LOG.error("Failed to insert event for {}", client.getName(), ex);
            }
        }
    }
}
