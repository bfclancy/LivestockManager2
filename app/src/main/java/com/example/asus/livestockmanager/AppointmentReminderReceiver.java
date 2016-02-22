package com.example.asus.livestockmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import java.sql.Time;

import static android.support.v4.content.WakefulBroadcastReceiver.startWakefulService;

public class AppointmentReminderReceiver extends BroadcastReceiver {
    public AppointmentReminderReceiver() {
    }

    private String appointmentType, appointmentDate, appointmentTime;
    private AlarmManager am;
    private PendingIntent alarmIntent;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Bundle extras = intent.getExtras();
        if(extras != null){
            appointmentType = extras.getString("AppointmentType");
            appointmentDate = extras.getString("AppointmentDate");
            appointmentTime = extras.getString("AppointmentTime");

        }
        Intent service = new Intent(context, AlarmIntentService.class).putExtra("AppointmentType",appointmentType).putExtra("AppointmentDate",appointmentDate.toString())
                .putExtra("AppointmentTime", appointmentTime);
        startWakefulService(context, service);
    }

    public void setAlarm(Context context, Long apptime, String appdate, String apptype){

        am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        long alertTime = apptime - 30 * 60 * 1000;
        Time time = new Time(apptime);

        Intent intentAlarm = new Intent(context, AppointmentReminderReceiver.class).putExtra("AppointmentType",apptype).putExtra("AppointmentDate",appdate)
                .putExtra("AppointmentTime",time.toString());
        alarmIntent = PendingIntent.getBroadcast(context, 0, intentAlarm, 0);

        am.set(AlarmManager.RTC_WAKEUP, alertTime, alarmIntent.getBroadcast(context, 1, intentAlarm, alarmIntent.FLAG_UPDATE_CURRENT));
    }
}
