package com.example.incir.retrofitsketch.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;  //hey, android. Are you realize why I act this way. Just do it:)
import android.widget.TextView;

import com.example.incir.retrofitsketch.R;
import com.example.incir.retrofitsketch.model.GithubPublicGistsStrong;

import java.util.List;

public class P006GithubArrayAdapter extends ArrayAdapter<GithubPublicGistsStrong>{

    Context context;
    List<GithubPublicGistsStrong> githubPublicGistsStrongList;
    public P006GithubArrayAdapter(Context context, int resource,List<GithubPublicGistsStrong> githubPublicGistsStrongList) {
        super(context, resource,githubPublicGistsStrongList);
        this.context=context;
        this.githubPublicGistsStrongList=githubPublicGistsStrongList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.p006githubcustomrow,parent,false);
        TextView textViewCustomRowIdP006=(TextView)view.findViewById(R.id.textViewCustomRowIdP006);
        TextView textViewCustomRowDescriptionP006=(TextView)view.findViewById(R.id.textViewCustomRowDescriptionP006);

        String id=githubPublicGistsStrongList.get(position).getId();
        String description=githubPublicGistsStrongList.get(position).getDescription();
        textViewCustomRowIdP006.setText(id);
        textViewCustomRowDescriptionP006.setText(description);

        return view;
    }
}
