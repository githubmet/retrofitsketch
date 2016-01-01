package com.example.incir.retrofitsketch;


import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public class P003RetrofitRestAdapterUserDetails extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p003retrofitrestadapteruserdetails);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        final GithubService service=restAdapter.create(GithubService.class);

        final ArrayAdapter<Object> listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        ListView listViewP126=(ListView)findViewById(R.id.listViewP003);
        listViewP126.setAdapter(listAdapter);

        listAdapter.addAll(service.searchUsers("nelsonlaquet").items);

        listViewP126.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        UserSummary summary=(UserSummary)listAdapter.getItem(position);
                        //service.getUser(summary.login);   //bunu cozmek icin Async yapmaliyiz

                        service.getUserAsync(summary.login, new Callback<UsersDetails>() {
                            @Override
                            public void success(UsersDetails usersDetails, Response response) {
                                Toast.makeText(P003RetrofitRestAdapterUserDetails.this,usersDetails.location,Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void failure(RetrofitError retrofitError) {

                            }
                        });
                    }
                }
        );

    }

    private class Gist{
        public String id;
        public HashMap<String, GistFile> files;  //eger files a baska bir isim vermek istiyor isen @serialzi.. attribute kullan

        @Override
        public String toString() {
            String output=id + ": ";
            for(Map.Entry<String,GistFile> file: files.entrySet()){
                output +=file.getKey()+"="+file.getValue().type+", ";
            }
            return output;
        }
    }
    private class GistFile{
        public String type;
        public String filename;
    }

    public interface GithubService{
        @GET("/gists/public")  //url lin ednpoint ini belirtioyruz
        List<Gist> getPublicGist();

        @GET("/search/users")
        UsersSearchResult searchUsers(@Query("q") String query);

        @GET("/users/{username}")  //senkronize
        UsersDetails getUser(@Path("username")String username); //buradaki @Path ile ifade edilen yukarida @GET ile belirtilen url satirina otomatik eklenir.

        @GET("/users/{username}")  //asenkronize aradaki tek fark callBack
        void  getUserAsync (@Path("username")String username, Callback<UsersDetails> callback);


    }
    private class UsersDetails{
        public String id;
        public String location;

        @Override
        public String toString() {
            return "UsersDetails{" +
                    "id='" + id + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }
    }
    private class UsersSearchResult{
        public int total_count;
        public boolean incomplte_result;
        public List<UserSummary> items;
    }
    private class UserSummary{
        public String login;
        public String id;

        @Override
        public String toString() {
            return "UserSummary{"+"loginid='"+login+"\''+"+", id='"+id+"\''+"+")";
        }

    }
}


























