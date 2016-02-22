package com.example.asus.livestockmanager;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import BusinessEntities.DateFormatter;

public class AlarmIntentService extends IntentService {

    private String appointmentType, appointmentDate, appointmentTime;

    public AlarmIntentService() {
        super("AlarmIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Bundle extras = intent.getExtras();
        if(extras != null){
            appointmentType = extras.getString("AppointmentType");
            appointmentDate = extras.getString("AppointmentDate");
            appointmentTime = extras.getString("AppointmentTime");

        }
        TelephonyManager tMgr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String mPhoneNumber = tMgr.getLine1Number();
        String phoneNumberReceiver=mPhoneNumber;
        String message="Reminder! You have a " + appointmentType + " appointment scheduled for today the " + DateFormatter.formatForDisplay(appointmentDate) + ", at " + appointmentTime;
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumberReceiver, null, message, null, null);
    }
}
