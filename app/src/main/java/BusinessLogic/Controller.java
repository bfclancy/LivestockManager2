package BusinessLogic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import BusinessEntities.Appointment;
import BusinessEntities.Cattle;
import BusinessEntities.Expenditure;
import BusinessEntities.Income;
import BusinessEntities.Pregnancy;
import BusinessEntities.Remedy;
import DataAccessLayer.LivestockManagerDatabaseOperations;

/**
 * Created by asus on 06/02/2016.
 * Class to handle all method calls to Data Access Layer From Activities Layer
 * and all calls From Data Access Layer to Activities Layer
 */
public class Controller {


    public static boolean addPregnancyToDB(Pregnancy pregnancy, Context context) {
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getWritableDatabase();
        try {
            livestockManagerDatabaseOperations.addPregnancy(pregnancy, sqLiteDatabase);
            return true;
        }catch(Exception e){
            Log.d("DBError", e.toString());
            return false;
        }finally{
            livestockManagerDatabaseOperations.close();
        }
    }

    public static boolean addAppointmentToDB(Appointment appointment, Context context){
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getWritableDatabase();
        try {
            livestockManagerDatabaseOperations.addAppointment(appointment, sqLiteDatabase);
            return true;
        }catch(Exception e){
            Log.d("DB Appointment Error", e.toString());
            return false;
        }finally{
            livestockManagerDatabaseOperations.close();
        }
    }

    public static List<Cattle> getAllAnimals(Context context){
        List<Cattle> cattle = new ArrayList<>();
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        try{
            cattle = livestockManagerDatabaseOperations.getAllLivestock(sqLiteDatabase);
        } catch(Exception e){
            Log.d("DBError  : " ,e.toString());
        } finally {
            livestockManagerDatabaseOperations.close();
        }
        return cattle;
    }


    public static List<Cattle> getAllFemaleCattle(Context context){
        List<Cattle> cattle = new ArrayList<>();
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        try{
            cattle = livestockManagerDatabaseOperations.getAllFemaleCattle(sqLiteDatabase);
        }catch(Exception e){
            Log.d("DBError", e.toString());
        }finally {
            livestockManagerDatabaseOperations.close();
        }
        return cattle;
    }

    public static List<Cattle> getAllCows(Context context){
        List<Cattle> cattle = new ArrayList<>();
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        try{
            cattle = livestockManagerDatabaseOperations.getAllCows(sqLiteDatabase);
        }catch(Exception e){
            Log.d("DBError", e.toString());
        }finally {
            livestockManagerDatabaseOperations.close();
        }
        return cattle;
    }

    public static List<String> getAllTagNumbersForCows(Context context){
        List<String> cowTags = new ArrayList<>();
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        try{
            cowTags = livestockManagerDatabaseOperations.getAllTagNumbersForCows(sqLiteDatabase);
        }catch(Exception e){
            Log.d("DBError", e.toString());
        }finally {
            livestockManagerDatabaseOperations.close();
        }
        return cowTags;
    }


    public static List<String> getAllTagNumbers(Context context){
        List<String> tags = new ArrayList<>();
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        try{
            tags = livestockManagerDatabaseOperations.getAllTagNumbers(sqLiteDatabase);
        } catch(Exception e){
            Log.d("DBError  : " ,e.toString());
        } finally {
            livestockManagerDatabaseOperations.close();
        }
        return tags;
    }

    public static Cattle getAnimalByTagNumber(String tagNumber, Context context) {
        Cattle cattle = null;
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        try{
            cattle = livestockManagerDatabaseOperations.getAnimalByTagNumber(tagNumber, sqLiteDatabase);
        } catch(Exception e){
            Log.d("DBError  : " ,e.toString());
        } finally {
            livestockManagerDatabaseOperations.close();
        }
        return cattle;
    }

    public static boolean editAnimal(String tagNumber, Date dob, Date dtb, Date dmi, Context context) {
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getWritableDatabase();
        try{
            livestockManagerDatabaseOperations.editAnimal(tagNumber, dob, dtb, dmi, sqLiteDatabase);
            return true;
        }catch(Exception e){
            Log.d("DBError", e.toString());
            return false;
        }finally{
            livestockManagerDatabaseOperations.close();
        }
    }

