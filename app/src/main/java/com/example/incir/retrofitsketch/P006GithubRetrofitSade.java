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
import retrofit.Callback;
import retrofit.Endpoint;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class P006GithubRetrofitSade extends ListActivity {
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
                .setEndpoint(endpoint.getUrl()) //endpoint daha once tanimlanmali.
                .build();

        GithubInterface service=restAdapter.create(GithubInterface.class);
        service.getGithubData(new Callback<List<GithubStronglyClass>>() {
            @Override
            public void success(List<GithubStronglyClass> githubStronglyClasses, Response response) {
                ArrayAdapter arrayAdapter = new P006GithubArrayAdapter(getApplicationContext(),R.layout.p006githubcustomrow,githubStronglyClasses);
                setListAdapter(arrayAdapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });
    }

    public interface GithubInterface{
        @GET("/gists/public")  //url lin ednpoint ini belirtioyruz
        void getGithubData(Callback <List<GithubStronglyClass>> callback);
    }

    public class GithubStronglyClass{
        @SerializedName("id")
        private String myId;
        @SerializedName("description")
        private String MyDescription;
        public String getMyId() {
            return myId;
        }
        public String getMyDescription() {
            return MyDescription;
        }
    }

}
