package com.example.incir.retrofitsketch;


import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

public class P002RetrofitRestAdapterUserSearch extends ListActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        GithubService service=restAdapter.create(GithubService.class);

        ArrayAdapter<Object> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
        arrayAdapter.addAll(service.searchUsers("nelsonlaquet").items);
    }

    public interface GithubService{
        @GET("/search/users")  //tum annotation lar icin ortak yazim sekli (" ") dir
        UsersSearchResult searchUsers(@Query("q") String query);  //https://api.github.com/search/users?q=mojombo
    }
    private class UsersSearchResult{
        public List<UserSummary> items;
    }
    private class UserSummary{
        public String login;
        public String id;

        @Override
        public String toString() {
            return ("loginid=" + login + "\nid=" + id);
        }
    }
}

























