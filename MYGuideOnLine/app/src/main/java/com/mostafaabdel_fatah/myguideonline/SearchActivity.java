package com.mostafaabdel_fatah.myguideonline;

import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.json.mostafaabdel_fatah.myguidejson.R;

import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity {

    ArrayList<String> title=new ArrayList<String>();
    ArrayList<String>  des=new ArrayList<String>();
    ArrayList<String>  idarray=new ArrayList<String>();
    String postion, tableName=DatatbaseConstants.DOECTOR_TABLE;
    String[] colums;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);
        list=(ListView)findViewById(R.id.list2);
        AssetManager asset=getAssets();
        Typeface mytype=Typeface.createFromAsset(getAssets(), "aldhabi.ttf");

        //************************** Get Data From Other Activity *********************************

        try {
            Intent intent = getIntent();
            postion = intent.getStringExtra("index").toString();
        }catch (Exception e){
            Toast.makeText(this, "Message from Search: " +e.toString(), Toast.LENGTH_LONG).show();
        }
        //************************** Get Data From Database *********************************
        final String index=postion;
        dbConnector sv=new dbConnector(SearchActivity.this);
        SQLiteDatabase db=sv.getReadableDatabase();

        //****************************** Select Table Name ***********************************

        switch (postion){
            case "0":
                colums= new String[]{ DatatbaseConstants.ID_FIELD,DatatbaseConstants.NAME_FIELD,DatatbaseConstants.SPEC_FIELD,
                        DatatbaseConstants.ADDRESS_FIELD,DatatbaseConstants.PHONE_FIELD};
                tableName=DatatbaseConstants.DOECTOR_TABLE;
                break;
            case "1":
                colums= new String[]{  DatatbaseConstants.ID_FIELD,DatatbaseConstants.NAME_FIELD,DatatbaseConstants.TYPE_FIELD,
                        DatatbaseConstants.ADDRESS_FIELD , DatatbaseConstants.PHONE_FIELD};
                tableName=DatatbaseConstants.HOSPITAL_TABLE;
                break;
            case "2":
                colums= new String[]{ DatatbaseConstants.ID_FIELD,DatatbaseConstants.NAME_FIELD, DatatbaseConstants.ADDRESS_FIELD,
                        DatatbaseConstants.PHONE_FIELD};
                tableName=DatatbaseConstants.PHARMACY_TABLE;
                break;
            case "3":
                colums= new String[]{ DatatbaseConstants.ID_FIELD,DatatbaseConstants.NAME_FIELD, DatatbaseConstants.ADDRESS_FIELD,
                        DatatbaseConstants.PHONE_FIELD};
                tableName=DatatbaseConstants.HOTELS_TABLE;
                break;
            case "4":
                colums= new String[]{ DatatbaseConstants.ID_FIELD,DatatbaseConstants.NAME_FIELD, DatatbaseConstants.ADDRESS_FIELD,
                        DatatbaseConstants.PHONE_FIELD};
                tableName=DatatbaseConstants.RESURANT_TABEL;
                break;
            case "5":
                colums= new String[]{ DatatbaseConstants.ID_FIELD,DatatbaseConstants.NAME_FIELD, DatatbaseConstants.AREA_FIELD
                        ,DatatbaseConstants.PHONE_FIELD};
                tableName=DatatbaseConstants.STUDENT_TABLE;
                break;
        }

        //******************************************************************************************

        try {
            Cursor cursor=db.query(tableName, colums, null, null, null, null, null);
            while (cursor.moveToNext()){
                   idarray.add(cursor.getString(0));
                    title.add( cursor.getString(1) );
                    des.add(cursor.getString(2));
            }
            AdapterClass adapter=new AdapterClass(this,idarray,title,des,postion,asset);
            list.setAdapter(adapter);
            cursor.close();
            db.close();
        }catch (Exception e){
            Toast.makeText(this,"Message: " +e.toString() ,Toast.LENGTH_LONG).show();
        }

        list.setOnItemClickListener (new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Intent intent = new Intent(SearchActivity.this ,DetailesActivity.class);
                    intent.putExtra("index", index );
                    intent.putExtra("id",String.valueOf(list.getItemAtPosition(position)));
                    startActivity(intent);
                }catch (Exception e){

                }
            }
        });

    }
}
