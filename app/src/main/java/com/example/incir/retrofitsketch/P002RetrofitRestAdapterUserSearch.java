package com.example.incir.retrofitsketch;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

public class P002RetrofitRestAdapterUserSearch extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p002retrofitrestadapterusersearch);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        GithubService service=restAdapter.create(GithubService.class);

        ArrayAdapter<Object> listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        ListView listViewP126=(ListView)findViewById(R.id.listViewP002);
        listViewP126.setAdapter(listAdapter);

        listAdapter.addAll(service.searchUsers("nelsonlaquet").items);

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


























