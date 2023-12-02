package application.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateParser {
    private static final String pattern = "yyyy-MM-dd";

    public static Date parseString(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
