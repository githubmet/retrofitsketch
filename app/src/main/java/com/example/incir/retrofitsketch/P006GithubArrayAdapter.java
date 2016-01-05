package com.example.incir.retrofitsketch;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class P006GithubArrayAdapter extends ArrayAdapter<P006GithubRetrofitSade.GithubStronglyClass> {

    Context context;
    public List<P006GithubRetrofitSade.GithubStronglyClass> githubStronglyClassList;
    public P006GithubArrayAdapter(Context context, int resource,List<P006GithubRetrofitSade.GithubStronglyClass> githubStronglyClassList ) {
        super(context, resource,githubStronglyClassList);
        this.context=context;
        this.githubStronglyClassList=githubStronglyClassList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.p006githubcustomrow, parent, false);

        P006GithubRetrofitSade.GithubStronglyClass githubItem=githubStronglyClassList.get(position);

        TextView textViewCustomRowP006=(TextView)view.findViewById(R.id.textViewCustomRowP006);
        textViewCustomRowP006.setText("Id="+githubItem.getMyId());
        TextView textViewCustomRow2P006=(TextView)view.findViewById(R.id.textViewCustomRow2P006);
        textViewCustomRow2P006.setText("Descrition= "+githubItem.getMyDescription());

        return view;
    }
}
