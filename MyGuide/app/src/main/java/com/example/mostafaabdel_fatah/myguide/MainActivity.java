package com.example.mostafaabdel_fatah.myguide;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {

    String [] images=
            {"الاطباء","المستشفيات","الصيدليات","الفنادق","المطاعم","السماسره "};
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView)findViewById(R.id.listView);
        // get font file from asset forder
        AssetManager asset=getAssets();
        Typeface mytype=Typeface.createFromAsset(getAssets(), "aldhabi.ttf");

        CustomAdapter adapter=new CustomAdapter(this,images,asset);
        list.setAdapter(adapter);
        list.setOnItemClickListener (new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this , SearchActivity.class);
                intent.putExtra("index",String.valueOf(position));
                startActivity(intent);

            }
        });
    }


}
