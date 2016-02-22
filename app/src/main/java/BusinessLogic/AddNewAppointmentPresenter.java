package BusinessLogic;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.asus.livestockmanager.AppointmentReminderReceiver;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import BusinessEntities.Appointment;
import BusinessEntities.DateFormatter;
import DataAccessLayer.LivestockManagerDatabaseOperations;

/**
 * Created by asus on 18/02/2016.
 */
public class AddNewAppointmentPresenter {


    public boolean addAppointmentToDB(Appointment appointment, Context context){
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getWritableDatabase();
        try {
            livestockManagerDatabaseOperations.addAppointment(appointment, sqLiteDatabase);
            //livestockManagerDatabaseOperations.deleteOldAppointments(sqLiteDatabase, date);
            return true;
        }catch(Exception e){
            Log.d("DB Appointment Error", e.toString());
            return false;
        }finally{
            livestockManagerDatabaseOperations.close();
        }
    }

    public boolean createAppointmentReminder(Appointment appointment, int year, int month, int day, String timeString, Context context){

        String[] timeStringParts = timeString.split(":");
        int hours1 = Integer.parseInt(timeStringParts[0]);
        int hours = Integer.parseInt(timeStringParts[0]) - 1;
        int minutes = Integer.parseInt(timeStringParts[1]);
        Time time = new Time((hours * 60 * 60 * 1000) + (minutes * 60 * 1000));
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hours1, minutes, 0);
        long startTime = calendar.getTimeInMillis();
        AppointmentReminderReceiver ar = new AppointmentReminderReceiver();
        ar.setAlarm(context, startTime, appointment.getDate().toString(), appointment.getType());
        return true;
    }
}
