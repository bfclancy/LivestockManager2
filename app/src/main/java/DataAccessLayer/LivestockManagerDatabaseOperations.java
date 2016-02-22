package DataAccessLayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import BusinessEntities.Appointment;
import BusinessEntities.Cattle;
import BusinessEntities.DateFormatter;
import BusinessEntities.Expenditure;
import BusinessEntities.Income;
import BusinessEntities.Pregnancy;
import BusinessEntities.Remedy;
import BusinessEntities.Veterinarian;

/**
 * Created by asus on 9/25/2015.
 */
public class LivestockManagerDatabaseOperations extends SQLiteOpenHelper{

    //region CREATE TABLE QUERY STRINGS
    public static final int DATABASE_VERSION  = 1;

    public String CREATE_USER_TABLE_QUERY = "CREATE TABLE " + LivestockManagerTableData.LivestockManagerTableInformation.USER_TABLE_NAME + " ("
            + LivestockManagerTableData.LivestockManagerTableInformation.FIRST_NAME
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.SURNAME
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.ADDRESS
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.COUNTY
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.HERD_NUMBER
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.PAC
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.USER_NAME
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.EMAIL
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.PASSWORD +" TEXT );";

    public String CREATE_CATTLE_TABLE_QUERY = "CREATE TABLE " + LivestockManagerTableData.LivestockManagerTableInformation.CATTLE_TABLE_NAME + " ("
            + LivestockManagerTableData.LivestockManagerTableInformation.TAG_NUMBER
            + " TEXT PRIMARY KEY, " + LivestockManagerTableData.LivestockManagerTableInformation.GENDER
            + " DATE, " + LivestockManagerTableData.LivestockManagerTableInformation.DATE_OF_BIRTH
            + " DATE, " + LivestockManagerTableData.LivestockManagerTableInformation.DATE_LAST_TB_TEST
            + " DATE, " + LivestockManagerTableData.LivestockManagerTableInformation.DATE_MOVED_IN
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.SIRE
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.SIRE_BREED
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.DAM_TAG_NUMBER +" TEXT );";

    public String CREATE_VETERINARIAN_TABLE = "CREATE TABLE " + LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIANS_TABLE_NAME + " ("
            + LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIAN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIAN_NAME
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIAN_ADDRESS
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIAN_PHONE_NUMBER +" TEXT );";

    public String CREATE_INCOME_TABLE = "CREATE TABLE " + LivestockManagerTableData.LivestockManagerTableInformation.INCOME_TABLE_NAME + " ("
            + LivestockManagerTableData.LivestockManagerTableInformation.INCOME_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LivestockManagerTableData.LivestockManagerTableInformation.INCOME_DATE
            + " DATE, " + LivestockManagerTableData.LivestockManagerTableInformation.INCOME_AMOUNT
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.INCOME_DESCRIPTION
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.HERD_NUMBER +" TEXT );";

    public String CREATE_EXPENDITURE_TABLE = "CREATE TABLE " + LivestockManagerTableData.LivestockManagerTableInformation.EXPENDITURE_TABLE_NAME + " ("
            + LivestockManagerTableData.LivestockManagerTableInformation.EXPENDITURE_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LivestockManagerTableData.LivestockManagerTableInformation.EXPENDITURE_DATE
            + " DATE, " + LivestockManagerTableData.LivestockManagerTableInformation.EXPENDITURE_AMOUNT
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.EXPENDITURE_DESCRIPTION
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.HERD_NUMBER +" TEXT );";

    public String CREATE_APPOINTMENT_TABLE = "CREATE TABLE " + LivestockManagerTableData.LivestockManagerTableInformation.APPOINTMENTS_TABLE_NAME + " ("
            + LivestockManagerTableData.LivestockManagerTableInformation.APPOINTMENT_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LivestockManagerTableData.LivestockManagerTableInformation.APPOINTMENT_TYPE
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.APPOINTMENT_TIME
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.APPOINTMENT_DATE
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.HERD_NUMBER +" TEXT );";

    public String CREATE_PREGNANCY_TABLE = "CREATE TABLE " + LivestockManagerTableData.LivestockManagerTableInformation.PREGNANCY_TABLE_NAME + " ("
            + LivestockManagerTableData.LivestockManagerTableInformation.PREGNANCY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LivestockManagerTableData.LivestockManagerTableInformation.DAM_TAG_NUMBER
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.DATE
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.DUE_DATE +" TEXT );";

