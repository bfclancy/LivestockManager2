package com.example.asus.livestockmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ReportsActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonTestTrend, buttonCostPerHead, buttonIncomeVExpenditure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        buttonTestTrend = (Button) findViewById(R.id.buttonTestTrends);
        buttonCostPerHead = (Button) findViewById(R.id.buttonCostPerHead);
        buttonIncomeVExpenditure = (Button) findViewById(R.id.buttonBeefPrices);
        buttonTestTrend.setOnClickListener(this);
        buttonCostPerHead.setOnClickListener(this);
        buttonIncomeVExpenditure.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonTestTrends:
                buttonTestTrendsClick();
                break;

            case R.id.buttonCostPerHead:
                buttonCostPerHeadClick();
                break;

            case R.id.buttonBeefPrices:
                buttonIncomeVExpenditureClick();
                break;
        }
    }

    private void buttonTestTrendsClick(){
        startActivity(new Intent("android.intent.action.BeefPriceChartActivity"));
    }

    private void buttonCostPerHeadClick(){
        startActivity(new Intent("android.intent.action.SpendingPerHeadChartActivity"));
    }

    private void buttonIncomeVExpenditureClick(){
        startActivity(new Intent("android.intent.action.IncomeVExpenditureChartActivity"));
    }
}
