package BusinessLogic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.asus.livestockmanager.R;

import BusinessEntities.Expenditure;
import DataAccessLayer.LivestockManagerDatabaseOperations;

/**
 * Created by asus on 20/02/2016.
 */
public class AddExpenditurePresenter {

    public ArrayAdapter<CharSequence> getExpenditureTypes(Context context){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.expenditureTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
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
