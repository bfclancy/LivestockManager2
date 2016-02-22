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

import BusinessEntities.DateFormatter;
import BusinessEntities.Expenditure;
import DataAccessLayer.ExpandableListDataAdapter;
import DataAccessLayer.LivestockManagerDatabaseOperations;

public class ViewExpenditureActivity extends AppCompatActivity {

    ExpandableListDataAdapter expandableListDataAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_expenditure);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListViewIncomes);
        prepareListData();

        expandableListDataAdapter = new ExpandableListDataAdapter(this, listDataHeader, listDataChild);

        expandableListView.setAdapter(expandableListDataAdapter);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();
        List<Expenditure> expenditures;

        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        expenditures = livestockManagerDatabaseOperations.getAllExpenditures(sqLiteDatabase);

        for(Expenditure e : expenditures) {
            listDataHeader.add("ID: " + e.getExpenditureId());
        }

        for(int i = 0; i < listDataHeader.size(); i ++) {
            List<String> list = new ArrayList<>();
            for(Expenditure exp : expenditures) {
                if (listDataHeader.get(i).equals("ID: " + (String.valueOf(exp.getExpenditureId())))) {
                    list.add(0, "Date: " + DateFormatter.formatForDisplay(String.valueOf(exp.getExpenditureDate())));
                    list.add(1, "Amount: " + String.valueOf(exp.getExpenditureAmount()));
                    list.add(2, "Description: " + exp.getExpenditureDescription());
                }
            }
            listDataChild.put(listDataHeader.get(i), list);
        }
    }
}
