package com.example.incir.retrofitsketch;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.Endpoint;

public class P123PicassoAndRetrofit extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Endpoint endpoint =new Endpoint() {   //Endpoint tanimlamak app. daha hizli hale getiriyor.
            @Override
            public String getUrl() {
                return "http://services.hanselandpetal.com";
            }

            @Override
            public String getName() {
                return null;
            }
        };
        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint(endpoint.getUrl())
                .build();

        P123FlowersInterface service= restAdapter.create(P123FlowersInterface.class);
        service.getFlowersData(new Callback<List<P123FlowersStronglyType>>() {
            @Override
            public void success(List<P123FlowersStronglyType> p123FlowersStronglyTypes, Response response) {
                ListAdapter listAdapter=new P123ArrayAdapter(getApplicationContext(),R.layout.p123customrow,p123FlowersStronglyTypes);
                setListAdapter(listAdapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
            }
        });
    }
}

/*
//bu kod blogu ustekine gore cok daha yavas calisiyor
RestAdapter restAdapter = new RestAdapter.Builder()
.setEndpoint("http://services.hanselandpetal.com")
.build();
P123FlowersInterface service=restAdapter.create(P123FlowersInterface.class);
*/
