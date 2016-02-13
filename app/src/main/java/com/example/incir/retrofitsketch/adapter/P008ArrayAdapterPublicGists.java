package com.example.incir.retrofitsketch.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.LayoutInflater;

import com.example.incir.retrofitsketch.R;
import com.example.incir.retrofitsketch.model.GithubGistsStrong;

import java.util.List;
import java.util.HashMap;

public class P008ArrayAdapterPublicGists extends ArrayAdapter<GithubGistsStrong>{

    List<GithubGistsStrong> githubGistsStrongList;
    Context context;
    public P008ArrayAdapterPublicGists(Context context, int resource,
                                       List<GithubGistsStrong> githubGistsStrongList) {
        super(context, resource,githubGistsStrongList);
        this.githubGistsStrongList=githubGistsStrongList;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.p008publicgistscustomrow,parent,false);

        TextView textViewGistIdP008= (TextView)view.findViewById(R.id.textViewGistIdP008);
        TextView textViewGistUrlP008=(TextView)view.findViewById(R.id.textViewGistUrlP008);
        TextView textViewFilesP008=(TextView)view.findViewById(R.id.textViewFilesP008);

        textViewGistIdP008.setText(githubGistsStrongList.get(position).getId());
        textViewGistUrlP008.setText(githubGistsStrongList.get(position).getUrl());

        HashMap<String ,GithubGistsStrong.filesDetails> hashMap=
                githubGistsStrongList.get(position).getFiles();

        StringBuilder sb=new StringBuilder();
        for(HashMap.Entry<String, GithubGistsStrong.filesDetails> gex:
                hashMap.entrySet()){
            sb.append("FileName="+gex.getValue().getFilename()+"\nLanguage="+
                    gex.getValue().getLanguage()+ "\nType="+gex.getValue().getType());
        }
        textViewFilesP008.setText(sb.toString());
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
            katar +="FileName="+ gex.getFilename()+"\nType="+gex.getType()+"\nLanguage="+gex.getLanguage();
        }
     */
/*   P008GithubPublicGists.filesStrong gex=(P008GithubPublicGists.filesStrong )hashMapfilesStrong.values();
        String katar="FileName="+ gex.getFilename()+"\nType="+gex.getType()+"\nLanguage="+gex.getLanguage();*//*
    //bu sekilde olmuyor.
        textViewFilesP008.setText(katar);

        return view;
    }
}







*/
