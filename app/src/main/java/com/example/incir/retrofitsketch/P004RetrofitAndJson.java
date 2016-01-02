package com.example.incir.retrofitsketch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.Callback;

public class P004RetrofitAndJson extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001retrofitrestadapterlist);

        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("http://services.hanselandpetal.com")
                .build();

        FlowersInterface service=restAdapter.create(FlowersInterface.class);
        service.getFeed(new Callback<List<Flower>>() {
            @Override
            public void success(List<Flower> flowers, Response response) {
                ListView listViewP001 = (ListView) findViewById(R.id.listViewP001);
                ArrayAdapter arrayAdapter = new ArrayAdapter(P004RetrofitAndJson.this, android.R.layout.simple_list_item_1);
                listViewP001.setAdapter(arrayAdapter);
                arrayAdapter.addAll(flowers);
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
            return "Id="+productId+"\nname="+name+"\ncategory="+category+"\ninstructions="+instructions;
        }
        public Flower() {}
        public Flower(int productId, String name, String category, String instructions) {
            this.productId = productId;
            this.name = name;
            this.category = category;
            this.instructions = instructions;
        }
        public int getProductId() {
            return productId;
        }
        public String getName() {
            return name;
        }
        public String getCategory() {
            return category;
        }
        public String getInstructions() {
            return instructions;
        }
        public void setProductId(int productId) {
            this.productId = productId;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setCategory(String category) {
            this.category = category;
        }
        public void setInstructions(String instructions) {
            this.instructions = instructions;
        }
        public List<Flower> getFlowers(Callback<List<Flower>> callback) {
            List<Flower> listFlower = new ArrayList<>();
            listFlower.add((Flower) callback);
            return listFlower;
        }
    }

    private interface FlowersInterface {
        @GET("/feeds/flowers.json")
        void getFeed(Callback<List<Flower>> response);
    }
}





/*
//id and created_date
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

public class P123Deneme extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001retrofitrestadapterlist);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        GithubService service= restAdapter.create(GithubService.class);

        ArrayAdapter<Object> arrayAdapter=new ArrayAdapter<Object>(this,android.R.layout.simple_list_item_1);
        ListView listViewP001= (ListView)findViewById(R.id.listViewP001);
        listViewP001.setAdapter(arrayAdapter);
        arrayAdapter.addAll(service.getPublicGistId());
    }
    private class Gist{
        public String id;
        public String created_at;

        @Override
        public String toString() {
            return "id= "+id+"\ncreated date= "+created_at;
        }
    }
    private interface GithubService{
        @GET("/gists/public")
        List<Gist> getPublicGistId();
    }
}
*/











