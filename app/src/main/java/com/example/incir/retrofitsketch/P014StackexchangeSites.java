package com.example.incir.retrofitsketch;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.incir.retrofitsketch.adapter.P014ArrayAdapter;
import com.example.incir.retrofitsketch.backbone.AddMtdToAppCompatActivity;
import com.example.incir.retrofitsketch.model.StackexchangeSitesStrong;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class P014StackexchangeSites extends AddMtdToAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p014stackexhangesites);

        final ListView listViewP014=(ListView)findViewById(R.id.listViewP014);

        getStackexchangeNetwork().getSitesStrong(new Callback<StackexchangeSitesStrong>() {
            @Override
            public void success(StackexchangeSitesStrong stackexchangeSitesStrong, Response response) {
                List<StackexchangeSitesStrong.itemsDetails> itemsDetailsList=
                        stackexchangeSitesStrong.getItems();
                ArrayAdapter arrayAdapter=new P014ArrayAdapter(P014StackexchangeSites.this,
                        R.layout.p014customrow,itemsDetailsList);
                listViewP014.setAdapter(arrayAdapter);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
