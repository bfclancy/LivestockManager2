package BusinessEntities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by asus on 16/02/2016.
 */
public class TimeFormatter {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
    private static final SimpleDateFormat TIMEFORMATTER = new SimpleDateFormat("hh:mm:ss");

    public static String formatTimeForDisplay(String time){
        if(time != null){
            try {
                Date newDate =  FORMATTER.parse(time);
                String stringDate = TIMEFORMATTER.format(newDate);
                return stringDate;
            } catch (ParseException e) {
                // nothing we can do if the input is invalid
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
