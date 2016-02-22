package com.example.asus.livestockmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TasksActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonNewVetAppointment, buttonViewVetAppointments, buttonTestResults, buttonFindAVet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        buttonNewVetAppointment = (Button) findViewById(R.id.buttonNewVetAppointment);
        buttonViewVetAppointments = (Button) findViewById(R.id.buttonViewVetVisits);
        buttonTestResults = (Button) findViewById(R.id.buttonTestResults);
        buttonFindAVet = (Button) findViewById(R.id.buttonFindAVet);

        buttonNewVetAppointment.setOnClickListener(this);
        buttonViewVetAppointments.setOnClickListener(this);
        buttonTestResults.setOnClickListener(this);
        buttonFindAVet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonNewVetAppointment:
                buttonNewVetAppointmentClick();
                break;

            case R.id.buttonViewVetVisits:
                buttonViewVetAppointmentClick();
                break;

            case R.id.buttonTestResults:
                buttonTestResultsClick();
                break;

            case R.id.buttonFindAVet:
                buttonFindAVetClick();
        }
    }

    private void buttonNewVetAppointmentClick() {
        startActivity(new Intent("android.intent.action.AddNewAppointmentActivity"));
    }

    private void buttonViewVetAppointmentClick() {
        startActivity(new Intent("android.intent.action.ViewAppointmentsActivity"));
    }

    private void buttonTestResultsClick(){
        startActivity(new Intent("android.intent.action.RecordTestResultsActivity"));
    }

    private void buttonFindAVetClick(){
        startActivity(new Intent("android.intent.action.VetMapActivity"));
    }
}
