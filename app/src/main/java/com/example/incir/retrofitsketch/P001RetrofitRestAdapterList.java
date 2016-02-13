package com.example.incir.retrofitsketch;


import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import com.example.incir.retrofitsketch.backbone.AddMtdToAppCompatActivity;
import com.example.incir.retrofitsketch.model.GithubGistsStrong;

import java.util.List;

import android.os.StrictMode;

public class P001RetrofitRestAdapterList extends AddMtdToAppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001retrofitrestadapterlist);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());  //bunun ne ise yaradigini bilmiyorum

        ListView listViewP001= (ListView)findViewById(R.id.listViewP001);
        List<GithubGistsStrong> githubGistsStrongList= getGithubNetwork().getGithubGistsStrongList();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        listViewP001.setAdapter(arrayAdapter);
        arrayAdapter.addAll(githubGistsStrongList);
    }
}