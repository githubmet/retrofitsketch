package com.example.incir.retrofitsketch;


import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import retrofit.RestAdapter;
import retrofit.Endpoint;
import retrofit.http.GET;

import android.os.StrictMode;

public class P200ApiStackexchange extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout relativeLayout=new RelativeLayout(this);
        TextView textView=new TextView(this);
        relativeLayout.addView(textView);
        setContentView(relativeLayout);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());  //bir sikilastirma ama neden bilmiyorum
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

        P200UsersInterface service= restAdapter.create(P200UsersInterface.class);
        P200UsersStrong p200UsersStrong= service.getUsersBase();
        textView.setText(p200UsersStrong.toString());

    }
    public interface P200UsersInterface{    //managing url calls
        @GET("/2.2/users?order=desc&sort=reputation&site=stackoverflow")
        P200UsersStrong getUsersBase();
    }

    public class P200UsersStrong{
        private String has_more;
        private String quota_max;

        @Override
        public String toString() {
            return "has_more=" + has_more +
                    "\nquota_max=" + quota_max;
        }
    }
}




















