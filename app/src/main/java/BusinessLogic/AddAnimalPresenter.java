package BusinessLogic;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.asus.livestockmanager.R;

import BusinessEntities.Cattle;
import BusinessEntities.Expenditure;
import DataAccessLayer.LivestockManagerDatabaseOperations;

/**
 * Created by asus on 17/02/2016.
 */
public class AddAnimalPresenter {

    public ArrayAdapter<CharSequence> getCattleBreeds(Context context){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.cattle_breeds, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    public ArrayAdapter<CharSequence> getCattleGenders(Context context) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    public boolean addAnimalToDB(Cattle cattle, Context context){
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getWritableDatabase();
        try{
            if(UniquenessChecker.checkCattleIsUnique(cattle, context)) {
                livestockManagerDatabaseOperations.addCattle(cattle, sqLiteDatabase);
                return true;
            }
            else {
                Log.d("DBError", "Cattle Already Exists in DB");
                return false;
            }
        }catch(Exception e){
            Log.d("DBError", e.toString());
            return false;
        }finally{
            livestockManagerDatabaseOperations.close();
        }
    }

    public boolean addExpenditureToDB(Expenditure expenditure, Context context) {
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getWritableDatabase();
        try{
            livestockManagerDatabaseOperations.addExpenditure(expenditure, sqLiteDatabase);
            return true;
        }catch(Exception e){
            Log.d("DBError", e.toString());
            return false;
        }finally{
            livestockManagerDatabaseOperations.close();
        }
    }
}
