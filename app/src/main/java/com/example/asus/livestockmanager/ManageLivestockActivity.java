package com.example.asus.livestockmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ManageLivestockActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonAddNewAnimal, buttonSearchForAnimal, buttonRecordAnimalSale, buttonRecordAnimalPurchase, buttonViewAnimalDetails, buttonRecordPregnancy, buttonRecordAnimalDeath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_livestock);

        buttonAddNewAnimal = (Button) findViewById(R.id.buttonAddNewAnimal);
        buttonSearchForAnimal = (Button) findViewById(R.id.buttonSearchForAnimal);
        buttonRecordAnimalSale = (Button) findViewById(R.id.buttonRecordAnimalSale);
        buttonRecordAnimalPurchase = (Button) findViewById(R.id.buttonRecordAnimalPurchase);
        buttonViewAnimalDetails = (Button) findViewById(R.id.buttonViewAnimals);
        buttonRecordPregnancy = (Button) findViewById(R.id.buttonRecordPregnancy);
        buttonRecordAnimalDeath = (Button) findViewById(R.id.buttonRecordAnimalDeath);

        buttonAddNewAnimal.setOnClickListener(this);
        buttonSearchForAnimal.setOnClickListener(this);
        buttonRecordAnimalSale.setOnClickListener(this);
        buttonRecordAnimalPurchase.setOnClickListener(this);
        buttonViewAnimalDetails.setOnClickListener(this);
        buttonRecordPregnancy.setOnClickListener(this);
        buttonRecordAnimalDeath.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_manage_livestock, menu);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAddNewAnimal:
                buttonAddNewAnimalClick();
                break;

            case R.id.buttonSearchForAnimal:
                buttonSearchForAnimalClick();
                break;

            case R.id.buttonRecordAnimalSale:
                buttonRecordAnimalSaleClick();
                break;

            case R.id.buttonRecordAnimalPurchase:
                buttonRecordAnimalPurchaseClick();
                break;

            case R.id.buttonViewAnimals:
                buttonViewAnimalDetailsClick();
                break;

            case R.id.buttonRecordPregnancy:
                buttonRecordPregnancyClick();
                break;

            case R.id.buttonRecordAnimalDeath:
                buttonRecordAnimalDeathClick();
                break;
        }
    }

    private void buttonAddNewAnimalClick() {
        startActivity(new Intent("android.intent.action.AddAnimalActivity"));
    }

    private void buttonSearchForAnimalClick() {
        startActivity(new Intent("android.intent.action.AnimalSearchActivity"));
    }

    private void buttonRecordAnimalSaleClick() {
        startActivity(new Intent("android.intent.action.RecordAnimalSale"));
    }

    private void buttonRecordAnimalPurchaseClick() {
        startActivity(new Intent("android.intent.action.AnimalPurchaseActivity"));
    }

    private void buttonViewAnimalDetailsClick() {
        startActivity(new Intent("android.intent.action.LivestockListActivity"));
    }

    private void buttonRecordPregnancyClick(){
        startActivity(new Intent("android.intent.action.AnimalPregnancyActivity"));
    }

    private void buttonRecordAnimalDeathClick(){
        startActivity(new Intent("android.intent.action.RemoveAnimalActivity"));
    }
}
