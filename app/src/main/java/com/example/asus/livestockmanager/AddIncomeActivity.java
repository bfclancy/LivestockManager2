package com.example.asus.livestockmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;

import BusinessEntities.DateFormatter;
import BusinessEntities.Income;
import BusinessLogic.AddIncomePresenter;
import BusinessLogic.Controller;
import DataAccessLayer.LivestockManagerDatabaseOperations;

public class AddIncomeActivity extends AppCompatActivity implements View.OnClickListener{

    private SharedPreferences preferences = null;
    private String herdNumber;
    private String myPreferences = "Login Credentials";
    private Button buttonAddIncomeToDB;
    private EditText editTextIncomeAmount, editTextIncomeDate;
    private Spinner spinnerIncomeTypes;
    private Context context = this;
    private AddIncomePresenter addIncomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addIncomePresenter = new AddIncomePresenter();

        preferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        herdNumber = preferences.getString("herdNumber", "");
        setContentView(R.layout.activity_add_income);

        buttonAddIncomeToDB = (Button) findViewById(R.id.buttonConfirmNewIncome);
        buttonAddIncomeToDB.setOnClickListener(this);

        editTextIncomeAmount = (EditText) findViewById(R.id.editTextIncomeAmount);
        editTextIncomeDate = (EditText) findViewById(R.id.editTextIncomeDate);

        spinnerIncomeTypes = (Spinner) findViewById(R.id.spinnerIncomeTypes);
        spinnerIncomeTypes.setAdapter(addIncomePresenter.getIncomeTypes(context));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonConfirmNewIncome:
                buttonAddIncomeToDBClick();
                break;

            case R.id.buttonCancelNewIncome:
                buttonCancelNewIncomeClick();
                break;
        }
    }

    private void buttonCancelNewIncomeClick() {
        Toast.makeText(context, "New Income Cancelled", Toast.LENGTH_LONG).show();
        finish();
    }

    private void buttonAddIncomeToDBClick() {

        double amount = Double.parseDouble(editTextIncomeAmount.getText().toString());
        String description = spinnerIncomeTypes.getSelectedItem().toString();
        Date date = DateFormatter.formatEditTextDate(editTextIncomeDate.getText().toString());

        Income income = new Income(0,date, amount, description, herdNumber);

        addIncomePresenter.addIncomeToDB(income, context);
        Toast.makeText(context, "New Income Added", Toast.LENGTH_LONG).show();
        finish();
    }
}