    public String CREATE_REMEDY_TABLE = "CREATE TABLE " + LivestockManagerTableData.LivestockManagerTableInformation.REMEDY_TABLE_NAME + " ( "
            + LivestockManagerTableData.LivestockManagerTableInformation.REMEDY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LivestockManagerTableData.LivestockManagerTableInformation.REMEDY_NAME
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.REMEDY_PRODUCT_NUMBER
            + " TEXT, " + LivestockManagerTableData.LivestockManagerTableInformation.REMEDY_PRODUCT_GROUP +" TEXT );";

    //endregion

    public LivestockManagerDatabaseOperations(Context context) {
        super(context, LivestockManagerTableData.LivestockManagerTableInformation.DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database operation", "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_USER_TABLE_QUERY);
        db.execSQL(CREATE_CATTLE_TABLE_QUERY);
        db.execSQL(CREATE_VETERINARIAN_TABLE);
        db.execSQL(CREATE_APPOINTMENT_TABLE);
        db.execSQL(CREATE_INCOME_TABLE);
        db.execSQL(CREATE_EXPENDITURE_TABLE);
        db.execSQL(CREATE_PREGNANCY_TABLE);
        db.execSQL(CREATE_REMEDY_TABLE);
        Log.d("Database operation", "Table created");
    }

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //region USER DB OPERATIONS
    //ADD A NEW USER TO THE SYSTEM
    public void addUser(String newFirstName, String newSurname, String newAddress, String newCounty, String newHerdNumber, String email, String newUserName, String newPAC, String newPassword, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.FIRST_NAME, newFirstName);
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.SURNAME, newSurname);
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.ADDRESS, newAddress);
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.COUNTY, newCounty);
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.HERD_NUMBER, newHerdNumber);
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.USER_NAME, newUserName);
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.PAC, newPAC);
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.EMAIL, email);
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.PASSWORD, newPassword);
        db.insert(LivestockManagerTableData.LivestockManagerTableInformation.USER_TABLE_NAME, null, contentValues);
        Log.d("Database operation", "New user added");
    }

    //view users
    public Cursor viewUsers(SQLiteDatabase db) {
        Cursor cursor;
        String[] projections = {LivestockManagerTableData.LivestockManagerTableInformation.FIRST_NAME,
                LivestockManagerTableData.LivestockManagerTableInformation.SURNAME,
                LivestockManagerTableData.LivestockManagerTableInformation.ADDRESS,
                LivestockManagerTableData.LivestockManagerTableInformation.HERD_NUMBER,
                LivestockManagerTableData.LivestockManagerTableInformation.USER_NAME,
                LivestockManagerTableData.LivestockManagerTableInformation.PAC,
                LivestockManagerTableData.LivestockManagerTableInformation.PASSWORD};
        cursor = db.query(LivestockManagerTableData.LivestockManagerTableInformation.USER_TABLE_NAME, projections, null, null, null, null, null);
        return cursor;
    }
    //endregion

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //region ANIMAL DB OPERATIONS
    //ADD A NEW ANIMAL TO THE SYSTEM
    public void addCattle(String tagNumber, String gender, Date dob, Date lastTBTest, Date movedIn, String damTagNumber, String sire, String sireBreed,  SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.TAG_NUMBER, tagNumber);
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.GENDER, gender);
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.DATE_OF_BIRTH, String.valueOf(dob));
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.DATE_LAST_TB_TEST, String.valueOf(lastTBTest));
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.DATE_MOVED_IN, String.valueOf(movedIn));
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.DAM_TAG_NUMBER, damTagNumber);
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.SIRE, sire);
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.SIRE_BREED, sireBreed);
        db.insert(LivestockManagerTableData.LivestockManagerTableInformation.CATTLE_TABLE_NAME, null, contentValues);
        Log.d("Database operation", "New animal added");
    }

    public void addCattle(Cattle c, SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.TAG_NUMBER, c.getTagNumber());
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.GENDER, c.getGender());
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.DATE_OF_BIRTH, String.valueOf(c.getDateOfBirth()));
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.DATE_LAST_TB_TEST, String.valueOf(c.getDateLastTBTest()));
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.DATE_MOVED_IN, String.valueOf(c.getDateMovedIn()));
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.DAM_TAG_NUMBER, c.getDamTagNumber());
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.SIRE, c.getSire());
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.SIRE_BREED, c.getSireBreed());
        db.insert(LivestockManagerTableData.LivestockManagerTableInformation.CATTLE_TABLE_NAME, null, cv);
        Log.d("Database operation", "New animal added");
    }
    //VIEW CATTLE BY TAG NUMBER
    public Cursor viewCattle(String tagNumber, SQLiteDatabase db) {
        Cursor cursor;
        String selectQuery = "SELECT * FROM " + LivestockManagerTableData.LivestockManagerTableInformation.CATTLE_TABLE_NAME + " WHERE " + LivestockManagerTableData.LivestockManagerTableInformation.TAG_NUMBER +
                " = '" + tagNumber + "';";
        cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    //GET ALL ANIMALS
    public List<Cattle> getAllLivestock(SQLiteDatabase db) {
        List<Cattle> cattle = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + LivestockManagerTableData.LivestockManagerTableInformation.CATTLE_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                cattle.add(new Cattle(cursor.getString(0), cursor.getString(1), DateFormatter.convertStringToDate(cursor.getString(2)), DateFormatter.convertStringToDate(cursor.getString(3)),
                        DateFormatter.convertStringToDate(cursor.getString(4)), cursor.getString(5),cursor.getString(6), cursor.getString(7)));
            } while (cursor.moveToNext());
        }
        return cattle;
    }

    //GET ALL TAG NUMBERS
    public List<String> getAllTagNumbers(SQLiteDatabase db){
        List<String> tags = new ArrayList<>();
        String selectQuery = "SELECT " + LivestockManagerTableData.LivestockManagerTableInformation.TAG_NUMBER + " FROM "
                + LivestockManagerTableData.LivestockManagerTableInformation.CATTLE_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()) {
            do{
                tags.add(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        return tags;
    }

    //GET ALL ANIMALS BY TAG NUMBER
    public List<Cattle> getAllLivestockByTagNumber( String tagNumber, SQLiteDatabase db) {
        List<Cattle> cattle = new ArrayList<>();
        String selectQuery = "SELECT * FROM cattle WHERE tagNumber = '" + tagNumber + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                cattle.add(new Cattle(cursor.getString(0), cursor.getString(1), DateFormatter.convertStringToDate(cursor.getString(2)), DateFormatter.convertStringToDate(cursor.getString(3)),
                        DateFormatter.convertStringToDate(cursor.getString(4)), cursor.getString(5), cursor.getString(6), cursor.getString(7)));
            } while (cursor.moveToNext());
        }
        return cattle;
    }

    //GET ANIMAL BY TAG NUMBER
    public Cattle getAnimalByTagNumber(String tagNumber, SQLiteDatabase db) {
        Cattle cattle = new Cattle();
        String selectQuery = "SELECT * FROM cattle WHERE tagNumber = '" + tagNumber + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                cattle.setTagNumber(tagNumber);
                cattle.setGender(cursor.getString(1));
                cattle.setDateOfBirth(DateFormatter.convertStringToDate(cursor.getString(2)));
                cattle.setDateLastTBTest(DateFormatter.convertStringToDate(cursor.getString(3)));
                cattle.setDateMovedIn(DateFormatter.convertStringToDate(cursor.getString(4)));
                cattle.setDamTagNumber(cursor.getString(5));
                cattle.setSireBreed(cursor.getString(6));
                cattle.setSire(cursor.getString(7));
            } while (cursor.moveToNext());
        }
        return cattle;
    }

    //EDIT ANIMAL DETAILS
    public void editAnimal(String tagNumber, Date dob, Date dtb, Date dmi, SQLiteDatabase db){
        String query = "UPDATE cattle SET dateOfBirth = '" + dob + "', dateLastTBTest = '" + dtb + "', dateMovedIn = '" + dmi + "' WHERE tagNumber = '" + tagNumber + "'";
        try {
            db.beginTransaction();
            db.execSQL(query);
            db.setTransactionSuccessful();
        }catch(Exception e){
            Log.d("DBError", e.toString());
        }finally{
            db.endTransaction();
        }
    }

    //REMOVE ANIMAL
    public void removeAnimal(String tagNumber, SQLiteDatabase db) {
        String query = "DELETE FROM cattle WHERE tagNumber = '" + tagNumber + "'";
        try {
            db.beginTransaction();
            db.execSQL(query);
            db.setTransactionSuccessful();
        }catch(Exception e){
            Log.d("DBError", e.toString());
        }finally{
            db.endTransaction();
        }
    }

    //GET ALL FEMALE CATTLE
    public List<Cattle> getAllFemaleCattle(SQLiteDatabase db) {
        List<Cattle> cattle = new ArrayList<>();
        String query = "SELECT * FROM " + LivestockManagerTableData.LivestockManagerTableInformation.CATTLE_TABLE_NAME + " WHERE "
                + LivestockManagerTableData.LivestockManagerTableInformation.GENDER + " ='F'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                cattle.add(new Cattle(cursor.getString(0), cursor.getString(1), DateFormatter.convertStringToDate(cursor.getString(2)), DateFormatter.convertStringToDate(cursor.getString(3)),
                        DateFormatter.convertStringToDate(cursor.getString(4)), cursor.getString(5),cursor.getString(6), cursor.getString(7)));
            } while (cursor.moveToNext());
        }
        return cattle;
    }

    //GET ALL FEMALE CATTLE
    public List<Cattle> getAllCows(SQLiteDatabase db) {
        List<Cattle> cattle = new ArrayList<>();
        String query = "SELECT * FROM " + LivestockManagerTableData.LivestockManagerTableInformation.CATTLE_TABLE_NAME + " WHERE "
                + LivestockManagerTableData.LivestockManagerTableInformation.GENDER + " ='F' AND " + LivestockManagerTableData.LivestockManagerTableInformation.DATE_OF_BIRTH
                + " < ( now() - INTERVAL 12 MONTH )";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                cattle.add(new Cattle(cursor.getString(0), cursor.getString(1), DateFormatter.convertStringToDate(cursor.getString(2)), DateFormatter.convertStringToDate(cursor.getString(3)),
                        DateFormatter.convertStringToDate(cursor.getString(4)), cursor.getString(5),cursor.getString(6), cursor.getString(7)));
            } while (cursor.moveToNext());
        }
        return cattle;
    }

    //GET ALL COWS TAG NUMBERS
    public List<String> getAllTagNumbersForCows(SQLiteDatabase db) {
        List<String> cowTagNumbers = new ArrayList<>();
        String query = "SELECT " + LivestockManagerTableData.LivestockManagerTableInformation.TAG_NUMBER + " FROM "
                + LivestockManagerTableData.LivestockManagerTableInformation.CATTLE_TABLE_NAME + " WHERE "
                + LivestockManagerTableData.LivestockManagerTableInformation.GENDER + " ='F' AND "
                + LivestockManagerTableData.LivestockManagerTableInformation.DATE_OF_BIRTH + " > DATE('now', '-365 day')";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                cowTagNumbers.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return cowTagNumbers;
    }
    //endregion

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //region VET DB OPERATIONS
    //ADD A NEW VETERINARIAN TO THE SYSTEM
    public void addVeterinarian(Veterinarian vet, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIAN_PHONE_NUMBER, vet.getPhoneNumber());
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIAN_ADDRESS, vet.getVeterinarianAddress());
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIAN_NAME, vet.getVeterinarianName());
        db.insert(LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIANS_TABLE_NAME, null, contentValues);
        Log.d("Database operation", "New Vet added");
    }


    //ADD A NEW VISIT TO THE SYSTEM
    public void addAppointment(Appointment appointment, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.APPOINTMENT_TYPE, appointment.getType());
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.APPOINTMENT_TIME, String.valueOf(appointment.getTime()));
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.APPOINTMENT_DATE, String.valueOf(appointment.getDate()));
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.HERD_NUMBER, String.valueOf(appointment.getHerdNumber()));
        db.insert(LivestockManagerTableData.LivestockManagerTableInformation.APPOINTMENTS_TABLE_NAME, null, contentValues);
        Log.d("Database operation", "New Vet appointment added");
    }
    //VIEW VET VISITS
    public Cursor viewAppointments(SQLiteDatabase db) {
        Cursor cursor;
        String selectQuery = "SELECT * FROM " + LivestockManagerTableData.LivestockManagerTableInformation.APPOINTMENTS_TABLE_NAME ;
        cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    //DELETE OLD APPOINTMENTS
    public void deleteOldAppointments(SQLiteDatabase db, Date currentDate){
        String query = "DELETE FROM " + LivestockManagerTableData.LivestockManagerTableInformation.APPOINTMENTS_TABLE_NAME
                + " WHERE " + LivestockManagerTableData.LivestockManagerTableInformation.APPOINTMENT_DATE
                + " < " + currentDate;
        db.execSQL(query);
    }

    //GET ALL VET DETAILS
    public List<Veterinarian> getAllVetDetails(SQLiteDatabase db) {
        List<Veterinarian> vetDetails = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIANS_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                vetDetails.add(new Veterinarian(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        return vetDetails;
    }
    //GET VET NAMES FROM VET TABLE
    public List<String> getAllVetNames(SQLiteDatabase db) {
        List<String> vetNames = new ArrayList<>();
        String selectQuery = "SELECT " + LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIAN_NAME
                + " FROM " + LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIANS_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                vetNames.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();

        return vetNames;

    }

    //GET ALL APPOINTMENT DETAILS
    public List<Appointment> getAllAppointmentDetails(SQLiteDatabase db) {
        List<Appointment> appointmentDetails = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + LivestockManagerTableData.LivestockManagerTableInformation.APPOINTMENTS_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                appointmentDetails.add(new Appointment(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Time.valueOf(cursor.getString(2)),
                        DateFormatter.convertStringToDate(cursor.getString(3))));
            } while (cursor.moveToNext());
        }
        return appointmentDetails;
    }

    //GET ALL VET DETAILS BY NAME
    public List<Veterinarian> getAllVetDetailsByName(String vetName, SQLiteDatabase db){
        List<Veterinarian> vets = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIANS_TABLE_NAME + " WHERE " +
                LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIAN_NAME + " = '" + vetName + "';";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                vets.add(new Veterinarian(cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        return vets;
    }
    //endregion

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //region INCOME DB OPERATIONS
    //ADD A NEW INCOME ENTRY TO THE TABLE
    public void addIncome(Income income, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.INCOME_AMOUNT, income.getIncomeAmount());
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.INCOME_DATE, income.getIncomeDate().toString());
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.INCOME_DESCRIPTION, income.getIncomeDescription());
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.HERD_NUMBER, income.getHerdNumber());
        db.insert(LivestockManagerTableData.LivestockManagerTableInformation.INCOME_TABLE_NAME, null, contentValues);
        Log.d("Database operation", "New Income added");
    }

    //get all income dates
    public List<Income> getAllIncomes(SQLiteDatabase db) {
        List<Income> incomes = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + LivestockManagerTableData.LivestockManagerTableInformation.INCOME_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                incomes.add(new Income(cursor.getInt(0), DateFormatter.convertStringToDate(cursor.getString(1)), cursor.getDouble(2), cursor.getString(3), cursor.getString(4)));
                System.out.println("amount: " + cursor.getDouble(2));
            } while (cursor.moveToNext());
        }
        return incomes;
    }

    public double getTotalIncome(SQLiteDatabase db){
        Double total = 0.0;
        String selectQuery = "SELECT SUM (" + LivestockManagerTableData.LivestockManagerTableInformation.INCOME_AMOUNT +
                ") AS SumTotal FROM " + LivestockManagerTableData.LivestockManagerTableInformation.INCOME_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.getCount()>0) {
            cursor.moveToFirst();
            total = cursor.getDouble(cursor.getColumnIndex("SumTotal"));
        }
        return total;
    }
    //endregion

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //region EXPENDITURE DB OPERATIONS
    //ADD A NEW EXPENDITURE ENTRY TO THE TABLE
    public void addExpenditure(Expenditure expenditure, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.EXPENDITURE_AMOUNT, expenditure.getExpenditureAmount());
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.EXPENDITURE_DATE, expenditure.getExpenditureDate().toString());
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.EXPENDITURE_DESCRIPTION, expenditure.getExpenditureDescription());
        contentValues.put(LivestockManagerTableData.LivestockManagerTableInformation.HERD_NUMBER, expenditure.getHerdNumber());
        db.insert(LivestockManagerTableData.LivestockManagerTableInformation.EXPENDITURE_TABLE_NAME, null, contentValues);
        Log.d("Database operation", "New Expenditure added");
    }

    //GET A LIST OF ALL EXPENDITURES FROM THE DB
    public List<Expenditure> getAllExpenditures(SQLiteDatabase db){
        List<Expenditure> expenditures = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + LivestockManagerTableData.LivestockManagerTableInformation.EXPENDITURE_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                expenditures.add(new Expenditure(cursor.getInt(0), DateFormatter.convertStringToDate(cursor.getString(1)), cursor.getDouble(2), cursor.getString(3), cursor.getString(4)));
                System.out.println("amount: " + cursor.getDouble(2));
            } while (cursor.moveToNext());
        }
        return expenditures;
    }

    //GET TOTAL EXPENDITURE AMOUNT
    public double getTotalExpenditure(SQLiteDatabase db){
        Double total = 0.0;
        String selectQuery = "SELECT SUM (" + LivestockManagerTableData.LivestockManagerTableInformation.EXPENDITURE_AMOUNT +
                ") AS SumTotal FROM " + LivestockManagerTableData.LivestockManagerTableInformation.EXPENDITURE_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.getCount()>0) {
            cursor.moveToFirst();
            total = cursor.getDouble(cursor.getColumnIndex("SumTotal"));
        }
        return total;
    }
    //endregion

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //region PREGNANCY DB OPERATIONS
    //ADD A PREGNANCY TO THE TABLE
    public void addPregnancy(Pregnancy pregnancy, SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.DAM_TAG_NUMBER, pregnancy.getDamTagNumber());
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.DATE, pregnancy.getDate().toString());
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.DUE_DATE, pregnancy.getDueDate().toString());
        db.insert(LivestockManagerTableData.LivestockManagerTableInformation.PREGNANCY_TABLE_NAME, null, cv);
        Log.d("Database operation", "New Pregnancy added");
    }

    //endregion

    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //region REMEDIES DB OPERATIONS
    public void addRemedy(Remedy remedy, SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.REMEDY_NAME, remedy.getName());
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.REMEDY_PRODUCT_NUMBER, remedy.getProductNumber());
        cv.put(LivestockManagerTableData.LivestockManagerTableInformation.REMEDY_PRODUCT_GROUP, remedy.getProductGroup());
        db.insert(LivestockManagerTableData.LivestockManagerTableInformation.REMEDY_TABLE_NAME, null, cv);
        Log.d("Database operation", "New Remedy added");
    }

    public List<String> getAllProductNumbersForRemedies(SQLiteDatabase db) {
        List<String> pNumbers = new ArrayList<>();
        String selectQuery = "SELECT " + LivestockManagerTableData.LivestockManagerTableInformation.REMEDY_PRODUCT_NUMBER + " FROM "
                + LivestockManagerTableData.LivestockManagerTableInformation.REMEDY_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()) {
            do{
                pNumbers.add(cursor.getString(0));
            }while(cursor.moveToNext());
        }
        return pNumbers;
    }
    //endregion
    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //region UTILITY DB OPERATIONS
    //DROP VET TABLE
    public void deleteVetTable(SQLiteDatabase db) {
        db.delete(LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIANS_TABLE_NAME, null, null);
    }

    //create table
    public void createIncomeTable(SQLiteDatabase db) {
        db.execSQL(CREATE_INCOME_TABLE);
    }
    //endregion


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //db.execSQL("DROP TABLE IF EXISTS " + LivestockManagerTableData.LivestockManagerTableInformation.USER_TABLE_NAME);
        //db.execSQL("DROP TABLE IF EXISTS " + LivestockManagerTableData.LivestockManagerTableInformation.CATTLE_TABLE_NAME);
        //db.execSQL("DROP TABLE IF EXISTS " + LivestockManagerTableData.LivestockManagerTableInformation.VETERINARIANS_TABLE_NAME);
        //db.execSQL("DROP TABLE IF EXISTS " + LivestockManagerTableData.LivestockManagerTableInformation.INCOME_TABLE_NAME);

        // create new tables
        onCreate(db);
    }

    public ArrayList<Cursor> getData(String Query){
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[] { "message" };
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2= new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try{
            String maxQuery = Query ;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[] { "Success" });

            alc.set(1,Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0,c);
                c.moveToFirst();

                return alc ;
            }
            return alc;
        } catch(Exception sqlEx){
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
            alc.set(1,Cursor2);
            return alc;
        }


    }
}
