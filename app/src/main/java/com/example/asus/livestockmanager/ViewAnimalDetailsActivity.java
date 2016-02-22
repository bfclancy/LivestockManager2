package com.example.asus.livestockmanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.Date;

import BusinessEntities.Cattle;
import BusinessEntities.DateFormatter;
import DataAccessLayer.AnimalListDataAdapter;
import DataAccessLayer.LivestockManagerDatabaseOperations;

public class ViewAnimalDetailsActivity extends AppCompatActivity {

    ListView listViewAnimalDetails;
    SQLiteDatabase sqLiteDatabase;
    LivestockManagerDatabaseOperations livestockManagerDatabaseOperations;
    Cursor cursor;
    AnimalListDataAdapter animalListDataAdapter;
    String tagNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animal_details);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            tagNumber = extras.getString("tagNumber");
        }

        listViewAnimalDetails = (ListView) findViewById(R.id.listViewAnimalDetails);
        livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(getApplicationContext());
        sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        cursor = livestockManagerDatabaseOperations.viewCattle(tagNumber, sqLiteDatabase);
        animalListDataAdapter = new AnimalListDataAdapter(getApplicationContext(),R.layout.list_view_animal_details);
        listViewAnimalDetails.setAdapter(animalListDataAdapter);
        if(cursor.moveToFirst()) {
            do {
                String tagNumber, gender, sire, sireBreed, damTagNumber;
                Date dob, dateLastTBTest, dateMovedIn;
                tagNumber = cursor.getString(0);
                gender = cursor.getString(1);
                dob = DateFormatter.convertStringToDate(cursor.getString(2));
                dateLastTBTest = DateFormatter.convertStringToDate(cursor.getString(3));
                dateMovedIn = DateFormatter.convertStringToDate(cursor.getString(4));
                sire = cursor.getString(5);
                sireBreed = cursor.getString(6);
                damTagNumber = cursor.getString(7);
                Cattle cattle = new Cattle(tagNumber, gender, dob, dateLastTBTest, dateMovedIn, sire, sireBreed, damTagNumber);
                animalListDataAdapter.add(cattle);

            }while(cursor.moveToNext());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_animal_details, menu);
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
}
