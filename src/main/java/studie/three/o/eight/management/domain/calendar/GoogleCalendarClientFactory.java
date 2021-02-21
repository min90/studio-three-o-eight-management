package studie.three.o.eight.management.domain.calendar;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import studie.three.o.eight.management.domain.CalendarSync;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Factory
public class GoogleCalendarClientFactory {
    private static final Logger LOG = LoggerFactory.getLogger(GoogleCalendarClientFactory.class);
    private static final String APPLICATION_NAME = "StudioThree0EightManagement";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR);
    private static final String CREDENTIALS_FILE_PATH = "/photo-management-267621-641748de6905.json";

    @Bean
    Calendar calendarClient() {
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

            InputStream in = CalendarSync.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
            if (in == null) {
                throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
            }

            GoogleCredential credential = GoogleCredential.fromStream(in)
                    .createScoped(SCOPES);

            return new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        } catch (Exception ex) {
            LOG.error("Failed to instantiate Google Calendar Client", ex);
            return null;
        }
    }
}
