package com.example.incir.retrofitsketch;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import com.example.incir.retrofitsketch.adapter.P013ArrayAdapter;
import com.example.incir.retrofitsketch.backbone.AddMtdToAppCompatActivity;
import com.example.incir.retrofitsketch.model.StackexchangeQuatoRemainigStrong;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.List;

public class P013StackexchageItemsDetails extends AddMtdToAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p013stackexchangeitemsdetails);

        final ListView listViewP013=(ListView)findViewById(R.id.listViewP013);

        getStackexchangeNetwork().getItemsDetails(new Callback<StackexchangeQuatoRemainigStrong>() {
            @Override
            public void success(StackexchangeQuatoRemainigStrong stackexchangeQuatoRemainigStrong, Response response) {
                List<StackexchangeQuatoRemainigStrong.itemsDetail> itemsDetailList=
                        stackexchangeQuatoRemainigStrong.getItems();
                ArrayAdapter arrayAdapter = new P013ArrayAdapter(
                        P013StackexchageItemsDetails.this,R.layout.p013customrow,
                        itemsDetailList);
                listViewP013.setAdapter(arrayAdapter);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
