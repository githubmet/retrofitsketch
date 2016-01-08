package com.example.incir.retrofitsketch;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.Endpoint;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.StrictMode;

public class P202ApiStackDetails extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());  //bir sikilastirma ama neden bilmiyorum
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

        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint(endpoint.getUrl())
                .build();

        P202UsersInterface service=restAdapter.create(P202UsersInterface.class);
        service.getUsersAllInfo(new Callback<P202UsersStrong>() {
            @Override
            public void success(P202UsersStrong p202UsersStrong, Response response) {
                List<P202ItemsStrong> p202ItemsStrongList= p202UsersStrong.items;
                ArrayAdapter arrayAdapter =new P202ArrayAdapter(getApplicationContext(),R.layout.p202customrow,p202ItemsStrongList);

                setListAdapter(arrayAdapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });



    }
    public interface P202UsersInterface{    //managing url calls
        @GET("/2.2/users?order=desc&sort=reputation&site=stackoverflow")
        void getUsersAllInfo(Callback<P202UsersStrong> callback );
    }
                                     //interface ile baslayan url GET istegi  gelen JSON verinin dallanma tapisina gore asagida cash storge alanlari ile
                                     //karsilanir. MAntik bu.
    public class P202UsersStrong{    //dikkat bu cash storage alani sadece JSON object veri tutar.
        List<P202ItemsStrong> items;
    }
    public class P202ItemsStrong{    //bu cash storage alani ise sadece JSON array veri tutar.
        private String display_name;
        private String location;
        private String age;
        private String profile_image;

        public String getDisplay_name() {
            return display_name;
        }

        public String getLocation() {
            return location;
        }

        public String getAge() {
            return age;
        }

        public String getProfile_image() {
            return profile_image;
        }
    }
}
