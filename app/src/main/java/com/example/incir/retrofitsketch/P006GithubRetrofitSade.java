package com.example.incir.retrofitsketch;


import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import com.example.incir.retrofitsketch.adapter.P006GithubArrayAdapter;
import com.example.incir.retrofitsketch.backbone.AddMtdToAppCompatActivity;
import com.example.incir.retrofitsketch.model.GithubPublicGistsStrong;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class P006GithubRetrofitSade extends AddMtdToAppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p006githubretrofitsade);

        final ListView listViewP006= (ListView)findViewById(R.id.listViewP006);

        getGithubNetwork().getGithubPublicGistsStrongCallback(new Callback<List<GithubPublicGistsStrong>>() {
            @Override
            public void success(List<GithubPublicGistsStrong> githubPublicGistsStrongs, Response response) {
                ArrayAdapter arrayAdapter= new P006GithubArrayAdapter(P006GithubRetrofitSade.this,
                        R.layout.p006githubcustomrow,githubPublicGistsStrongs);
                listViewP006.setAdapter(arrayAdapter);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
