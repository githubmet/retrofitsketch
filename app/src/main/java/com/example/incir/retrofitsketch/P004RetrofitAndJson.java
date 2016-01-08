package com.example.incir.retrofitsketch;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import java.util.List;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.Callback;
import android.app.ListActivity;

public class P004RetrofitAndJson extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("http://services.hanselandpetal.com")
                .build();

        FlowersInterface service=restAdapter.create(FlowersInterface.class);

        service.getFeed(new Callback<List<Flower>>() {
            @Override
            public void success(List<Flower> flowers, Response response) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(P004RetrofitAndJson.this, android.R.layout.simple_list_item_1); //ArrayAdapter<Object> yazmana gerek yok
                arrayAdapter.addAll(flowers);
                setListAdapter(arrayAdapter);
            }
            @Override
            public void failure(RetrofitError retrofitError) {
            }
        });

    }
    public static class Flower {
        private int productId;
        private String name;
        private String category;
        private String instructions;

        @Override
        public String toString() {
            return "Id="+productId+"\nName="+name+"\nCategory="+category+"\nInstructions="+instructions;
        }
    }

    private interface FlowersInterface {
        @GET("/feeds/flowers.json")
        void getFeed(Callback<List<Flower>> response);

        @GET("/feeds/flowers.json")
        Flower getSyncFeed();  //bu methot ile olmuyor. Birden fazla veri topluluklari var ondan galiba!
    }
}










