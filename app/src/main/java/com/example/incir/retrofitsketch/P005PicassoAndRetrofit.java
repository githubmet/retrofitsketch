package com.example.incir.retrofitsketch;


import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;


public class P005PicassoAndRetrofit extends ListActivity { //Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("http://services.hanselandpetal.com")
                .build();

        FlowersApiInterface service= restAdapter.create(FlowersApiInterface.class);
        service.getData(new Callback<List<P005FlowerStrongClass>>() {
            @Override
            public void success(List<P005FlowerStrongClass> p005FlowerStrongClasses, Response response) {
                                                                     //P005PicassoAndRetrofit.this
                ArrayAdapter arrayAdapter=new P005ArrayAdapterClass(getApplicationContext(),R.layout.p005picassoretrofitcustomrow,p005FlowerStrongClasses);
                setListAdapter(arrayAdapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Toast.makeText(P005PicassoAndRetrofit.this, "Failed",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private interface FlowersApiInterface{
        @GET("/feeds/flowers.json")
        public void getData(Callback<List<P005FlowerStrongClass>> resoponse);  //List<P005FlowerStrongClass> listpP005FlowerStrongClasses();  //arastir neden boyle dusundun
    }
    public static class P005FlowerStrongClass {
        private int productId;
        private String name;
        private String category;
        private String instructions;
        private double price;
        private String photo;
        private Bitmap bitmap;

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

        public double getPrice() {
            return price;
        }

        public String getPhoto() {
            return photo;
        }

        public Bitmap getBitmap() {
            return bitmap;
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

        public void setPrice(double price) {
            this.price = price;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public void setBitmap(Bitmap bitmap) {
            this.bitmap = bitmap;
        }
    }

}
