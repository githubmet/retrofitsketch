package com.example.incir.retrofitsketch.backbone;


import android.app.Application;

import retrofit.RestAdapter;
import retrofit.Endpoint;

public class AddObjectToApp extends Application {
    RestAdapter restAdapterGithub;
    RestAdapter restAdapterHaselandpetal;
    RestAdapter restAdapterStackexchange;
    @Override
    public void onCreate() {
        super.onCreate();

        Endpoint endpoint=new Endpoint() { //declare this first is fastest way.
            @Override
            public String getUrl() {
                return "https://api.github.com";
            }

            @Override
            public String getName() {
                return null;
            }
        };

        restAdapterGithub=new RestAdapter.Builder() //Bir kere olmasi asagidakinde cok olmasindan iyidir.
                .setEndpoint(endpoint)
                .build();

        Endpoint endpoint2=new Endpoint() {
            @Override
            public String getUrl() {
                return "http://services.hanselandpetal.com";
            }

            @Override
            public String getName() {
                return null;
            }
        };

        restAdapterHaselandpetal=new RestAdapter.Builder()
                .setEndpoint(endpoint2.getUrl())
                .build();

        Endpoint endpoint3=new Endpoint() {
            @Override
            public String getUrl() {
                return "https://api.stackexchange.com";
            }

            @Override
            public String getName() {
                return null;
            }
        };
        restAdapterStackexchange=new RestAdapter.Builder()
                .setEndpoint(endpoint3.getUrl())
                .build();

    }
    public RestAdapter getRetrofitGithub(){
        return restAdapterGithub;
    }
    public RestAdapter getRetrofitHaselandpetal(){
        return restAdapterHaselandpetal;
    }

    public RestAdapter getRestAdapterStackexchange(){
        return restAdapterStackexchange;
    }
}
