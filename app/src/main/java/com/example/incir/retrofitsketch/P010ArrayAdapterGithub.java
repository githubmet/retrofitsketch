package com.example.incir.retrofitsketch;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.HashMap;

public class P010ArrayAdapterGithub extends ArrayAdapter<P010GithubGistsPublicAllInfo.P010GithubGistsStrong> {

    Context context;
    List<P010GithubGistsPublicAllInfo.P010GithubGistsStrong> p010GithubGistsStrongList;
    public P010ArrayAdapterGithub(Context context, int resource,List<P010GithubGistsPublicAllInfo.P010GithubGistsStrong> p010GithubGistsStrongList) {
        super(context, resource,p010GithubGistsStrongList);
        this.context=context;
        this.p010GithubGistsStrongList=p010GithubGistsStrongList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.p010customrow,parent,false);

        ImageView imageViewP010= (ImageView)view.findViewById(R.id.imageViewP010);
        TextView  textViewIdP010=(TextView)view.findViewById(R.id.textViewIdP010);
        TextView  textViewLoginP010=(TextView)view.findViewById(R.id.textViewLoginP010);

        P010GithubGistsPublicAllInfo.P010GithubGistsStrong p010GithubGistsStrong= p010GithubGistsStrongList.get(position);
        textViewIdP010.setText("Id=" + p010GithubGistsStrong.getId());

       /* HashMap<String,P010GithubGistsPublicAllInfo.P010OwnerStrong> hashMapOwner= p010GithubGistsStrong.getOwner();
        String veri="";
        for(P010GithubGistsPublicAllInfo.P010OwnerStrong gex :  hashMapOwner.values()){
            veri +=gex.getLogin();
        }
        textViewLoginP010.setText(veri);*/
        return view;
    }
}
