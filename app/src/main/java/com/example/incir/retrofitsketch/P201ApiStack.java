package com.example.incir.retrofitsketch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.Endpoint;
import retrofit.http.GET;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.StrictMode;

public class P201ApiStack extends Activity {
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

        P201UsersInterface service=restAdapter.create(P201UsersInterface.class);
        P201UsersStrong p201UsersStrong= service.getUsersInfo();
        List<P201ItemsStrong> p201ItemsStrongList= p201UsersStrong.items;

        StringBuilder sb= new StringBuilder();
        for(int i=0;i<p201ItemsStrongList.size();i++){
            sb.append("Location="+p201ItemsStrongList.get(i).getLocation()+"\nWebsiteUrl="+p201ItemsStrongList.get(i).getWebsite_url()+"\n\n");
        }
        textView.setText(sb.toString());

    }
    public interface P201UsersInterface{    //managing url calls
        @GET("/2.2/users?order=desc&sort=reputation&site=stackoverflow")
        P201UsersStrong getUsersInfo();
    }

    public class P201UsersStrong{
        List<P201ItemsStrong> items;
    }
    public class P201ItemsStrong{
        private String location;
        private String website_url;

        public String getLocation() {
            return location;
        }

        public String getWebsite_url() {
            return website_url;
        }
    }
}
