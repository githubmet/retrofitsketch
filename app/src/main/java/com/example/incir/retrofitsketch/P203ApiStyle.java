package com.example.incir.retrofitsketch;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.Endpoint;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;

import java.util.List;
import java.util.Map;

public class P203ApiStyle extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Endpoint endpoint=new Endpoint() {
            @Override
            public String getUrl() {
                return "https://api.stackexchange.com";
            }

            @Override
            public String getName() {
                return null;
            }
        };
        RestAdapter restAdapter=new RestAdapter.Builder().setEndpoint(endpoint.getUrl()).build();  //ev hatti tamam
        P203SitesInterface service=restAdapter.create(P203SitesInterface.class);
        service.getItems(new Callback<P203Items>() {
            @Override
            public void success(P203Items p203Items, Response response) {
                List<P203ItemsObjects> p203ItemsObjectsList= p203Items.items;
                ArrayAdapter arrayAdapter=new P203ArrayAdapter(getApplicationContext(),R.layout.p203customrow,p203ItemsObjectsList);
                setListAdapter(arrayAdapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });

    }
    public interface P203SitesInterface{
        @GET("/2.2/sites" )  //manipulate the url
        void getItems(Callback<P203Items> callback);     //P203Items getItems();  //Callback ile yapmaliyiz
    }

    public class P203Items{
        public List<P203ItemsObjects> items;
    }
    public class P203ItemsObjects{
        private String name;
        private String site_url;
        private String icon_url;

        private Map<String,String> styling;

        public Map<String, String> getStyling() {
            return styling;
        }

        public String getName() {
            return name;
        }

        public String getSite_url() {
            return site_url;
        }

        public String getIcon_url() {
            return icon_url;
        }
    }
}















