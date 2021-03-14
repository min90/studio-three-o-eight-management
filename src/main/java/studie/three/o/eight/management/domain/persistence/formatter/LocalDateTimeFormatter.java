package studie.three.o.eight.management.domain.persistence.formatter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

public class LocalDateTimeFormatter implements DynamoDBTypeConverter<String, LocalDateTime> {
    @Override
    public String convert(LocalDateTime object) {
        Locale locale = new Locale("Europe/Copenhagen");
        return object.toString("yyyy-MM-dd HH:mm:ss", locale);
    }

    @Override
    public LocalDateTime unconvert(String object) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(object, formatter);
    }
}
