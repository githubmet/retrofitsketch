package com.example.incir.retrofitsketch;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import com.example.incir.retrofitsketch.adapter.P005ArrayAdapterClass;
import com.example.incir.retrofitsketch.backbone.AddMtdToAppCompatActivity;
import com.example.incir.retrofitsketch.model.HanselandpetalStrong;

import java.util.List;

public class P005PicassoAndRetrofit extends AddMtdToAppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p005picassoandretrofit);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build()); //hala anlamadim

        ListView listViewP005=(ListView)findViewById(R.id.listViewP005);

        List<HanselandpetalStrong> hanselandpetalStrongList= getHansepetalNetwork()
                .getHanselandpetalStrongList();
        ArrayAdapter arrayAdapter=new P005ArrayAdapterClass(P005PicassoAndRetrofit.this,
                R.layout.p005picassoretrofitcustomrow,hanselandpetalStrongList);
        listViewP005.setAdapter(arrayAdapter);
    }
}