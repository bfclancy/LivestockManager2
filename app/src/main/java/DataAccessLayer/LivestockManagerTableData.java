package DataAccessLayer;

import android.provider.BaseColumns;

/**
 * Created by asus on 9/25/2015.
 */
public class LivestockManagerTableData{

    public LivestockManagerTableData() {

    }

    public static abstract class LivestockManagerTableInformation implements BaseColumns {
        public static final String DATABASE_NAME = "livestockmanager";

        //table info for users table
        public static final String USER_TABLE_NAME = "users";
        public static final String FIRST_NAME = "firstName";
        public static final String SURNAME = "surname";
        public static final String ADDRESS = "address";
        public static final String COUNTY = "county";
        public static final String HERD_NUMBER = "herdNumber";
        public static final String PAC = "PAC";
        public static final String USER_NAME = "userName";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";

        //table info for cattle table
        public static final String CATTLE_TABLE_NAME = "cattle";
        public static final String TAG_NUMBER = "tagNumber";
        public static final String GENDER = "gender";
        public static final String DATE_OF_BIRTH = "dateOfBirth";
        public static final String DAM_TAG_NUMBER = "damTagNumber";
        public static final String SIRE_BREED = "sireBreed";
        public static final String SIRE = "sire";
        public static final String DATE_LAST_TB_TEST = "dateLastTBTEst";
        public static final String DATE_LAST_BR_TEST = "dateLastBRTest";
        public static final String DATE_MOVED_IN = "dateMovedIn";

        //TABLE INFO FOR VET TABLE
        public static final String VETERINARIANS_TABLE_NAME = "veterinarians";
        public static final String VETERINARIAN_ID = "veterinarianId";
        public static final String VETERINARIAN_NAME = "veterinarianName";
        public static final String VETERINARIAN_ADDRESS = "veterinarianAddress";
        public static final String VETERINARIAN_PHONE_NUMBER = "veterinarianPhoneNumber";

        //TABLE INFO FOR VET VISITS TABLE
        public static final String APPOINTMENTS_TABLE_NAME = "appointment";
        public static final String APPOINTMENT_ID = "appointmentId";
        public static final String APPOINTMENT_TYPE = "type";
        public static final String APPOINTMENT_TIME = "time";
        public static final String APPOINTMENT_DATE = "date";

        //TABLE INFO FOR INCOME
        public  static final String INCOME_TABLE_NAME = "income";
        public static final String INCOME_ID = "incomeId";
        public static final String INCOME_AMOUNT = "incomeAmount";
        public static final String INCOME_DATE = "incomeDate";
        public static final String INCOME_DESCRIPTION = "incomeDescription";

        //TABLE INFO FOR EXPENDITURE
        public  static final String EXPENDITURE_TABLE_NAME = "expenditure";
        public static final String EXPENDITURE_ID = "expenditureId";
        public static final String EXPENDITURE_AMOUNT = "expenditureAmount";
        public static final String EXPENDITURE_DATE = "expenditureDate";
        public static final String EXPENDITURE_DESCRIPTION = "expenditureDescription";

        //TABLE INFO FOR PREGNANCY TABLE
        public static final String PREGNANCY_TABLE_NAME = "pregnancy";
        public static final String PREGNANCY_ID = "id";
        public static final String DATE ="date";
        public static final String DUE_DATE = "dueDate";


        //TABLE INFO FOR DOSAGE TABLE
        public static final String DOSAGE_TABLE_NAME = "dosing";
        public static final String DOSE_ID = "doseId";
        public static final String DOSE_DATE = "date";
        public static final String DOSER_ID = "userId";
        public static final String PRESCRIBER_ID = "veterinarianId";
        public static final String WITHDRAWAL_DATE = "withdrawalDate";

        //TABLE INFO FOR ANIMAL DOSED TABLE
        public static final String ANIMALS_DOSED_TABLE_NAME = "animalsDosed";
        public static final String DOSAGE_ID = "doseId";
        public static final String ANIMAL_DOSED_TAG_NUMBER = "animalDosedTagNumber";

        //TABLE INFO FOR REMEDIES
        public static final String REMEDY_TABLE_NAME = "remedy";
        public static final String REMEDY_NAME = "name";
        public static final String REMEDY_PRODUCT_NUMBER = "productNumber";
        public static final String REMEDY_PRODUCT_GROUP = "productGroup";
        public static final String REMEDY_ID = "id";



    }
}
