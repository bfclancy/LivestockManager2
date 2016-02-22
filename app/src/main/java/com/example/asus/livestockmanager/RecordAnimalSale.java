package com.example.asus.livestockmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import BusinessEntities.DateFormatter;
import BusinessEntities.Income;
import BusinessLogic.Controller;

public class RecordAnimalSale extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Button buttonRecordSale, buttonCancelSale;
    EditText etSaleAmount;
    Spinner spinnerTagNumber;
    Context context = this;
    List<String> tags;
    SharedPreferences preferences = null;
    String herdNumber, description;
    String myPreferences = "Login Credentials";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_animal_sale);
        buttonRecordSale = (Button) findViewById(R.id.buttonRecordSale);
        buttonCancelSale = (Button) findViewById(R.id.buttonCancelSale);
        etSaleAmount = (EditText) findViewById(R.id.editTextSaleAmount);
        spinnerTagNumber = (Spinner) findViewById(R.id.spinner);

        preferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        herdNumber = preferences.getString("herdNumber", "");

        buttonCancelSale.setOnClickListener(this);
        buttonRecordSale.setOnClickListener(this);

        tags = Controller.getAllTagNumbers(context);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tags.toArray());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTagNumber.setAdapter(adapter);
        spinnerTagNumber.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.buttonRecordSale:
                buttonRecordSaleClick();
                break;

            case R.id.buttonCancelSale:
                buttonCancelSaleClick();
                break;
        }
    }

    private void buttonCancelSaleClick(){
        finish();
    }

    private void buttonRecordSaleClick(){
        String tagNumber = spinnerTagNumber.getSelectedItem().toString();
        double salePrice = Double.parseDouble(etSaleAmount.getText().toString());
        String timeStamp = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime());
        Date saleDate = DateFormatter.convertStringToDate(timeStamp);
        Income income = new Income(0, saleDate, salePrice, "Sale of livestock", herdNumber);
        if(Controller.removeAnimal(tagNumber, context) && Controller.addIncomeToDB(income, context)) {
            Toast.makeText(getBaseContext(), "Cattle with tag number " + tagNumber + ", sold for :!" + salePrice, Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(getBaseContext(), "Problem with request", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
