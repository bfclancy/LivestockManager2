package com.example.asus.livestockmanager;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import BusinessEntities.DateFormatter;
import BusinessEntities.Income;
import DataAccessLayer.ExpandableListDataAdapter;
import DataAccessLayer.LivestockManagerDatabaseOperations;

public class ViewIncomeActivity extends AppCompatActivity {

    ExpandableListDataAdapter expandableListDataAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_income);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListViewIncomes);
        prepareListData();

        expandableListDataAdapter = new ExpandableListDataAdapter(this, listDataHeader, listDataChild);

        expandableListView.setAdapter(expandableListDataAdapter);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();
        List<Income> incomes;

        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        incomes = livestockManagerDatabaseOperations.getAllIncomes(sqLiteDatabase);

        for(Income i : incomes) {
            listDataHeader.add("ID: " + i.getIncomeId());
        }

        for(int i = 0; i < listDataHeader.size(); i ++) {
            List<String> list = new ArrayList<>();
            for(Income inc : incomes) {
                if (listDataHeader.get(i).equals("ID: " + (String.valueOf(inc.getIncomeId())))) {
                    list.add(0, "Date: " + DateFormatter.formatForDisplay(String.valueOf(inc.getIncomeDate())));
                    list.add(1, "Amount: " + String.valueOf(inc.getIncomeAmount()));
                    list.add(2, "Description: " + inc.getIncomeDescription());
                }
            }
            listDataChild.put(listDataHeader.get(i), list);
        }
    }
}
