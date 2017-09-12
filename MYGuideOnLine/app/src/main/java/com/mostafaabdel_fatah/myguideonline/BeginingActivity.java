package com.mostafaabdel_fatah.myguideonline;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import com.json.mostafaabdel_fatah.myguidejson.R;


public class BeginingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 0);
        setContentView(R.layout.activity_begining);
        // insert ison data to database
        dbConnector tablesCreater = new dbConnector(BeginingActivity.this);
        SQLiteDatabase db = tablesCreater.getWritableDatabase();
        BackgroundTask backgroundTask = new BackgroundTask(BeginingActivity.this);
        backgroundTask.execute();
    }
}
