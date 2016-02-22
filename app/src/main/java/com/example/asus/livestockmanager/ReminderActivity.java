package com.example.asus.livestockmanager;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ReminderActivity extends AppCompatActivity {

    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(1000);
        String phoneNumberReceiver="+353876502169";
        String message="Hi, this is just a reminder of your appointment";
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumberReceiver, null, message, null, null);
        // Show the toast  like in above screen shot
        Toast.makeText(this, "Alarm Triggered and SMS Sent", Toast.LENGTH_LONG).show();
    }
}
