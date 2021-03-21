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
import java.util.UUID;

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

        // Set Location
        String location = "N/A";
        if (client.getCity() != null && client.getRoadName() != null && client.getZipCode() != null) {
            location = String.format("%s, %s, %s", client.getRoadName(), client.getCity(), client.getZipCode());
        }

        for (Planning planning : plannings) {
            try {
                if (planning.getPortraitDate() != null) {
                    String summary = "Portræt fotografering";
                    String description = String.format("Portræt fotografering for %s", client.getName());
                    Event portraitEvent = createGoogleCalendarEvent(planning.getPortraitDate(), colorId, location, summary, description, client.getName(), PlanningEvent.PORTRAIT);
                    calendar.events().insert(calendarId, portraitEvent).execute();
                }
                if (planning.getNaturePortraitDate() != null) {
                    String summary = "Naturportræt fotografering";
                    String description = String.format("Naturportræt fotografering for %s", client.getName());
                    Event natureEvent = createGoogleCalendarEvent(planning.getNaturePortraitDate(), colorId, location, summary, description, client.getName(), PlanningEvent.NATURE_PORTRAIT);
                    calendar.events().insert(calendarId, natureEvent).execute();
                }
                if (planning.getGroupPhotoDate() != null) {
                    String summary = "Gruppefotografering";
                    String description = String.format("Gruppefotografering for %s", client.getName());
                    Event groupPhotoDate = createGoogleCalendarEvent(planning.getGroupPhotoDate(), colorId, location, summary, description, client.getName(), PlanningEvent.GROUP_PHOTO);
                    calendar.events().insert(calendarId, groupPhotoDate).execute();
                }
                if (planning.getStaffPortraitDate() != null) {
                    String summary = "Personalefotografering";
                    String description = String.format("Personalefotografering for %s", client.getName());
                    Event staffPortrait = createGoogleCalendarEvent(planning.getStaffPortraitDate(), colorId, location, summary, description, client.getName(), PlanningEvent.STAFF_PORTRAIT);
                    calendar.events().insert(calendarId, staffPortrait).execute();
                }
                if (planning.getStaffGroupDate() != null) {
                    String summary = "Personale gruppefotografering";
                    String description = String.format("Personale gruppefotografering for %s", client.getName());
                    Event staffGroup = createGoogleCalendarEvent(planning.getStaffGroupDate(), colorId, location, summary, description, client.getName(), PlanningEvent.STAFF_GROUP);
                    calendar.events().insert(calendarId, staffGroup).execute();
                }
                if (planning.getTotalPhotoDate() != null) {
                    String summary = "Totalbillede";
                    String description = String.format("Totalbillede for %s", client.getName());
                    Event totalPhoto = createGoogleCalendarEvent(planning.getTotalPhotoDate(), colorId, location, summary, description, client.getName(), PlanningEvent.TOTAL_PHOTO);
                    calendar.events().insert(calendarId, totalPhoto).execute();
                }
                if (planning.getAirPhotoDate() != null) {
                    String summary = "Luftfotografering";
                    String description = String.format("Luftfotografering for %s", client.getName());
                    Event airPhoto = createGoogleCalendarEvent(planning.getAirPhotoDate(), colorId, location, summary, description, client.getName(), PlanningEvent.AIR_PHOTO);
                    calendar.events().insert(calendarId, airPhoto).execute();
                }
                if (planning.getIntroVideoDate() != null) {
                    String summary = "Introvideo";
                    String description = String.format("Introvideo for %s", client.getName());
                    Event introVideo = createGoogleCalendarEvent(planning.getIntroVideoDate(), colorId, location, summary, description, client.getName(), PlanningEvent.INTRO_VIDEO);
                    calendar.events().insert(calendarId, introVideo).execute();
                }
                if (planning.getConfirmDate() != null) {
                    String summary = "Bekræftelsesdato";
                    String description = String.format("Bekræftelsesdato for %s", client.getName());
                    Event confirm = createGoogleCalendarEvent(planning.getConfirmDate(), colorId, location, summary, description, client.getName(), PlanningEvent.CONFIRM);
                    calendar.events().insert(calendarId, confirm).execute();
                }
                if (planning.getSignupMaterialDate() != null) {
                    String summary = "Tilmeldingsmateriale";
                    String description = String.format("Tilmeldingsmateriale for %s", client.getName());
                    Event signupMaterial = createGoogleCalendarEvent(planning.getSignupMaterialDate(), colorId, location, summary, description, client.getName(), PlanningEvent.SIGNUP_MATERIAL);
                    calendar.events().insert(calendarId, signupMaterial).execute();
                }
                if (planning.getUpdateEmailDate() != null) {
                    String summary = "Opdater email";
                    String description = String.format("Opdater email for %s", client.getName());
                    Event updateEmail = createGoogleCalendarEvent(planning.getUpdateEmailDate(), colorId, location, summary, description, client.getName(), PlanningEvent.UPDATE_EMAIL);
                    calendar.events().insert(calendarId, updateEmail).execute();
                }
                if (planning.getUpdateEmailDate() != null) {
                    String summary = "Deadline";
                    String description = String.format("Deadline for %s", client.getName());
                    Event dueDate = createGoogleCalendarEvent(planning.getDueDate(), colorId, location, summary, description, client.getName(), PlanningEvent.DUE_DATE);
                    calendar.events().insert(calendarId, dueDate).execute();
                }
                if (planning.getSendPackageDate() != null) {
                    String summary = "Udsend materiale";
                    String description = String.format("Udsend materiale for %s", client.getName());
                    Event sendPackage = createGoogleCalendarEvent(planning.getSendPackageDate(), colorId, location, summary, description, client.getName(), PlanningEvent.SEND_PACKAGE);
                    calendar.events().insert(calendarId, sendPackage).execute();
                }
                if (planning.getExpirationDate() != null) {
                    String summary = "Udløbsdato";
                    String description = String.format("Udløbsdato for %s", client.getName());
                    Event expiration = createGoogleCalendarEvent(planning.getExpirationDate(), colorId, location, summary, description, client.getName(), PlanningEvent.EXPIRATION);
                    calendar.events().insert(calendarId, expiration).execute();
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

    private Event createGoogleCalendarEvent(LocalDate planningDate,
                                            String colorId,
                                            String location,
                                            String summary,
                                            String description,
                                            String clientId,
                                            PlanningEvent planningEvent) {
        Event event = new Event();
        String parsedClientId = clientId.substring(0, clientId.length() - 1);
        String eventId = String.format("%s%s", parsedClientId, planningEvent.ordinal());

        event.setId(UUID.randomUUID().toString());
        event.setLocation(location);
        event.setSummary(summary);
        event.setDescription(description);
        LocalDate localDate = new LocalDate(
                planningDate.getYear(),
                planningDate.getMonthOfYear(),
                planningDate.getDayOfMonth()
        );
        Locale locale = new Locale("Europe/Copenhagen");
        String parsedDate = localDate.toString("yyyy-MM-dd", locale);
        DateTime portraitCalendarDate = new DateTime(parsedDate);

        EventDateTime start = new EventDateTime()
                .setDate(portraitCalendarDate)
                .setTimeZone("Europe/Copenhagen");
        event.setStart(start);
        event.setEnd(start);
        event.setColorId(colorId);
        return event;
    }
}
