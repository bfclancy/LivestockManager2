package com.example.asus.livestockmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import BusinessEntities.Appointment;
import BusinessEntities.DateFormatter;
import BusinessEntities.DateGenerator;
import BusinessLogic.AddNewAppointmentPresenter;

public class AddNewAppointmentActivity extends AppCompatActivity implements View.OnClickListener{

    private SharedPreferences preferences = null;
    private String herdNumber, description;
    private String myPreferences = "Login Credentials";
    private Context context = this;
    private Button buttonAddAppointment, buttonCancelAppointment;
    private DatePicker datePickerAppointment;
    private EditText editTextAppointmentType, editTextAppointmentTime;
    private AddNewAppointmentPresenter addNewAppointmentPresenter;
    private AppointmentReminderReceiver ar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);

        addNewAppointmentPresenter = new AddNewAppointmentPresenter();

        herdNumber = preferences.getString("herdNumber", "");
        setContentView(R.layout.activity_add_new_appointment);
        buttonAddAppointment = (Button) findViewById(R.id.buttonAddVetAppointment);
        buttonCancelAppointment = (Button) findViewById(R.id.buttonCancelAppointment);
        datePickerAppointment = (DatePicker) findViewById(R.id.datePicker);
        editTextAppointmentType = (EditText) findViewById(R.id.editTextAppointmentType);
        editTextAppointmentTime = (EditText) findViewById(R.id.etNewAppointmentTime);
        buttonAddAppointment.setOnClickListener(this);
        buttonCancelAppointment.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAddVetAppointment:
                buttonAddVetAppointmentClick();
                break;
        }
    }

    private void buttonAddVetAppointmentClick() {
        String timeString = editTextAppointmentTime.getText().toString();
        String[] timeStringParts = editTextAppointmentTime.getText().toString().split(":");
        int hours = Integer.parseInt(timeStringParts[0]) - 1;
        int minutes = Integer.parseInt(timeStringParts[1]);
        Time time = new Time((hours * 60 * 60 * 1000) + (minutes * 60 * 1000));
        Date date = DateGenerator.generateDate(datePickerAppointment);
        Appointment appointment = new Appointment(0, editTextAppointmentType.getText().toString(),time, date, herdNumber);
        if(addNewAppointmentPresenter.addAppointmentToDB(appointment, context)){
            Toast.makeText(getBaseContext(), "New appointment added!", Toast.LENGTH_LONG).show();
            finish();
        }
        else{
            Toast.makeText(getBaseContext(), "Error! Appointment Not added", Toast.LENGTH_LONG).show();
        }
        if(addNewAppointmentPresenter.createAppointmentReminder(appointment, datePickerAppointment.getYear(), datePickerAppointment.getMonth(), datePickerAppointment.getDayOfMonth(),timeString, context)){
            Toast.makeText(getBaseContext(), "Appointment Reminder Set", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getBaseContext(), "Error! Appointment Reminder Not Set", Toast.LENGTH_LONG).show();
        }
    }
}

