package studie.three.o.eight.management.domain.persistence.formatter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

public class LocalDateFormatter implements DynamoDBTypeConverter<String, LocalDate> {

    @Override
    public String convert(LocalDate object) {
        Locale locale = new Locale("Europe/Copenhagen");
        return object.toString("yyyy-MM-dd", locale);
    }

    @Override
    public LocalDate unconvert(String object) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        return LocalDate.parse(object, formatter);
    }
}

