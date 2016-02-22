package com.example.asus.livestockmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FinanceActivity extends AppCompatActivity implements View.OnClickListener{

    Button button[] = new Button[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);

        button[0] = (Button) findViewById(R.id.buttonNewIncomeActivity);
        button[1] = (Button) findViewById(R.id.buttonNewExpenditureActivity);
        button[2] = (Button) findViewById(R.id.buttonViewIncome);
        button[3] = (Button) findViewById(R.id.buttonViewExpenditure);
        button[4] = (Button) findViewById(R.id.buttonBalanceSheet);

        for(int i = 0; i < button.length; i ++) {
            button[i].setOnClickListener(this);
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonNewIncomeActivity:
                buttonNewIncomeActivityClick();
                break;

            case R.id.buttonNewExpenditureActivity:
                buttonNewExpenditureActivityClick();
                break;

            case R.id.buttonViewIncome:
                buttonViewIncomeActivityClick();
                break;

            case R.id.buttonViewExpenditure:
                buttonViewExpenditureClick();
                break;

            case R.id.buttonBalanceSheet:
                buttonBalanceSheetClick();
                break;
        }
    }

    private void buttonNewIncomeActivityClick() {
        startActivity(new Intent("android.intent.action.AddIncomeActivity"));
    }

    private void buttonNewExpenditureActivityClick() {
        startActivity(new Intent("android.intent.action.AddExpenditureActivity"));
    }

    private void buttonViewIncomeActivityClick() {
        startActivity(new Intent("android.intent.action.ViewIncomeActivity"));
    }

    private void buttonViewExpenditureClick() {
        startActivity(new Intent("android.intent.action.ViewExpenditureActivity"));
    }

    private void buttonBalanceSheetClick() {
        startActivity(new Intent("android.intent.action.BalanceSheetActivity"));
    }
}

