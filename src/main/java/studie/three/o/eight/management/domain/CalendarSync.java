package studie.three.o.eight.management.domain;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

public class CalendarSync {

    private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR);
    private static final String CREDENTIALS_FILE_PATH = "/photo-management-267621-641748de6905.json";

    public static void main(String[] args) {
        // Build a new authorized API client service.
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

            InputStream in = CalendarSync.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
            if (in == null) {
                throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
            }

            GoogleCredential credential = GoogleCredential.fromStream(in)
                    .createScoped(SCOPES);

            Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                    .setApplicationName(APPLICATION_NAME)
                    .build();

            Event event = new Event()
                    .setSummary("Google I/O 2015")
                    .setLocation("800 Howard St., San Francisco, CA 94103")
                    .setDescription("A chance to hear more about Google's developer products.");

            DateTime startDateTime = new DateTime("2021-02-28T09:00:00-07:00");
            EventDateTime start = new EventDateTime()
                    .setDateTime(startDateTime)
                    .setTimeZone("America/Los_Angeles");
            event.setStart(start);

            DateTime endDateTime = new DateTime("2021-02-28T17:00:00-07:00");
            EventDateTime end = new EventDateTime()
                    .setDateTime(endDateTime)
                    .setTimeZone("America/Los_Angeles");
            event.setEnd(end);

            String calendarId = "jems.minor@gmail.com";
            service.events().insert(calendarId, event).execute();
        } catch (IOException | GeneralSecurityException e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }


}
