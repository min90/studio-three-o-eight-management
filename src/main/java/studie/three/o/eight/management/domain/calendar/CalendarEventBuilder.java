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
import studie.three.o.eight.management.domain.Revenue;
import studie.three.o.eight.management.domain.Staff;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

@Singleton
public class CalendarEventBuilder {
    private static final String ACTION_COLOR = "6";
    private static final String OPERATION_COLOR = "12";
    private static final Logger LOG = LoggerFactory.getLogger(CalendarEventBuilder.class);

    private final Calendar calendar;

    @Inject
    public CalendarEventBuilder(Calendar calendar) {
        this.calendar = calendar;
    }

    public void createEventForClient(Client client, String calendarId, String photographer) {
        ArrayList<Planning> plannings = client.getPlannings();

        // Set Location
        String location = "N/A";
        if (client.getCity() != null && client.getRoadName() != null && client.getZipCode() != null) {
            location = String.format("%s, %s, %s", client.getRoadName(), client.getCity(), client.getZipCode());
        }

        for (Planning planning : plannings) {
            try {
                if (planning.getPortraitDate() != null) {
                    String summary = String.format("%s - %s - %s", photographer, client.getName(), "PB");
                    Event portraitEvent = createGoogleCalendarEvent(planning.getPortraitDate(),
                            getColorBasedOnAction(PlanningEvent.PORTRAIT),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.PORTRAIT);
                    calendar.events().insert(calendarId, portraitEvent).execute();
                }
                if (planning.getNaturePortraitDate() != null) {
                    String summary = String.format("%s - %s - %s", photographer, client.getName(), "Portræt");
                    Event natureEvent = createGoogleCalendarEvent(planning.getNaturePortraitDate(),
                            getColorBasedOnAction(PlanningEvent.NATURE_PORTRAIT),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.NATURE_PORTRAIT);
                    calendar.events().insert(calendarId, natureEvent).execute();
                }
                if (planning.getGroupPhotoDate() != null) {
                    String summary = String.format("%s - %s - %s", photographer, client.getName(), "GRP");
                    Event groupPhotoDate = createGoogleCalendarEvent(planning.getGroupPhotoDate(),
                            getColorBasedOnAction(PlanningEvent.GROUP_PHOTO),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.GROUP_PHOTO);
                    calendar.events().insert(calendarId, groupPhotoDate).execute();
                }
                if (planning.getStaffPortraitDate() != null) {
                    String summary = String.format("%s - %s - %s", photographer, client.getName(), "PP");
                    Event staffPortrait = createGoogleCalendarEvent(planning.getStaffPortraitDate(),
                            getColorBasedOnAction(PlanningEvent.STAFF_PORTRAIT),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.STAFF_PORTRAIT);
                    calendar.events().insert(calendarId, staffPortrait).execute();
                }
                if (planning.getStaffGroupDate() != null) {
                    String summary = String.format("%s - %s - %s", photographer, client.getName(), "PG");
                    Event staffGroup = createGoogleCalendarEvent(planning.getStaffGroupDate(),
                            getColorBasedOnAction(PlanningEvent.STAFF_GROUP),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.STAFF_GROUP);
                    calendar.events().insert(calendarId, staffGroup).execute();
                }
                if (planning.getTotalPhotoDate() != null) {
                    String summary = String.format("%s - %s - %s", photographer, client.getName(), "TB");
                    Event totalPhoto = createGoogleCalendarEvent(planning.getTotalPhotoDate(),
                            getColorBasedOnAction(PlanningEvent.TOTAL_PHOTO),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.TOTAL_PHOTO);
                    calendar.events().insert(calendarId, totalPhoto).execute();
                }
                if (planning.getAirPhotoDate() != null) {
                    String summary = String.format("%s - %s - %s", photographer, client.getName(), "Luftfoto");
                    Event airPhoto = createGoogleCalendarEvent(planning.getAirPhotoDate(),
                            getColorBasedOnAction(PlanningEvent.AIR_PHOTO),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.AIR_PHOTO);
                    calendar.events().insert(calendarId, airPhoto).execute();
                }
                if (planning.getIntroVideoDate() != null) {
                    String summary = "Introvideo";
                    Event introVideo = createGoogleCalendarEvent(planning.getIntroVideoDate(),
                            getColorBasedOnAction(PlanningEvent.INTRO_VIDEO),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.INTRO_VIDEO);
                    calendar.events().insert(calendarId, introVideo).execute();
                }
                if (planning.getConfirmDate() != null) {
                    String summary = "Bekræftelsesdato";
                    Event confirm = createGoogleCalendarEvent(planning.getConfirmDate(),
                            getColorBasedOnAction(PlanningEvent.CONFIRM),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.CONFIRM);
                    calendar.events().insert(calendarId, confirm).execute();
                }
                if (planning.getSignupMaterialDate() != null) {
                    String summary = "Tilmeldingsmateriale";
                    Event signupMaterial = createGoogleCalendarEvent(planning.getSignupMaterialDate(),
                            getColorBasedOnAction(PlanningEvent.SIGNUP_MATERIAL),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.SIGNUP_MATERIAL);
                    calendar.events().insert(calendarId, signupMaterial).execute();
                }
                if (planning.getUpdateEmailDate() != null) {
                    String summary = "Opdater email";
                    Event updateEmail = createGoogleCalendarEvent(planning.getUpdateEmailDate(),
                            getColorBasedOnAction(PlanningEvent.UPDATE_EMAIL),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.UPDATE_EMAIL);
                    calendar.events().insert(calendarId, updateEmail).execute();
                }
                if (planning.getUpdateEmailDate() != null) {
                    String summary = "Deadline";
                    Event dueDate = createGoogleCalendarEvent(planning.getDueDate(),
                            getColorBasedOnAction(PlanningEvent.DUE_DATE),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.DUE_DATE);
                    calendar.events().insert(calendarId, dueDate).execute();
                }
                if (planning.getSendPackageDate() != null) {
                    String summary = "Udsend materiale";
                    Event sendPackage = createGoogleCalendarEvent(planning.getSendPackageDate(),
                            getColorBasedOnAction(PlanningEvent.SEND_PACKAGE),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.SEND_PACKAGE);
                    calendar.events().insert(calendarId, sendPackage).execute();
                }
                if (planning.getExpirationDate() != null) {
                    String summary = "Udløbsdato";
                    Event expiration = createGoogleCalendarEvent(planning.getExpirationDate(),
                            getColorBasedOnAction(PlanningEvent.EXPIRATION),
                            location,
                            summary,
                            setDescription(client),
                            client.getName(),
                            PlanningEvent.EXPIRATION);
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

        //event.setId(UUID.randomUUID().toString());
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

    private String getColorBasedOnAction(PlanningEvent planningEvent) {
        switch (planningEvent) {
            case PORTRAIT:
            case NATURE_PORTRAIT:
            case GROUP_PHOTO:
            case STAFF_PORTRAIT:
            case STAFF_GROUP:
            case TOTAL_PHOTO:
                return ACTION_COLOR;
            default:
                return OPERATION_COLOR;
        }
    }

    private String setDescription(Client client) {
        Staff supervisor = client.getStaffs() == null ? null : client.getStaffs().stream().filter(Staff::isSupervisor).findFirst().orElse(null);
        Staff contactPerson = client.getStaffs() == null ? null : client.getStaffs().stream().filter(s -> !s.isSupervisor()).findFirst().orElse(null);
        int totalRevenue = 0;
        for (Revenue revenue : client.getRevenues()) {
            totalRevenue += revenue.getRevenue();
        }
        return String.format("Inst. Navn: %s \n\n" +
                "Leder: %s \n" +
                "Leder Tlf.: %s \n" +
                "Leder mail: %s \n\n" +
                "Kontakperson navn: %s \n" +
                "Kontakperson Tlf.: %s \n" +
                "Kontaktperson mail: %s \n\n" +
                "Kode til tilmelding: %s \n\n" +
                "Antal børn: %d \n" +
                "Antal grupper: %d \n" +
                "Antal personale: %d \n\n" +
                "Gruppenavne: %s \n\n" +
                "OMSÆTNING %d", client.getName(),
                supervisor == null ? "" : supervisor.getName(),
                supervisor == null ? "" : supervisor.getPhoneNumber(),
                supervisor == null ? "" : supervisor.getEmail(),
                contactPerson == null ? "" : contactPerson.getName(),
                contactPerson == null ? "" : contactPerson.getPhoneNumber(),
                contactPerson == null ? "" : contactPerson.getEmail(),
                client.getPassword(),
                client.getChildrenCount(),
                client.getGroupCount(),
                client.getStaffCount(),
                client.getGroups(),
                totalRevenue
                );
    }
}
