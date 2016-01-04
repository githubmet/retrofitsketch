package com.example.incir.retrofitsketch;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.Callback;

import java.util.List;

public class P006GithubRetrofitSade extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p006githubretrofitsade);

        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        GithubInterface service=restAdapter.create(GithubInterface.class);
        service.getGithubData(new Callback<List<GithubStronglyClass>>() {
            @Override
            public void success(List<GithubStronglyClass> githubStronglyClasses, Response response) {
                ArrayAdapter arrayAdapter = new P006GithubArrayAdapter(getApplicationContext(),R.layout.p006githubcustomrow,githubStronglyClasses);
                ListView listViewSadeP006 = (ListView) findViewById(R.id.listViewSadeP006);
                listViewSadeP006.setAdapter(arrayAdapter);

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
        private String id;

        public String getId() {
            return id;
        }
    }
}

























/*import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import retrofit.RestAdapter;
import retrofit.http.GET;
import java.util.List;

public class P006GithubRetrofitSade extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p006githubretrofitsade);

        //StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build()); //simdi bunu ortadan kaldiracagiz
        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        GithubInterface service=restAdapter.create(GithubInterface.class);

        ArrayAdapter<Object> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        ListView listViewSadeP006=(ListView)findViewById(R.id.listViewSadeP006);
        listViewSadeP006.setAdapter(arrayAdapter);

        arrayAdapter.addAll(service.getPublicGist());

    }
    public interface GithubInterface{
        @GET("/gists/public")  //url lin ednpoint ini belirtioyruz
        List<GithubStronglyClass> getPublicGist();
    }
    private class GithubStronglyClass{
        public String id;

        @Override
        public String toString() {
            return  "id='" + id + '\'';
        }
    }
}*/
