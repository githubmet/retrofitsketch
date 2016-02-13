package com.example.incir.retrofitsketch;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.LayoutInflater;

import com.example.incir.retrofitsketch.model.GithubGistsStrong;
import com.example.incir.retrofitsketch.model.GithubUsersStrong;

import java.util.List;

import com.squareup.picasso.Picasso;

public class P009ArrayAdapterUsersP009 extends ArrayAdapter<GithubUsersStrong>{
    List<GithubUsersStrong> githubUsersStrongList;
    Context context;
    public P009ArrayAdapterUsersP009(Context context, int resource,
                                     List<GithubUsersStrong> githubUsersStrongList) {
        super(context, resource);
        this.githubUsersStrongList=githubUsersStrongList;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.p009githubuserscustomrow,
               parent, false);

        TextView textViewKatarP009=(TextView)view.findViewById(R.id.textViewKatarP009);
        ImageView imageViewUsersP009=(ImageView)view.findViewById(R.id.imageViewUsersP009);

        String katar="Id="+githubUsersStrongList.get(position).getId()+
                "\nLogin="+githubUsersStrongList.get(position).getLogin()+
                "\nUrl="+githubUsersStrongList.get(position).getUrl();
                textViewKatarP009.setText(katar);

        Picasso.Builder builder=new Picasso.Builder(context);
        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {

            }
        }).build()
                .load(githubUsersStrongList.get(position).getAvatar_url())
                .resize(150,150)
                .into(imageViewUsersP009);
        return view;
    }
}








/*

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.squareup.picasso.Picasso;

public class P009ArrayAdapterUsersP009 extends ArrayAdapter<P009GithubUsers.GithubUsersStrongP009> {

    public List<P009GithubUsers.GithubUsersStrongP009> githubUsersStrongP009List;
    Context context;
    public P009ArrayAdapterUsersP009(Context context, int resource,List<P009GithubUsers.GithubUsersStrongP009> githubUsersStrongP009List) {
        super(context, resource,githubUsersStrongP009List);
        this.githubUsersStrongP009List=githubUsersStrongP009List;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.p009githubuserscustomrow,parent,false);

        ImageView imageViewUsersP009=(ImageView)view.findViewById(R.id.imageViewUsersP009);
        TextView textViewIdP009=(TextView)view.findViewById(R.id.textViewIdP009);
        TextView textViewLoginP009=(TextView)view.findViewById(R.id.textViewLoginP009);
        TextView textViewUrlP009=(TextView)view.findViewById(R.id.textViewUrlP009);

        P009GithubUsers.GithubUsersStrongP009 githubUsersStrongP009= githubUsersStrongP009List.get(position);
        textViewIdP009.setText("Id="+githubUsersStrongP009.getId());
        textViewLoginP009.setText("Login="+githubUsersStrongP009.getLogin());
        textViewUrlP009.setText("Url="+githubUsersStrongP009.getUrl());

        Picasso.with(context)
                .load(githubUsersStrongP009.getAvatar_url())
                .resize(150,150)
                .into(imageViewUsersP009);
        return view;
    }
}

*/
