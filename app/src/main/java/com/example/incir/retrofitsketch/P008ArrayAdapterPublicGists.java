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

        TextView textViewGistIdP008= (TextView)view.findViewById(R.id.textViewGistIdP008);
        TextView textViewGistUrlP008= (TextView)view.findViewById(R.id.textViewGistUrlP008);
        TextView textViewFilesP008= (TextView)view.findViewById(R.id.textViewFilesP008);

        P008GithubPublicGists.GithubPublicGistsStrong githubPublicGistsStrong= githubPublicGistsStrongList.get(position);
        textViewGistIdP008.setText("Id="+githubPublicGistsStrong.getMyId());
        textViewGistUrlP008.setText("Url="+githubPublicGistsStrong.getMyUrl());

        HashMap<String,P008GithubPublicGists.filesStrong> hashMapfilesStrong= githubPublicGistsStrong.getMyHashMapFiles();

        String katar="";
        for(P008GithubPublicGists.filesStrong gex : hashMapfilesStrong.values()){
            katar +="FileName="+ gex.filename+"\nType="+gex.type+"\nLanguage="+gex.language;
        }
        textViewFilesP008.setText(katar);

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






