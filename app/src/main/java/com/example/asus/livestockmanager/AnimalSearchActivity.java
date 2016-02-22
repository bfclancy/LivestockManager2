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

import BusinessEntities.Cattle;
import BusinessEntities.DateFormatter;
import BusinessLogic.Controller;

public class AnimalSearchActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Button buttonEdit, buttonCancel;
    EditText etDOB, etTB, etDMI;
    Spinner spinnerTagNumber;
    Context context = this;
    List<String> tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animal_search);
        spinnerTagNumber = (Spinner) findViewById(R.id.spinner);
        etDOB = (EditText) findViewById(R.id.editTextDOB);
        etTB = (EditText) findViewById(R.id.editTextTB);
        etDMI = (EditText) findViewById(R.id.editTextDMI);
        buttonEdit = (Button) findViewById(R.id.buttonEdit);
        buttonCancel = (Button) findViewById(R.id.button2);

        buttonEdit.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);

        tags = Controller.getAllTagNumbers(context);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tags.toArray());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTagNumber.setAdapter(adapter);
        spinnerTagNumber.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.buttonEdit:
                buttonEditClick();
                break;

            case R.id.button2:
                buttonCancelClick();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String tagNumber = spinnerTagNumber.getSelectedItem().toString();
        Cattle selectedCattle = Controller.getAnimalByTagNumber(tagNumber, context);
        etDOB.setText(DateFormatter.formatForDisplay(selectedCattle.getDateOfBirth().toString()));
        etTB.setText(DateFormatter.formatForDisplay(selectedCattle.getDateLastTBTest().toString()));
        etDMI.setText(DateFormatter.formatForDisplay(selectedCattle.getDateMovedIn().toString()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void buttonCancelClick(){
        finish();
    }

    private void buttonEditClick(){
        String tagNumber = spinnerTagNumber.getSelectedItem().toString();
        Date dob = DateFormatter.formatEditTextDate(etDOB.getText().toString());
        Date dtb = DateFormatter.formatEditTextDate((etTB.getText().toString()));
        Date dmi = DateFormatter.formatEditTextDate((etDMI.getText().toString()));
        if(Controller.editAnimal(tagNumber, dob, dtb, dmi, context)) {
            Toast.makeText(getBaseContext(), "Cattle with tag number " + tagNumber + ", successfully edited!", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(getBaseContext(), "Problem with request", Toast.LENGTH_LONG).show();
        finish();
    }
}

