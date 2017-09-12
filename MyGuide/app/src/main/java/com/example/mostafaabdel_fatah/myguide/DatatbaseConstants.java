package com.example.mostafaabdel_fatah.myguide;

/**
 * Created by Mostafa AbdEl_Fatah on 9/22/2016.
 */
public class DatatbaseConstants {

    final public static int DTABASE_VERION     =1;
    final public static String DTABASE_NAME    ="db";
    final public static String ID_FIELD        ="id";
    final public static String NAME_FIELD      ="name";
    final public static String ADDRESS_FIELD   ="address";
    final public static String PHONE_FIELD     ="phone";
    final public static String SPEC_FIELD      ="spec";
    final public static String TYPE_FIELD      ="type";
    final public static String AREA_FIELD      ="area";
    final public static String DOECTOR_TABLE   ="doctors";
    final public static String HOSPITAL_TABLE  ="hospital";
    final public static String PHARMACY_TABLE  ="pharmacy";
    final public static String HOTELS_TABLE    ="hotels";
    final public static String RESURANT_TABEL  ="restaurants";
    final public static String STUDENT_TABLE   ="student";

    final public static String DOCTORS_TABLE_SQL   =
            "CREATE TABLE "+DOECTOR_TABLE+" ( "+DatatbaseConstants.ID_FIELD +" INTEGER PRIMARY KEY AUTOINCREMENT ," +
                      NAME_FIELD+" TEXT NOT NULL , "+SPEC_FIELD +" TEXT NOT NULL , "+
                    ADDRESS_FIELD +" TEXT NOT NULL ," + PHONE_FIELD+" TEXT NOT NULL )";

    final public static String HOSPITAL_TABLE_SQL   =
            "CREATE TABLE "+HOSPITAL_TABLE+" ( "+DatatbaseConstants.ID_FIELD +" INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    NAME_FIELD+" TEXT NOT NULL ,"+TYPE_FIELD+" TEXT NOT NULL ," +
                    ADDRESS_FIELD+" TEXT NOT NULL,"+PHONE_FIELD+" TEXT NOT NULL)";

    final public static String PHARMACY_TABLE_SQL   =
            "CREATE TABLE "+PHARMACY_TABLE+" ( "+DatatbaseConstants.ID_FIELD +" INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    NAME_FIELD+" TEXT NOT NULL, "+ADDRESS_FIELD+" TEXT NOT NULL," +
                     PHONE_FIELD+" TEXT NOT NULL )";

    final public static String Hotels_TABLE_SQL   =
            "CREATE TABLE "+HOTELS_TABLE+" ( "+DatatbaseConstants.ID_FIELD +" INTEGER PRIMARY KEY AUTOINCREMENT , " +
                    NAME_FIELD+" TEXT NOT NULL, "+ADDRESS_FIELD+" TEXT NOT NULL," +
                    PHONE_FIELD+" TEXT NOT NULL )";

    final public static String RESURANT_TABLE_SQL   =
            "CREATE TABLE "+RESURANT_TABEL+" ( "+DatatbaseConstants.ID_FIELD +" INTEGER PRIMARY KEY AUTOINCREMENT , " +
                    NAME_FIELD+" TEXT NOT NULL, "+ADDRESS_FIELD+" TEXT NOT NULL," +
                    PHONE_FIELD+" TEXT NOT NULL )";

    final public static String STUDENT_TABLE_SQL   =
            "CREATE TABLE student ( "+DatatbaseConstants.ID_FIELD +" INTEGER PRIMARY KEY AUTOINCREMENT , " +
                    NAME_FIELD+" TEXT NOT NULL,"+AREA_FIELD+" TEXT NOT NULL," +
                    PHONE_FIELD+" TEXT NOT NULL )";

    public static String dropTable (String tableName){
        return "DROP TABLE "+tableName+" IF EXISTS";
    }


}
