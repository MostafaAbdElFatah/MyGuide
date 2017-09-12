package com.mostafaabdel_fatah.myguideonline;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mostafaabdel_fatah.myguideonline.dbClass.Doctor;
import com.mostafaabdel_fatah.myguideonline.dbClass.Hosiptal;
import com.mostafaabdel_fatah.myguideonline.dbClass.Hotel;
import com.mostafaabdel_fatah.myguideonline.dbClass.Pharmacy;
import com.mostafaabdel_fatah.myguideonline.dbClass.Resturant;
import com.mostafaabdel_fatah.myguideonline.dbClass.Student;

import java.util.ArrayList;

public class dbConnector extends SQLiteOpenHelper {

    Context context;
    public dbConnector(Context context){
        super(context,DatatbaseConstants.DTABASE_NAME,null,DatatbaseConstants.DTABASE_VERION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            //create tables in sqllite database
            db.execSQL(DatatbaseConstants.DOCTORS_TABLE_SQL);
            db.execSQL(DatatbaseConstants.HOSPITAL_TABLE_SQL);
            db.execSQL(DatatbaseConstants.Hotels_TABLE_SQL);
            db.execSQL(DatatbaseConstants.PHARMACY_TABLE_SQL);
            db.execSQL(DatatbaseConstants.RESURANT_TABLE_SQL);
            db.execSQL(DatatbaseConstants.STUDENT_TABLE_SQL);

        }catch (Exception e){
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DatatbaseConstants.dropTable(DatatbaseConstants.DOECTOR_TABLE));
            db.execSQL(DatatbaseConstants.dropTable(DatatbaseConstants.HOSPITAL_TABLE));
            db.execSQL(DatatbaseConstants.dropTable(DatatbaseConstants.PHARMACY_TABLE));
            db.execSQL(DatatbaseConstants.dropTable(DatatbaseConstants.HOTELS_TABLE));
            db.execSQL(DatatbaseConstants.dropTable(DatatbaseConstants.RESURANT_TABEL));
            db.execSQL(DatatbaseConstants.dropTable(DatatbaseConstants.STUDENT_TABLE));
            onCreate(db);
        }catch (Exception e) {
        }
        //end function
    }

    public void InsertIntoDatabase(String tableName, ArrayList<Object> list){

        SQLiteDatabase db = this.getWritableDatabase();

        for (int j = 0 ; j < list.size(); j++){
            ContentValues insert = new ContentValues();
            switch (tableName){
                case  DatatbaseConstants.DOECTOR_TABLE:
                        Doctor doc = (Doctor) list.get(j);
                        //insert.put(DatatbaseConstants.ID_FIELD      ,"");
                        insert.put(DatatbaseConstants.NAME_FIELD    ,doc.getName());
                        insert.put(DatatbaseConstants.SPEC_FIELD    ,doc.getSpec());
                        insert.put(DatatbaseConstants.ADDRESS_FIELD ,doc.getAddress());
                        insert.put(DatatbaseConstants.PHONE_FIELD   ,doc.getPhone());
                    break;
                case  DatatbaseConstants.HOSPITAL_TABLE:
                    Hosiptal hos = (Hosiptal) list.get(j);
                    //insert.put(DatatbaseConstants.ID_FIELD      ,hos.getId());
                    insert.put(DatatbaseConstants.NAME_FIELD    ,hos.getName());
                    insert.put(DatatbaseConstants.TYPE_FIELD    ,hos.getType());
                    insert.put(DatatbaseConstants.ADDRESS_FIELD ,hos.getAddress());
                    insert.put(DatatbaseConstants.PHONE_FIELD   ,hos.getPhone());
                    break;
                case  DatatbaseConstants.PHARMACY_TABLE:
                    Pharmacy phar = (Pharmacy) list.get(j);
                    //insert.put(DatatbaseConstants.ID_FIELD      ,phar.getId());
                    insert.put(DatatbaseConstants.NAME_FIELD    ,phar.getName());
                    insert.put(DatatbaseConstants.ADDRESS_FIELD ,phar.getAddress());
                    insert.put(DatatbaseConstants.PHONE_FIELD   ,phar.getPhone());
                    break;
                case  DatatbaseConstants.HOTELS_TABLE:
                    Hotel hot = (Hotel) list.get(j);
                   // insert.put(DatatbaseConstants.ID_FIELD      ,hot.getId());
                    insert.put(DatatbaseConstants.NAME_FIELD    ,hot.getName());
                    insert.put(DatatbaseConstants.ADDRESS_FIELD ,hot.getAddress());
                    insert.put(DatatbaseConstants.PHONE_FIELD   ,hot.getPhone());
                    break;
                case  DatatbaseConstants.RESURANT_TABEL:
                    Resturant rest = (Resturant) list.get(j);
                    //insert.put(DatatbaseConstants.ID_FIELD      ,rest.getId());
                    insert.put(DatatbaseConstants.NAME_FIELD    ,rest.getName());
                    insert.put(DatatbaseConstants.ADDRESS_FIELD ,rest.getAddress());
                    insert.put(DatatbaseConstants.PHONE_FIELD   ,rest.getPhone());
                    break;
                case  DatatbaseConstants.STUDENT_TABLE:
                    Student stud = (Student) list.get(j);
                    //insert.put(DatatbaseConstants.ID_FIELD      ,stud.getId());
                    insert.put(DatatbaseConstants.NAME_FIELD    ,stud.getName());
                    insert.put(DatatbaseConstants.AREA_FIELD    ,stud.getArea());
                    insert.put(DatatbaseConstants.PHONE_FIELD   ,stud.getPhone());
                    break;
                default:
                    insert = null;
            }
            long n = db.insert(tableName , null , insert);
            long x = n ;
        }
     // end of function
   }

    // end class
}
