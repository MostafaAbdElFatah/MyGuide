package com.example.mostafaabdel_fatah.myguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;
import android.widget.Toast;

public class dbConnector extends SQLiteOpenHelper {
    Context context;
    public dbConnector(Context context){
        super(context,DatatbaseConstants.DTABASE_NAME,null,DatatbaseConstants.DTABASE_VERION);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(DatatbaseConstants.DOCTORS_TABLE_SQL);
            db.execSQL(DatatbaseConstants.HOSPITAL_TABLE_SQL);
            db.execSQL(DatatbaseConstants.Hotels_TABLE_SQL);
            db.execSQL(DatatbaseConstants.PHARMACY_TABLE_SQL);
            db.execSQL(DatatbaseConstants.RESURANT_TABLE_SQL);
            db.execSQL(DatatbaseConstants.STUDENT_TABLE_SQL);
            for (int i=0;i<150;i++){
                ContentValues insert= new ContentValues();
                insert.put(DatatbaseConstants.NAME_FIELD,"ا.د/ فردوس هانم عبدالعال "+i);
                insert.put(DatatbaseConstants.ADDRESS_FIELD, i +"ش الجندي متفرع من ش النميس-مستشفي الطبييب ");
                insert.put(DatatbaseConstants.SPEC_FIELD, "الاطفال" +i);
                insert.put(DatatbaseConstants.PHONE_FIELD, "2327776,2328760");
                long n=db.insert(DatatbaseConstants.DOECTOR_TABLE , null , insert);
            }
            for (int i=0;i<15;i++){
                ContentValues insert= new ContentValues();
                insert.put(DatatbaseConstants.NAME_FIELD,"المستشفي الجامعية"+i);
                insert.put(DatatbaseConstants.ADDRESS_FIELD,i +"جامعة اسيوط");
                insert.put(DatatbaseConstants.TYPE_FIELD ,"حكومي"+i);
                insert.put(DatatbaseConstants.PHONE_FIELD,"2414141,2345730,2368371");
                db.insert(DatatbaseConstants.HOSPITAL_TABLE, null, insert);
            }
            for (int i=0;i<15;i++){
                ContentValues insert= new ContentValues();
                insert.put(DatatbaseConstants.NAME_FIELD,"صيدلية الدكتور عبدالمعتمد (24 ساعة)"+i);
                insert.put(DatatbaseConstants.ADDRESS_FIELD,i +"شارع المكتبات امام الجامعة");
                insert.put(DatatbaseConstants.PHONE_FIELD,"2348998");
                db.insert(DatatbaseConstants.PHARMACY_TABLE , null , insert);
            }
            for (int i=0;i<15;i++){
                ContentValues insert= new ContentValues();
                insert.put(DatatbaseConstants.NAME_FIELD,"دار الضيافة بجامعة اسيوط (5 نجوم)"+i);
                insert.put(DatatbaseConstants.ADDRESS_FIELD,i +"جامعة اسيوط المبني الاداري");
                insert.put(DatatbaseConstants.PHONE_FIELD,"2335816,2335823"+i);
                db.insert(DatatbaseConstants.HOTELS_TABLE , null , insert);
            }
            for (int i=0;i<15;i++){
                ContentValues insert= new ContentValues();
                insert.put(DatatbaseConstants.NAME_FIELD," مطعم الحمد   "+i);
                insert.put(DatatbaseConstants.ADDRESS_FIELD,i +" شارع الرحمن ");
                insert.put(DatatbaseConstants.PHONE_FIELD,"0100922585211,2222523355 "+i);
                db.insert(DatatbaseConstants.RESURANT_TABEL , null , insert);
            }
            for (int i=0;i<15;i++){
                ContentValues insert= new ContentValues();
                insert.put(DatatbaseConstants.NAME_FIELD," محروس حسن  "+i);
                insert.put(DatatbaseConstants.AREA_FIELD,i +"ستي");
                insert.put(DatatbaseConstants.PHONE_FIELD,"0215984411788,097444755559"+i);
                db.insert(DatatbaseConstants.STUDENT_TABLE , null , insert);
            }
        }catch (Exception e){
        }
    }
    public void insertData(){

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
    }
}
