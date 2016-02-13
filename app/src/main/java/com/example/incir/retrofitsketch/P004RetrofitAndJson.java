package com.example.incir.retrofitsketch;


import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import com.example.incir.retrofitsketch.backbone.AddMtdToAppCompatActivity;
import com.example.incir.retrofitsketch.model.HanselandpetalStrong;

import java.util.List;

public class P004RetrofitAndJson extends AddMtdToAppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p004retrofitandjson);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());

        ListView listViewP004=(ListView)findViewById(R.id.listViewP004);
        List<HanselandpetalStrong> hanselandpetalStrongList=
                getHansepetalNetwork().getHanselandpetalStrongList();
        ArrayAdapter arrayAdapter=new ArrayAdapter(P004RetrofitAndJson.this,
                android.R.layout.simple_list_item_1);
        listViewP004.setAdapter(arrayAdapter);
        arrayAdapter.addAll(hanselandpetalStrongList);
    }

}
