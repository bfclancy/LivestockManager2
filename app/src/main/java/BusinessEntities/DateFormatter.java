package BusinessEntities;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by asus on 03/02/2016.
 */
public class DateFormatter {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
    private static final SimpleDateFormat displayFormat = new SimpleDateFormat("EE MMM dd", Locale.ENGLISH);
    private static final SimpleDateFormat editTextFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");

    public static Date convertStringToDate(String date){
        if(date != null){
            try {
                return FORMATTER.parse(date);
            } catch (ParseException e) {
                // nothing we can do if the input is invalid
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static String formatForDisplay(String date){
        if(date != null){
            try {
                Date newDate =  FORMATTER.parse(date);
                String stringDate = format.format(newDate);
                return stringDate;
            } catch (ParseException e) {
                // nothing we can do if the input is invalid
                throw new RuntimeException("Date was unparseable");
            }
        }
        return null;
    }

    public static Date formatEditTextDate(String date){
        if(date != null){
            try {
                return editTextFormat.parse(date);
            } catch (ParseException e) {
                // nothing we can do if the input is invalid
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static Date formatDateForStoring(Date date){
        if(date!=null){
            try {
                String dateString = new SimpleDateFormat("yyyyMMdd").format(date);
                System.out.println(dateString);
                Date date2 = new SimpleDateFormat("yyyyMMdd").parse(dateString);
                return date2;
            } catch (ParseException e) {
                // nothing we can do if the input is invalid
                throw new RuntimeException(e);
            }
        }
        return null;
        }

}
