package com.example.incir.retrofitsketch;


import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.Endpoint;
import retrofit.Callback;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class P007GithubUserRepos extends ListActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Endpoint endpoint=new Endpoint() {
            @Override
            public String getUrl() {
                return "https://api.github.com";
            }

            @Override
            public String getName() {
                return null;
            }
        };
        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .build();

        GithubReposInterface githubReposInterface= restAdapter.create(GithubReposInterface.class);
        githubReposInterface.githubReposStrongList("githubmet", new Callback<List<GithubReposStrong>>() {
            @Override
            public void success(List<GithubReposStrong> githubReposStrongList, Response response) {
                ArrayAdapter arrayAdapter=new P007ArrayAdapterRepos(getApplicationContext(),R.layout.p007githubreposcustomrow,githubReposStrongList);
                setListAdapter(arrayAdapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });
    }

    public interface GithubReposInterface{
        @GET("/users/{user}/repos")
        void githubReposStrongList(@Path("user") String user,Callback<List<GithubReposStrong>> callback);  //demekki callback tipki C# params[] gibi sona eklenmeli
        //void getGithubData(Callback <List<GithubStronglyClass>> callback);
    }

    public class GithubReposStrong{
        @SerializedName("id")
        private String myId;
        @SerializedName("name")
        private String myName;
        @SerializedName("full_name")
        private String myFullName;
        @SerializedName("description")
        private String myDescription;

        @SerializedName("owner")
        private Map<String,String> mapOwner;  //bu sekilde sanirsam tum dizi verilerini aldigimiz icin sakincali
        //Biz bir sonraki basamakta yapmamiz gereken sadece gerekli verileri almayi deneyelim.
        public Map<String, String> getMapOwner() {
            return mapOwner;
        }

        public String getMyDescription() {
            return myDescription;
        }
        public String getMyId() {
            return myId;
        }

        public String getMyName() {
            return myName;
        }

        public String getMyFullName() {
            return myFullName;
        }
    }
}
