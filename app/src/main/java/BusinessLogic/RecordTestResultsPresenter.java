package BusinessLogic;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import DataAccessLayer.LivestockManagerDatabaseOperations;

/**
 * Created by asus on 19/02/2016.
 */
public class RecordTestResultsPresenter {

    public List<String> getAllTagNumbersForTest(Context context){
        List<String> tagNumbers = new ArrayList<>();
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        try {
            tagNumbers = livestockManagerDatabaseOperations.getAllTagNumbers(sqLiteDatabase);
        }catch(Exception e){
            Log.d("Error", "Error retrieving tags from db: " + e);
        }
        return tagNumbers;
    }
}
