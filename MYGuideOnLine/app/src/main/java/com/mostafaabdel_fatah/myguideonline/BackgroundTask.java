package com.mostafaabdel_fatah.myguideonline;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mostafaabdel_fatah.myguideonline.dbClass.Doctor;
import com.mostafaabdel_fatah.myguideonline.dbClass.Hosiptal;
import com.mostafaabdel_fatah.myguideonline.dbClass.Hotel;
import com.mostafaabdel_fatah.myguideonline.dbClass.Pharmacy;
import com.mostafaabdel_fatah.myguideonline.dbClass.Resturant;
import com.mostafaabdel_fatah.myguideonline.dbClass.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;


public class BackgroundTask extends AsyncTask<Void,String,String>{

    String db_url = "http://10.0.2.2/MyWebSites/MyDatabasseMysqlOnline.php";
    Context context;
    Activity activity;
    boolean isFinish = false;
    AlertDialog.Builder builder;

    public  BackgroundTask(Context context){
        this.context = context;
        activity = (Activity)this.context;
    }

    @Override
    protected void onPreExecute() {
        builder = new AlertDialog.Builder(this.activity);
        this.isFinish = false;
    }

    @Override
    protected String doInBackground(Void... voids) {
        StringBuilder stringBuilder = null;

            try {
                URL url = new URL(this.db_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                stringBuilder = new StringBuilder();
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line+"\n");

                }
                httpURLConnection.disconnect();
                Thread.sleep(2000);
                inputStream.close();
                bufferedReader.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            }catch (Exception e){
                Toast.makeText(this.context,e.getMessage(),Toast.LENGTH_LONG).show();
            }

        return   stringBuilder.toString().trim();
    }


    @Override
    protected void onPostExecute(String json) {
        try {
            if(json != null) {
                JSONObject jsonObject = new JSONObject(json);
                JSONArray doctorsJSON = jsonObject.getJSONArray("doctors");


                ArrayList<Object> list = new ArrayList<Object>();
                for (int i = 0 ; i < doctorsJSON.length() ; i++) {
                    JSONObject docObject = doctorsJSON.getJSONObject(i);
                    Doctor doc = new Doctor();
                    doc.setId(      docObject.getString("id")      );
                    doc.setName(    docObject.getString("name")    );
                    doc.setSpec(    docObject.getString("spec")    );
                    doc.setAddress( docObject.getString("address") );
                    doc.setPhone(   docObject.getString("phone")   );
                    list.add(doc);

                }
                dbConnector db = new dbConnector(this.context);
                db.InsertIntoDatabase(DatatbaseConstants.DOECTOR_TABLE,list);
                list = new ArrayList<Object>();

                JSONArray hospitalJSON = jsonObject.getJSONArray("hospital");

                for (int i = 0 ; i < hospitalJSON.length() ; i++) {
                    JSONObject hospObject = hospitalJSON.getJSONObject(i);
                    Hosiptal hosiptal = new Hosiptal();
                    hosiptal.setId(      hospObject.getString("id")      );
                    hosiptal.setName(    hospObject.getString("name")    );
                    hosiptal.setType(    hospObject.getString("type")    );
                    hosiptal.setAddress( hospObject.getString("address") );
                    hosiptal.setPhone(   hospObject.getString("phone")   );
                    list.add(hosiptal);
                }
                db.InsertIntoDatabase(DatatbaseConstants.HOSPITAL_TABLE,list);
                list = new ArrayList<Object>();

                JSONArray hotelsJSON = jsonObject.getJSONArray("hotels");

                for (int i = 0 ; i < hotelsJSON.length() ; i++) {
                    JSONObject hotelObject = hotelsJSON.getJSONObject(i);
                    Hotel hotel = new Hotel();
                    hotel.setId(      hotelObject.getString("id")      );
                    hotel.setName(    hotelObject.getString("name")    );
                    hotel.setAddress( hotelObject.getString("address") );
                    hotel.setPhone(   hotelObject.getString("phone")   );
                    list.add(hotel);
                }
                db.InsertIntoDatabase(DatatbaseConstants.HOTELS_TABLE,list);
                list = new ArrayList<Object>();

                JSONArray pharJSON = jsonObject.getJSONArray("pharmacy");

                for (int i = 0 ; i < pharJSON.length() ; i++) {
                    JSONObject pharObject = pharJSON.getJSONObject(i);
                    Pharmacy pharmacy = new Pharmacy();
                    pharmacy.setId(      pharObject.getString("id")      );
                    pharmacy.setName(    pharObject.getString("name")    );
                    pharmacy.setAddress( pharObject.getString("address") );
                    pharmacy.setPhone(   pharObject.getString("phone")   );
                    list.add(pharmacy);
                }
                db.InsertIntoDatabase(DatatbaseConstants.PHARMACY_TABLE,list);
                list = new ArrayList<Object>();

                JSONArray restJSON = jsonObject.getJSONArray("restaurants");

                for (int i = 0 ; i < restJSON.length() ; i++) {
                    JSONObject restObject = restJSON.getJSONObject(i);
                    Resturant resturant = new Resturant();
                    resturant.setId(      restObject.getString("id")      );
                    resturant.setName(    restObject.getString("name")    );
                    resturant.setAddress( restObject.getString("address") );
                    resturant.setPhone(   restObject.getString("phone")   );
                    list.add(resturant);
                }
                db.InsertIntoDatabase(DatatbaseConstants.RESURANT_TABEL,list);

                list = new ArrayList<Object>();

                JSONArray studJSON = jsonObject.getJSONArray("student");

                for (int i = 0 ; i < studJSON.length() ; i++) {
                    JSONObject studObject = studJSON.getJSONObject(i);
                    Student student = new Student();
                    student.setId(      studObject.getString("id")      );
                    student.setName(    studObject.getString("name")    );
                    student.setArea(    studObject.getString("area") );
                    student.setPhone(   studObject.getString("phone")   );
                    list.add(student);
                }

                db.InsertIntoDatabase(DatatbaseConstants.STUDENT_TABLE,list);

            }else{
                builder.setTitle("SomeThing is error");
                builder.setMessage("Error in Connection..");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        activity.finish();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent page = new Intent();
                page.setClass(context.getApplicationContext(), MainActivity.class);
                context.startActivity(page);
                ((Activity) context).finish();
            }
        }, 2000);
        // end function
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void  ShowDialog(String title, String message){
            builder.setTitle(title);
            builder.setMessage(message);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    activity.finish();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

    }
}
