package com.example.asus.livestockmanager;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import BusinessLogic.Controller;

public class BalanceSheetActivity extends AppCompatActivity {

    EditText etTotalIncome, etTotalexpenditure, etBalance;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_sheet);

        etTotalIncome = (EditText) findViewById(R.id.editTextIncomeTotal);
        etTotalexpenditure = (EditText) findViewById(R.id.editTextExpenditureTotal);
        etBalance = (EditText) findViewById(R.id.editTextBalance);

        double totalIncome = Controller.getTotalIncome(context);
        double totalExpenditure = Controller.getTotalExpenditure(context);
        double balance = totalIncome - totalExpenditure;

        etTotalIncome.setText(String.valueOf(totalIncome));
        etTotalexpenditure.setText(String.valueOf(totalExpenditure));
        etBalance.setText(String.valueOf(balance));
    }


}
