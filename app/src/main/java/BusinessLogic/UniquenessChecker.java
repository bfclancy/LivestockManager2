package BusinessLogic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import BusinessEntities.Appointment;
import BusinessEntities.Cattle;
import BusinessEntities.Remedy;
import DataAccessLayer.LivestockManagerDatabaseOperations;

/**
 * Created by asus on 11/02/2016.
 */
public class UniquenessChecker {

    public static boolean checkAppointmentIsUnique(Appointment appointment, Context context){
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        List<Appointment> appointments = livestockManagerDatabaseOperations.getAllAppointmentDetails(sqLiteDatabase);
        for(Appointment a : appointments) {
            if(appointment.getTime().toString().equals(a.getTime().toString())) {
                System.out.println(appointment.getDate() + " : " + a.getDate());
                return false;
            }
        }
        return true;
    }

    public static boolean checkCattleIsUnique(Cattle cattle, Context context) {
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        List<String> cattleList = livestockManagerDatabaseOperations.getAllTagNumbers(sqLiteDatabase);
        for(String s : cattleList) {
            if(cattle.getTagNumber().equals(s)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRemedyIsUnique(Remedy remedy, Context context) {
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        List<String> productNumbers = livestockManagerDatabaseOperations.getAllProductNumbersForRemedies(sqLiteDatabase);
        for(String s : productNumbers) {
            if(remedy.getProductNumber().equals(s)) {
                return false;
            }
        }
        return true;
    }
}
