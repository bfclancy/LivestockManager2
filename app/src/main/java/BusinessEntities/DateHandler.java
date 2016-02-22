package BusinessEntities;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by asus on 06/02/2016.
 */
public class DateHandler {

    public static Date changeDate(Date originalDate, int change){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(originalDate);
        calendar.add(Calendar.MONTH, +9);
        return calendar.getTime();
    }
}
