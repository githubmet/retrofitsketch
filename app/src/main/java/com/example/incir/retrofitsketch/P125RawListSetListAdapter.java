package com.example.incir.retrofitsketch;


import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.http.GET;

public class P125RawListSetListAdapter extends Activity { //ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        relativeLayout.setBackgroundColor(Color.parseColor("#006699"));
        TextView textView= new TextView(this);
        relativeLayout.addView(textView);
        setContentView(relativeLayout);    //korkma sonradan da olsa degisiklikler kabul ediliyor

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
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
                .setEndpoint(endpoint.getUrl())
                .build();
        //bize cache olarak bir storage alani lazim
        UsersInterface service = restAdapter.create(UsersInterface.class);
        textView.setText(service.getUser().toString());  //ornek degisiklik


    }
    public interface UsersInterface{
        @GET("/users/mojombo")
        UsersStrong getUser();
    }
    public class UsersStrong{
        String login;
        String id;
        String avatar_url;
        String gravatar_id;
        String url;
        String html_url;
        String followers_url;
        String following_url;
        String gists_url;
        String starred_url;
        String  subscriptions_url;
        String  organizations_url;
        String  repos_url;
        String  events_url;
        String  received_events_url;
        String  type;
        String  site_admin;
        String  name;
        String  company;
        String  blog;
        String  location;
        String  email;
        String  hireable;
        String  bio;
        String  public_repos;
        String  public_gists;
        String  followers;
        String  following;
        String created_at;
        String  updated_at;

        @Override
        public String toString() {
            return
                    "login='" + login + '\'' +
                    ", \nid='" + id + '\'' +
                    ", \navatar_url='" + avatar_url + '\'' +
                    ", \ngravatar_id='" + gravatar_id + '\'' +
                    ", \nurl='" + url + '\'' +
                    ", \nhtml_url='" + html_url + '\'' +
                    ", \nfollowers_url='" + followers_url + '\'' +
                    ", \nfollowing_url='" + following_url + '\'' +
                    ", \ngists_url='" + gists_url + '\'' +
                    ", \nstarred_url='" + starred_url + '\'' +
                    ", \nsubscriptions_url='" + subscriptions_url + '\'' +
                    ", \norganizations_url='" + organizations_url + '\'' +
                    ", \nrepos_url='" + repos_url + '\'' +
                    ", \nevents_url='" + events_url + '\'' +
                    ", \nreceived_events_url='" + received_events_url + '\'' +
                    ", \ntype='" + type + '\'' +
                    ", \nsite_admin='" + site_admin + '\'' +
                    ", \nname='" + name + '\'' +
                    ", \ncompany='" + company + '\'' +
                    ", \nblog='" + blog + '\'' +
                    ", \nlocation='" + location + '\'' +
                    ", \nemail='" + email + '\'' +
                    ", \nhireable='" + hireable + '\'' +
                    ", \nbio='" + bio + '\'' +
                    ", \npublic_repos='" + public_repos + '\'' +
                    ", \npublic_gists='" + public_gists + '\'' +
                    ", \nfollowers='" + followers + '\'' +
                    ", \nfollowing='" + following + '\'' +
                    ", \ncreated_at='" + created_at + '\'' +
                    ", \nupdated_at='" + updated_at + '\'' +
                    '}';
        }
    }
}


























