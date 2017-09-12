package com.example.mostafaabdel_fatah.myguide;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetailesActivity extends AppCompatActivity {

    String index = "0", ID = null, tableName = DatatbaseConstants.DOECTOR_TABLE;
    String name = "الاسم", address = "العنوان", phone = "التليفون", sep = "التخصص", type = " النوع ", area = " المنطقة ";
    String[] colums;
    int image = R.drawable.dector;
    static Context context;
    String telePhone;
    private AlertDialog.Builder builder1;
    String callingPhones;
    private AlertDialog dialog;
    String[] phones;
    private AlertDialog.Builder builder2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailes);
        RelativeLayout panel = (RelativeLayout) findViewById(R.id.panel);
        TextView textArea = (TextView) findViewById(R.id.detailes);
        context = this.getApplicationContext();

        try {
            Intent intent = getIntent();
            index = intent.getStringExtra("index").toString();
            ID = intent.getStringExtra("id").toString();
        } catch (Exception e) {
            Toast.makeText(this, "Message from Detalis: " + e.toString(), Toast.LENGTH_LONG).show();
        }

        //***************** set Background image to RelativeLayout *********************************

        switch (index) {
            case "0":
            case "1":
            case "2":
                panel.setBackgroundResource(R.drawable.dector);
                break;
            case "3":
            case "4":
            case "5":
                panel.setBackgroundResource(R.drawable.hotel2);
                break;
            default:
                panel.setBackgroundResource(R.drawable.dector);
        }

        dbConnector sv = new dbConnector(DetailesActivity.this);
        SQLiteDatabase db = sv.getReadableDatabase();

        //****************************** Select Table Name ***********************************

        switch (index) {
            case "0":
                colums = new String[]{DatatbaseConstants.ID_FIELD, DatatbaseConstants.NAME_FIELD, DatatbaseConstants.SPEC_FIELD,
                        DatatbaseConstants.ADDRESS_FIELD, DatatbaseConstants.PHONE_FIELD};
                tableName = DatatbaseConstants.DOECTOR_TABLE;
                break;
            case "1":
                colums = new String[]{DatatbaseConstants.ID_FIELD, DatatbaseConstants.NAME_FIELD, DatatbaseConstants.TYPE_FIELD,
                        DatatbaseConstants.ADDRESS_FIELD, DatatbaseConstants.PHONE_FIELD};
                tableName = DatatbaseConstants.HOSPITAL_TABLE;
                break;
            case "2":
                colums = new String[]{DatatbaseConstants.ID_FIELD, DatatbaseConstants.NAME_FIELD, DatatbaseConstants.ADDRESS_FIELD,
                        DatatbaseConstants.PHONE_FIELD};
                tableName = DatatbaseConstants.PHARMACY_TABLE;
                break;
            case "3":
                colums = new String[]{DatatbaseConstants.ID_FIELD, DatatbaseConstants.NAME_FIELD, DatatbaseConstants.ADDRESS_FIELD,
                        DatatbaseConstants.PHONE_FIELD};
                tableName = DatatbaseConstants.HOTELS_TABLE;
                break;
            case "4":
                colums = new String[]{DatatbaseConstants.ID_FIELD, DatatbaseConstants.NAME_FIELD, DatatbaseConstants.ADDRESS_FIELD,
                        DatatbaseConstants.PHONE_FIELD};
                tableName = DatatbaseConstants.RESURANT_TABEL;
                break;
            case "5":
                colums = new String[]{DatatbaseConstants.ID_FIELD, DatatbaseConstants.NAME_FIELD, DatatbaseConstants.AREA_FIELD
                        , DatatbaseConstants.PHONE_FIELD};
                tableName = DatatbaseConstants.STUDENT_TABLE;
                break;

        }

        //******************************************************************************************
        try {
            Cursor cursor = db.query(tableName, colums, DatatbaseConstants.ID_FIELD + "=" + ID, null, null, null, null);
            while (cursor.moveToNext()) {
                switch (index) {
                    case "0":
                        textArea.setText(name + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.NAME_FIELD)) + "\n");
                        textArea.setText(textArea.getText() + sep + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.SPEC_FIELD)) + "\n");
                        textArea.setText(textArea.getText() + address + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.ADDRESS_FIELD)) + "\n");
                        textArea.setText(textArea.getText() + phone + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.PHONE_FIELD)) + "\n");
                        telePhone = cursor.getString(cursor.getColumnIndex(DatatbaseConstants.PHONE_FIELD));
                        break;
                    case "1":
                        textArea.setText(name + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.NAME_FIELD)) + "\n");
                        textArea.setText(textArea.getText() + type + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.TYPE_FIELD)) + "\n");
                        textArea.setText(textArea.getText() + address + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.ADDRESS_FIELD)) + "\n");
                        textArea.setText(textArea.getText() + phone + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.PHONE_FIELD)) + "\n");
                        telePhone = cursor.getString(cursor.getColumnIndex(DatatbaseConstants.PHONE_FIELD));
                        break;
                    case "2":
                    case "3":
                    case "4":
                        textArea.setText(name + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.NAME_FIELD)) + "\n");
                        textArea.setText(textArea.getText() + address + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.ADDRESS_FIELD)) + "\n");
                        textArea.setText(textArea.getText() + phone + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.PHONE_FIELD)) + "\n");
                        telePhone = cursor.getString(cursor.getColumnIndex(DatatbaseConstants.PHONE_FIELD));
                        break;
                    case "5":
                        textArea.setText(name + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.NAME_FIELD)) + "\n");
                        textArea.setText(textArea.getText() + area + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.AREA_FIELD)) + "\n");
                        textArea.setText(textArea.getText() + phone + ":" + cursor.getString(cursor.getColumnIndex(DatatbaseConstants.PHONE_FIELD)) + "\n");
                        telePhone = cursor.getString(cursor.getColumnIndex(DatatbaseConstants.PHONE_FIELD));
                        break;

                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "Message: " + e.getMessage(), Toast.LENGTH_LONG).show();
            textArea.setText(e.toString());
        }

        //******************************************************************************************
        phones = telePhone.split(",");
        if (phones.length == 1 ) {
            callingPhones = phones[0];
        } else if (phones.length > 1 ) {
            builder1 = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_DARK);
            builder1.setTitle("اختر رقم التليفون")
                    .setSingleChoiceItems(phones, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            callingPhones = phones[which];
                            Intent intent = new Intent(Intent.ACTION_CALL);
                            intent.setData(Uri.parse("tel:" + callingPhones));
                            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                return;
                            }
                            startActivity(intent);
                            dialog.dismiss();
                        }
                    });
            builder2 = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_DARK);
            builder2.setTitle("اختر رقم التليفون")
                    .setSingleChoiceItems(phones, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            callingPhones = phones[which];
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+callingPhones));
                            intent.putExtra("sms_body", "Message body SMS here ........ ");
                            startActivity(intent);
                            dialog.dismiss();
                        }
                    });
        }
        //******************************************************************************************

    }

    public void Calling_btn_Clicked(View view) {
        if (phones.length > 1 ) {
            dialog = builder1.create();
            dialog.show();
        }else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + callingPhones ));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            startActivity(intent);
        }
    }

    public void SMS_btn_Clicked(View view) {
        if (phones.length > 1 ) {
            dialog = builder2.create();
            dialog.show();
        }else {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+callingPhones));
            intent.putExtra("sms_body", "Message body od SMS");
            startActivity(intent);
        }
    }
}
