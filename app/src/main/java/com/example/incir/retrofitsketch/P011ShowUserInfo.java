package com.example.incir.retrofitsketch;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.incir.retrofitsketch.backbone.AddMtdToAppCompatActivity;
import com.example.incir.retrofitsketch.model.GithubUserSearchStrong;
import com.squareup.picasso.Picasso;

import java.util.List;

public class P011ShowUserInfo extends AddMtdToAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p011showuserinfo);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
        ImageView imageViewShowUserP011= (ImageView)findViewById(R.id.imageViewShowUserP011);
        TextView textViewShowUserP011= (TextView)findViewById(R.id.textViewShowUserP011);
        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();
        String userName=bundle.getString("userName");

        GithubUserSearchStrong githubUserSearchStrong=getGithubNetwork().
                getGithubUserSearchStrong(userName);


        List<GithubUserSearchStrong.itemsDetails> userItemsClasses=
                githubUserSearchStrong.items;

        String katar= userItemsClasses.get(0).getId()+""+userItemsClasses.get(0).getLogin()+""+
                userItemsClasses.get(0).getAvatar_url()+""+userItemsClasses.get(0).getUrl()+""+ userItemsClasses.get(0).getHtml_url()+""+
                userItemsClasses.get(0).getFollowers_url()+""+userItemsClasses.get(0).getFollowing_url()+""+
                userItemsClasses.get(0).getGists_url()+""+ userItemsClasses.get(0).getStarred_url()+""+
                userItemsClasses.get(0).getSubscriptions_url()+""+ userItemsClasses.get(0).getOrganizations_url()+""+
                userItemsClasses.get(0).getRepos_url()+""+ userItemsClasses.get(0).getEvents_url()+""+
                userItemsClasses.get(0).getEvents_url()+""+ userItemsClasses.get(0).getReceived_events_url()+""+
                userItemsClasses.get(0).getType()+""+userItemsClasses.get(0).getSite_admin()+""+userItemsClasses.get(0).getScore();
        textViewShowUserP011.setText(katar);
        Picasso.with(getApplicationContext())
                .load(userItemsClasses.get(0).getAvatar_url())
                .resize(300,300)
                .into(imageViewShowUserP011);
    }
}
