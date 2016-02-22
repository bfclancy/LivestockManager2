package com.example.asus.livestockmanager;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import BusinessEntities.Cattle;
import BusinessEntities.DateFormatter;
import DataAccessLayer.ExpandableListDataAdapter;
import DataAccessLayer.LivestockManagerDatabaseOperations;

public class LivestockListActivity extends AppCompatActivity {

    ExpandableListDataAdapter expandableListDataAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livestock_list);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListViewLivestock);
        prepareListData();

        expandableListDataAdapter = new ExpandableListDataAdapter(this, listDataHeader, listDataChild);

        expandableListView.setAdapter(expandableListDataAdapter);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();
        List<Cattle> animalDetails;

        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        animalDetails = livestockManagerDatabaseOperations.getAllLivestock(sqLiteDatabase);

        for(Cattle cattle : animalDetails) {
            listDataHeader.add(cattle.getTagNumber());
        }

        for(int i = 0; i < listDataHeader.size(); i ++) {

            List<Cattle> cattleDetails = livestockManagerDatabaseOperations.getAllLivestockByTagNumber(listDataHeader.get(i), sqLiteDatabase);
            List<String> list = new ArrayList<>();
            for(Cattle c : cattleDetails) {
                list.add(0,"Gender: " + c.getGender());
                list.add(1,"Date of Birth: " + DateFormatter.formatForDisplay(c.getDateOfBirth().toString()));
                list.add(2,"Last Tb TestResults: " + DateFormatter.formatForDisplay(c.getDateLastTBTest().toString()));
                list.add(3, "Date Moved In: " + DateFormatter.formatForDisplay(c.getDateMovedIn().toString()));
                list.add(4, "Sire: " + c.getSire());
                list.add(5, "Sire Breed: " + c.getSireBreed());
                list.add(6, "Dam Tag Number: " + c.getDamTagNumber());
            }
            listDataChild.put(listDataHeader.get(i), list);
        }

    }
}
