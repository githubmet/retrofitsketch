package com.example.incir.retrofitsketch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.squareup.picasso.Picasso;

public class P008ArrayAdapterPublicGists extends ArrayAdapter<P008GithubPublicGists.GithubPublicGistsStrong> {

    public List<P008GithubPublicGists.GithubPublicGistsStrong> githubPublicGistsStrongList;
    Context context;
    public P008ArrayAdapterPublicGists(Context context, int resource,List<P008GithubPublicGists.GithubPublicGistsStrong> githubPublicGistsStrongList ) {
        super(context, resource,githubPublicGistsStrongList);
        this.githubPublicGistsStrongList=githubPublicGistsStrongList;
        this.context=context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.p008publicgistscustomrow,parent,false);

        ImageView imageViewGistsCustomRowP008= (ImageView)view.findViewById(R.id.imageViewGistsCustomRowP008);
        TextView textViewGistIdP008= (TextView)view.findViewById(R.id.textViewGistIdP008);
        TextView textViewGistUrlP008= (TextView)view.findViewById(R.id.textViewGistUrlP008);
        TextView textViewOwnerIdP008= (TextView)view.findViewById(R.id.textViewOwnerIdP008);
        TextView textViewOwnerLoginP008= (TextView)view.findViewById(R.id.textViewOwnerLoginP008);

        P008GithubPublicGists.GithubPublicGistsStrong githubPublicGistsStrong= githubPublicGistsStrongList.get(position);
        textViewGistIdP008.setText(githubPublicGistsStrong.getMyId());
        textViewGistUrlP008.setText(githubPublicGistsStrong.getMyUrl());

        HashMap<String,String> haspMapOwner= githubPublicGistsStrong.getMyHashMapOwner();

            String ownerId = String.valueOf(haspMapOwner.get("id"));
            String ownerLogin = String.valueOf(haspMapOwner.get("login"));
            textViewOwnerIdP008.setText(ownerId);
            textViewOwnerLoginP008.setText(ownerLogin);
        
        return view;
    }
}

/*
Map<String,String> mapGithubGistOwner= githubPublicGistsStrong.getMyMapOwner();
String loginId=String.valueOf(mapGithubGistOwner.get("id"));
String login=String.valueOf(mapGithubGistOwner.get("login"));
textViewOwnerIdP008.setText(loginId);
textViewOwnerLoginP008.setText(login);

String imageUrl=String.valueOf(mapGithubGistOwner.get("avatar_url"));
Picasso.with(context)
.load(imageUrl)
.resize(300, 300)
.into(imageViewGistsCustomRowP008);
*/






