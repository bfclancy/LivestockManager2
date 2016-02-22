package com.example.asus.livestockmanager;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import BusinessEntities.DateFormatter;
import BusinessEntities.DateHandler;
import BusinessEntities.Pregnancy;
import BusinessLogic.Controller;

public class AnimalPregnancyActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Button buttonAddPregnacy, buttonCancelPregnancy;
    EditText editTextPregnancyDate;
    Date conceptionDate, dueDate;
    Context context = this;
    Spinner spinnerTagNumber;
    List<String> tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_pregnancy);

        buttonAddPregnacy = (Button) findViewById(R.id.buttonConfirmNewPregnancy);
        buttonAddPregnacy.setOnClickListener(this);
        buttonCancelPregnancy = (Button) findViewById(R.id.buttonCancelNewPregnancy);
        buttonCancelPregnancy.setOnClickListener(this);
        spinnerTagNumber = (Spinner) findViewById(R.id.spinner);

        editTextPregnancyDate = (EditText) findViewById(R.id.editTextPregnancyDate);

        tags = Controller.getAllTagNumbersForCows(context);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tags.toArray());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTagNumber.setAdapter(adapter);
        spinnerTagNumber.setOnItemSelectedListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonConfirmNewPregnancy:
                buttonAddPregnancyToDBClick();
                break;

            case R.id.buttonCancelNewPregnancy:
                buttonCancelPregnancyClick();
                break;
        }
    }

    private void buttonAddPregnancyToDBClick() {
        conceptionDate = DateFormatter.formatEditTextDate(editTextPregnancyDate.getText().toString());
        dueDate = DateHandler.changeDate(conceptionDate, 9);
        Pregnancy pregnancy = new Pregnancy(0, spinnerTagNumber.getSelectedItem().toString(),conceptionDate, dueDate);
        if(Controller.addPregnancyToDB(pregnancy, context)) {
            Toast.makeText(getBaseContext(), "New pregnancy recorded, due on " + conceptionDate, Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(getBaseContext(), "Problem with request", Toast.LENGTH_LONG).show();
        finish();
    }

    private void buttonCancelPregnancyClick(){
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
