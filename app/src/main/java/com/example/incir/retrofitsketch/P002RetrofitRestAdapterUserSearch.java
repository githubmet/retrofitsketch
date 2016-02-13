package com.example.incir.retrofitsketch;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.incir.retrofitsketch.backbone.AddMtdToAppCompatActivity;
import com.example.incir.retrofitsketch.model.GithubUserSearchStrong;
import com.example.incir.retrofitsketch.model.GithubUsersDetailsStrong;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class P002RetrofitRestAdapterUserSearch extends AddMtdToAppCompatActivity implements
View.OnClickListener,View.OnLongClickListener{

    GithubUserSearchStrong githubUserSearchStrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        TextView textView=new TextView(this);
        relativeLayout.addView(textView);
        setContentView(relativeLayout);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
        githubUserSearchStrong=
                getGithubNetwork().getGithubUserSearchStrong("mojombo");
        textView.setText(githubUserSearchStrong.toString());

        textView.setOnClickListener(this);
        textView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String userName=githubUserSearchStrong.items.get(0).getLogin();
        GithubUsersDetailsStrong githubUsersDetailsStrong= getGithubNetwork().
                getGithubUsersDetailsStrong(userName);
        String katar="onClick\nId="+githubUsersDetailsStrong.getId()+"\nlogin="+
                githubUsersDetailsStrong.getLogin()+"\n";
        Toast.makeText(P002RetrofitRestAdapterUserSearch.this,katar,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onLongClick(View v) {
        String userName=githubUserSearchStrong.items.get(0).getLogin();
        getGithubNetwork().getGithubUserDetailsStrongCallBack(userName, new Callback<GithubUsersDetailsStrong>() {
            @Override
            public void success(GithubUsersDetailsStrong githubUsersDetailsStrong, Response response) {
                String katar="OnLongClick\nlogin="+githubUsersDetailsStrong.getLogin()+"\nId="+githubUsersDetailsStrong.getId()+"\n";
                Toast.makeText(P002RetrofitRestAdapterUserSearch.this,katar,Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        return true;
    }
}