package com.example.asus.livestockmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import BusinessEntities.Cattle;
import BusinessEntities.DateFormatter;
import BusinessEntities.DateGenerator;
import BusinessEntities.Expenditure;
import BusinessLogic.AddAnimalPresenter;
import BusinessLogic.Controller;

public class AddAnimalActivity extends AppCompatActivity {


    private EditText etTagNumber, etDamTagNumber, etSire, etPrice;
    private Button buttonConfirmAddNewAnimal, buttonCancelAddNewAnimal;
    private Cattle cattle;
    private DatePicker dpDOB, dpDTB, dpDMI;
    private RelativeLayout layoutAddAnimal;
    private Spinner spinnerAddNewAnimalBreed, spinnerAddNewAnimalGender;
    private Context context = this;
    private String tagNumber, herdNumber;
    private SharedPreferences preferences = null;
    private String myPreferences = "Login Credentials";
    private Date dob, dtb, dmi;
    private AddAnimalPresenter addAnimalPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);

        addAnimalPresenter = new AddAnimalPresenter();

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            tagNumber = extras.getString("tagNumber");
        }

        layoutAddAnimal = (RelativeLayout) findViewById(R.id.layoutAddAnimal);
        etTagNumber = (EditText) findViewById(R.id.editTextNewTagNumber);
        etDamTagNumber = (EditText) findViewById(R.id.editTextDam);
        etSire = (EditText) findViewById(R.id.editTextSire);
        etPrice = (EditText) findViewById(R.id.editTextPrice);
        dpDOB = (DatePicker) findViewById(R.id.datePickerNewDOB);
        dpDTB = (DatePicker) findViewById(R.id.datePickerAddNewLastTBTest);
        dpDMI = (DatePicker) findViewById(R.id.datePickerAddNewDateMovedIn);

        preferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);
        herdNumber = preferences.getString("herdNumber", "");

        buttonCancelAddNewAnimal = (Button) findViewById(R.id.buttonCancel);

        spinnerAddNewAnimalBreed = (Spinner) findViewById(R.id.spinnerSireBreed);
        spinnerAddNewAnimalBreed.setAdapter(addAnimalPresenter.getCattleBreeds(this));

        spinnerAddNewAnimalGender = (Spinner) findViewById(R.id.spinnerAddNewAnimalGender);
        spinnerAddNewAnimalGender.setAdapter(addAnimalPresenter.getCattleGenders(this));

        etTagNumber.setText(tagNumber);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_animal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addNewAnimal(View view) {
        //getting the values from the form to create the new cattle object
        String tagNumber = etTagNumber.getText().toString();
        String sireBreed = spinnerAddNewAnimalBreed.getSelectedItem().toString();
        String gender = spinnerAddNewAnimalGender.getSelectedItem().toString();
        String damTagNumber = etDamTagNumber.getText().toString();
        dob = DateGenerator.generateDate(dpDOB);
        dtb = DateGenerator.generateDate(dpDTB);
        dmi = DateGenerator.generateDate(dpDMI);
        String sire = etSire.getText().toString();
        cattle = new Cattle(tagNumber, gender, dob, dtb, dmi, sire, sireBreed, damTagNumber);

        //getting values from the for record cost of purchasing new animal, if animal is born on farm a arbitrary figue of 250 euro is given as cost of birth
        String timeStamp = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).format(Calendar.getInstance().getTime());
        Date purchaseDate = DateFormatter.convertStringToDate(timeStamp);
        Double amount;
        if(etPrice.getText().toString().equals(""))
            amount = 250.0;
        else
            amount = Double.parseDouble(etPrice.getText().toString());

        Expenditure expenditure = new Expenditure(0, purchaseDate, amount, "Purchase of Livestock", herdNumber);

        //attempt to write new cattle and expenditure to db
        if(addAnimalPresenter.addAnimalToDB(cattle, context) && addAnimalPresenter.addExpenditureToDB(expenditure, context)) {
            Toast.makeText(getBaseContext(), "New animal " + tagNumber + " added to herd.", Toast.LENGTH_LONG).show();
            startActivity(new Intent("android.intent.action.MainActivity"));
        }
        else{
            Toast.makeText(getBaseContext(), "Action Failed", Toast.LENGTH_LONG).show();
        }


    }

    public void cancelAddNewAnimal(View view){
        startActivity(new Intent("android.intent.action.MainActivity"));
    }
}

