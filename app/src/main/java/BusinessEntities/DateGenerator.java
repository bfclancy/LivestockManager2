package BusinessEntities;

import android.widget.DatePicker;

import java.util.Date;

/**
 * Created by asus on 02/02/2016.
 */
public class DateGenerator {

    public static Date generateDate(DatePicker dp){
        Date date = new Date(dp.getYear() - 1900, dp.getMonth(), dp.getDayOfMonth());
        return date;
    }
}
