package com.example.asus.livestockmanager;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import BusinessEntities.Appointment;
import BusinessEntities.DateFormatter;
import BusinessEntities.TimeFormatter;
import DataAccessLayer.ExpandableListDataAdapter;
import DataAccessLayer.LivestockManagerDatabaseOperations;

public class ViewAppointmentsActivity extends AppCompatActivity {

    ExpandableListDataAdapter expandableListDataAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_appointments);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListViewAppointments);
        prepareListData();

        expandableListDataAdapter = new ExpandableListDataAdapter(this, listDataHeader, listDataChild);

        expandableListView.setAdapter(expandableListDataAdapter);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();
        List<Appointment> appointments;

        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        appointments = livestockManagerDatabaseOperations.getAllAppointmentDetails(sqLiteDatabase);

        for(Appointment a : appointments) {
            listDataHeader.add("ID: " + a.getAppointmentId());
        }

        for(int i = 0; i < listDataHeader.size(); i ++) {
            List<String> list = new ArrayList<>();
            for(Appointment app : appointments) {
                if (listDataHeader.get(i).equals("ID: " + app.getAppointmentId())) {
                    list.add(0, "Date: " + String.valueOf(app.getDate()));
                    list.add(1, "Time: " + String.valueOf(app.getTime()));
                    list.add(2, "Description: " + app.getType());
                }
            }
            listDataChild.put(listDataHeader.get(i), list);
        }
    }

}
