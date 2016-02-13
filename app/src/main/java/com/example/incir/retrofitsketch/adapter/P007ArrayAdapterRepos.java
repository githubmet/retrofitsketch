package com.example.incir.retrofitsketch.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.example.incir.retrofitsketch.R;
import com.example.incir.retrofitsketch.model.GithubUsersUserReposStrong;

import java.util.List;
import java.util.Map;

public class P007ArrayAdapterRepos extends ArrayAdapter<GithubUsersUserReposStrong>{
    List<GithubUsersUserReposStrong> githubUsersUserReposStrongList;
    Context context;
    public P007ArrayAdapterRepos(Context context, int resource,List<GithubUsersUserReposStrong>
                                 githubUsersUserReposStrongList) {

        super(context, resource,githubUsersUserReposStrongList);
        this.githubUsersUserReposStrongList=githubUsersUserReposStrongList;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.p007githubreposcustomrow,parent,false);
        //TextView textViewKatarP007=(TextView)view.findViewById(R.id.textViewKatarP007);
        TextView textViewDescriptionP007=(TextView)view.findViewById(R.id.textViewDescriptionP007);
       // ImageView imageViewCustomRowP007=(ImageView)view.findViewById(R.id.imageViewCustomRowP007);
/*

        StringBuilder sb=new StringBuilder();
        sb.append("Id="+githubUsersUserReposStrongList.get(position).getId()+"\n"+
                "FullName="+githubUsersUserReposStrongList.get(position).getFull_name()+"\n"+
                "Name="+githubUsersUserReposStrongList.get(position).getName()+"\n"+
                "FullName="+githubUsersUserReposStrongList.get(position)+"\n");*/
/*        for(Map.Entry<String,GithubUsersUserReposStrong.OwnerDetail> gex:
                githubUsersUserReposStrongList.get(position).getOwner().entrySet()){
            sb.append("Id2="+gex.getValue().getId()+"\nLogin="+gex.getValue().getLogin());
        }*/
        //textViewKatarP007.setText(sb.toString());

        String description=githubUsersUserReposStrongList.get(position).getDescription();
        textViewDescriptionP007.setText("denemeNNN");

        return view;
    }
}








/*

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import com.squareup.picasso.Picasso;

public class P007ArrayAdapterRepos extends ArrayAdapter<P007GithubUserRepos.GithubReposStrong> {

    List<P007GithubUserRepos.GithubReposStrong> githubReposStrongList;
    Context context;
    public P007ArrayAdapterRepos(Context context, int resource,List<P007GithubUserRepos.GithubReposStrong> githubReposStrongList) {
        super(context, resource,githubReposStrongList);
        this.githubReposStrongList=githubReposStrongList;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.p007githubreposcustomrow,parent,false);

        TextView textViewIdP007= (TextView)view.findViewById(R.id.textViewIdP007);
        TextView textViewNameP007= (TextView)view.findViewById(R.id.textViewNameP007);
        TextView textViewFullNameP007= (TextView)view.findViewById(R.id.textViewFullNameP007);
        TextView textViewDescriptionP007= (TextView)view.findViewById(R.id.textViewDescriptionP007);
        TextView textViewLoginP007= (TextView)view.findViewById(R.id.textViewLoginP007);
        TextView textViewLoginIdP007= (TextView)view.findViewById(R.id.textViewLoginIdP007);
        ImageView imageViewCustomRowP007=(ImageView)view.findViewById(R.id.imageViewCustomRowP007);

        P007GithubUserRepos.GithubReposStrong githubReposStrong= githubReposStrongList.get(position);
        textViewIdP007.setText("Repository Id="+githubReposStrong.getMyId());
        textViewNameP007.setText("Repository Name="+githubReposStrong.getMyName());
        textViewFullNameP007.setText(("FullName="+githubReposStrong.getMyFullName()));
        textViewDescriptionP007.setText(("Description=" + githubReposStrong.getMyDescription()));

        Map<String,String> mapGelen= githubReposStrong.getMapOwner();
        String userName= String.valueOf(mapGelen.get("login"));
        String userId=String.valueOf(mapGelen.get("id"));
        textViewLoginP007.setText("UserName="+userName);
        textViewLoginIdP007.setText("UserId="+userId);

        String userPhoto=String.valueOf(mapGelen.get("avatar_url"));
        Picasso.with(context)
                .load(userPhoto)
                .resize(300,300)
                .into(imageViewCustomRowP007);

        return view;
    }
}
*/
