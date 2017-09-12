package com.example.mostafaabdel_fatah.myguide;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;


public class BeginingActivity extends AppCompatActivity {

    private int time=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 0);
        setContentView(R.layout.activity_begining);
        dbConnector sv=new dbConnector(BeginingActivity.this);
        SQLiteDatabase db=sv.getWritableDatabase();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent page = new Intent();
                page.setClass(getApplicationContext(), MainActivity.class);
                startActivity(page);
                finish();
            }
        }, 5000);
    }
}