    public static boolean removeAnimal(String tagNumber, Context context) {
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getWritableDatabase();
        try{
            livestockManagerDatabaseOperations.removeAnimal(tagNumber, sqLiteDatabase);
            return true;
        }catch(Exception e){
            Log.d("DBError", e.toString());
            return false;
        }finally{
            livestockManagerDatabaseOperations.close();
        }
    }

    public static boolean addAnimalToDB(Cattle cattle, Context context) {
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

    public static boolean addIncomeToDB(Income income, Context context) {
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getWritableDatabase();
        try{
            livestockManagerDatabaseOperations.addIncome(income, sqLiteDatabase);
            return true;
        }catch(Exception e){
            Log.d("DBError", e.toString());
            return false;
        }finally{
            livestockManagerDatabaseOperations.close();
        }
    }

    public static boolean addExpenditureToDB(Expenditure expenditure, Context context) {
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

    public static boolean addAppointmentFromCloudToDB(Appointment appointment, Context context){
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getWritableDatabase();
        try{
            if(UniquenessChecker.checkAppointmentIsUnique(appointment, context)) {
                livestockManagerDatabaseOperations.addAppointment(appointment, sqLiteDatabase);
                return true;
            }
            else {
                Log.d("DBError", "Appointment Already Exists in DB");
                return false;
            }
        }catch(Exception e){
            Log.d("DBError", e.toString());
            return false;
        }finally{
            livestockManagerDatabaseOperations.close();
        }
    }

    public static boolean addRemedyToDB(Remedy remedy, Context context) {
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getWritableDatabase();
        try{
            if(UniquenessChecker.checkRemedyIsUnique(remedy, context)) {
                livestockManagerDatabaseOperations.addRemedy(remedy, sqLiteDatabase);
                return true;
            }
            else {
                Log.d("DBError", "Appointment Already Exists in DB");
                return false;
            }
        }catch(Exception e){
            Log.d("DBError", e.toString());
            return false;
        }finally{
            livestockManagerDatabaseOperations.close();
        }
    }

    public static double getTotalIncome(Context context){
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        try{
            double total = livestockManagerDatabaseOperations.getTotalIncome(sqLiteDatabase);
            return total;
        }catch(Exception e){
            Log.d("DBError", e.toString());
            return 0.0;
        }finally {
            livestockManagerDatabaseOperations.close();
        }
    }

    public static double getTotalExpenditure(Context context){
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        try{
            double total = livestockManagerDatabaseOperations.getTotalExpenditure(sqLiteDatabase);
            return total;
        }catch(Exception e){
            Log.d("DBError", e.toString());
            return 0.0;
        }finally {
            livestockManagerDatabaseOperations.close();
        }
    }

    public static double[] getExpenditureAmountsFromDB(Context context) {

        double feed = 0.0, fertiliser = 0.0, plant = 0.0, medical = 0.0, misc = 0.0;
        LivestockManagerDatabaseOperations livestockManagerDatabaseOperations = new LivestockManagerDatabaseOperations(context);
        SQLiteDatabase sqLiteDatabase = livestockManagerDatabaseOperations.getReadableDatabase();
        try{
            List<Expenditure> expenditure = livestockManagerDatabaseOperations.getAllExpenditures(sqLiteDatabase);
            for(Expenditure e : expenditure){
                if(e.getExpenditureDescription().toString().equalsIgnoreCase("Feed"))
                    feed += e.getExpenditureAmount();
                else if(e.getExpenditureDescription().toString().equals("Fertiliser"))
                    fertiliser += e.getExpenditureAmount();
                else if(e.getExpenditureDescription().toString().equals("Plant and Machinery"))
                    plant += e.getExpenditureAmount();
                else if(e.getExpenditureDescription().toString().equals("Medical"))
                    medical += e.getExpenditureAmount();
                else
                    misc += e.getExpenditureAmount();
            }
            double[] expenditures = {feed,fertiliser,medical,plant,misc};
            return expenditures;
        }catch(Exception e){
            Log.d("DBError", e.toString());
            return null;
        }finally {
            livestockManagerDatabaseOperations.close();
        }
    }
}
