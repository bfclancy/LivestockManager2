package com.example.asus.livestockmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import BusinessLogic.Field;
import BusinessLogic.Form;
import BusinessLogic.FormUtils;
import BusinessLogic.IsEmail;
import BusinessLogic.IsValidPassword;
import BusinessLogic.NotEmpty;
import DataAccessLayer.LivestockManagerDatabaseOperations;

public class Register extends AppCompatActivity {

    EditText editTextFirstName, editTextSurname, editTextAddress, editTextHerdNumber, editTextPAC, editTextPassword, editTextEmail;
    Spinner countySpinner;
    RelativeLayout signUpLayout;
    Context context = this;
    LivestockManagerDatabaseOperations livestockManagerDatabaseOperations;
    SQLiteDatabase sqLiteDatabase;
    private Form form;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        editTextSurname = (EditText) findViewById(R.id.editTextSurname);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextHerdNumber = (EditText) findViewById(R.id.editTextHerdNumber);
        editTextPAC = (EditText) findViewById(R.id.editTextPAC);
        countySpinner = (Spinner) findViewById(R.id.spinnerCounty);

        countySpinner = (Spinner) findViewById(R.id.spinnerCounty);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.counties, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countySpinner.setAdapter(adapter);

        initValidationForm();
        //initCallbacks();

    }

    public void addNewUser(View view) {
        FormUtils.hideKeyboard(Register.this, editTextEmail);
        if (form.isValid()) {
            String firstName = editTextFirstName.getText().toString();
            String surname = editTextSurname.getText().toString();
            String address = editTextAddress.getText().toString();
            String herdNumber = editTextHerdNumber.getText().toString();
            String PAC = editTextPAC.getText().toString();
            String county = countySpinner.getSelectedItem().toString();
            String userName = editTextEmail.getText().toString();
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();

            SharedPreferences preferences = getSharedPreferences("Login Credentials", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("username", email);
            editor.putString("password", password);
            editor.putString("herdNumber", herdNumber);
            editor.apply();

            livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
            sqLiteDatabase = livestockManagerDatabaseOperations.getWritableDatabase();
            livestockManagerDatabaseOperations.addUser(firstName, surname, address, county, herdNumber, email, userName, PAC, password, sqLiteDatabase);
            Toast.makeText(getBaseContext(), "New user added", Toast.LENGTH_LONG).show();
            startActivity(new Intent("android.intent.action.MainActivity"));
            livestockManagerDatabaseOperations.close();
        }
    }

    private void initValidationForm() {
        form = new Form(this);
        form.addField(Field.using(editTextFirstName).validate(NotEmpty.build(this)));
        form.addField(Field.using(editTextSurname).validate(NotEmpty.build(this)));
        form.addField(Field.using(editTextAddress).validate(NotEmpty.build(this)));
        form.addField(Field.using(editTextHerdNumber).validate(NotEmpty.build(this)));
        form.addField(Field.using(editTextEmail).validate(NotEmpty.build(this)).validate(IsEmail.build(this)));
        form.addField(Field.using(editTextHerdNumber).validate(NotEmpty.build(this)));
        form.addField(Field.using(editTextPAC).validate(NotEmpty.build(this)));
        form.addField(Field.using(editTextPassword).validate(NotEmpty.build(this)).validate(IsValidPassword.build(this)));
    }

//    private void initCallbacks() {
//        mAge.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    submit();
//                    return true;
//                }
//                return false;
//            }
//
//        });
}

