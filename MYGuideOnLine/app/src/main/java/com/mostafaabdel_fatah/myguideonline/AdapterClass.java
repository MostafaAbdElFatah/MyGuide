package com.mostafaabdel_fatah.myguideonline;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.json.mostafaabdel_fatah.myguidejson.R;

import java.util.ArrayList;
import java.util.IdentityHashMap;

/**
 * Created by Mostafa AbdEl_Fatah on 9/22/2016.
 */
public class AdapterClass extends ArrayAdapter<String> {
        ArrayList<String> titles;
        ArrayList<String> des;
        ArrayList<String> IDarray;

        Context context;
        AssetManager assets;
        String id ;
        public AdapterClass(Context context,ArrayList<String> IDarray,ArrayList<String> titles,ArrayList<String> Des,String id, AssetManager assets){
            super(context , R.layout.lists ,R.id.idfield , IDarray);
            this.titles=titles;
            this.des=Des;
            this.context=context;
            this.assets=assets;
            this.IDarray= IDarray;
            this.id=id;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater linflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row= linflater.inflate(R.layout.lists, parent, false);

            TextView name= (TextView) row.findViewById(R.id.title);
            TextView idtext= (TextView) row.findViewById(R.id.idfield);
            TextView Description= (TextView) row.findViewById(R.id.Description);

            ImageView image =(ImageView) row.findViewById(R.id.image);

            name.setText(titles.get(position));

            Description.setText(des.get(position));

            idtext.setText(IDarray.get(position));

            //************************ Select Image ****************************************

            switch (id){
                case "0":
                case "1":
                case "2":
                    image.setImageResource(R.drawable.dector);
                    break;
                case "3":
                case "4":
                case "5":
                    image.setImageResource(R.drawable.hotel);
                    break;
                default:
                    image.setImageResource(R.drawable.dector);
            }

            Typeface mytype=Typeface.createFromAsset(assets,"aldhabi.ttf");
            name.setTypeface(mytype);
            return row ;
        }
}


class CustomAdapter extends BaseAdapter {

    String [] items;
    Context context;
    AssetManager assets;
    public CustomAdapter(Context context,String []items, AssetManager assets){
        this.items=items;
        this.context=context;
        this.assets=assets;
    }

    @Override
    public int getCount() {
        return this.items.length;
    }

    @Override
    public Object getItem(int position) {
        return this.items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater linflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row= linflater.inflate(R.layout.view, parent, false);
        TextView text= (TextView) row.findViewById(R.id.textView);
        text.setText(items[position]);
        Typeface mytype=Typeface.createFromAsset(assets,"aldhabi.ttf");
        text.setTypeface(mytype);
        return row ;
    }


}

