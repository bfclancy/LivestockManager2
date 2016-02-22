package com.example.asus.livestockmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;

import BusinessEntities.DateFormatter;
import BusinessEntities.Expenditure;
import BusinessLogic.AddExpenditurePresenter;

public class AddExpenditureActivity extends AppCompatActivity implements View.OnClickListener{

    private SharedPreferences preferences = null;
    private String myPreferences = "Login Credentials";
    private Spinner spinnerExpenditureType;
    private Button buttonAddExpenditureToDB;
    private EditText editTextExpenditureAmount, editTextExpenditureDate;
    private Context context = this;
    private AddExpenditurePresenter addExpenditurePresenter;
    private String herdNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get herd number from preferences
        preferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        herdNumber = preferences.getString("herdNumber", "");

        setContentView(R.layout.activity_add_expenditure);

        //bind view elements to view xml
        buttonAddExpenditureToDB = (Button) findViewById(R.id.buttonConfirmNewExpenditure);
        buttonAddExpenditureToDB.setOnClickListener(this);

        editTextExpenditureAmount = (EditText) findViewById(R.id.editTextExpenditureAmount);
        editTextExpenditureDate = (EditText) findViewById(R.id.editTextExpenditureDate);

        //instantiate presenter
        addExpenditurePresenter = new AddExpenditurePresenter();

        //get values for spinner
        spinnerExpenditureType = (Spinner) findViewById(R.id.spinnerExpenditureDescription);
        spinnerExpenditureType.setAdapter(addExpenditurePresenter.getExpenditureTypes(context));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonConfirmNewExpenditure:
                buttonAddExpenditureToDBClick();
                break;
        }
    }

    private void buttonAddExpenditureToDBClick() {

        //get values for new expenditure object
        double amount = Double.parseDouble(editTextExpenditureAmount.getText().toString());
        String description = spinnerExpenditureType.getSelectedItem().toString();
        Date date = DateFormatter.formatEditTextDate(editTextExpenditureDate.getText().toString());

        //create expenditure object
        Expenditure expenditure = new Expenditure(0,date, amount, description, herdNumber);

        //send to presenter
        addExpenditurePresenter.addExpenditureToDB(expenditure, context);
        finish();
    }
}
