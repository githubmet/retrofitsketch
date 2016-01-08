package com.example.incir.retrofitsketch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.squareup.picasso.Picasso;

public class P202ArrayAdapter extends ArrayAdapter<P202ApiStackDetails.P202ItemsStrong> {

    List<P202ApiStackDetails.P202ItemsStrong> p202ItemsStrongList;
    Context context;
    public P202ArrayAdapter(Context context, int resource,List<P202ApiStackDetails.P202ItemsStrong> p202ItemsStrongList) {
        super(context, resource,p202ItemsStrongList);
        this.p202ItemsStrongList=p202ItemsStrongList;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.p202customrow,parent,false);

        ImageView imageViewP202=(ImageView) view.findViewById(R.id.imageViewP202);
        TextView textViewP202=(TextView)view.findViewById(R.id.textViewP202);

        P202ApiStackDetails.P202ItemsStrong p202ItemsStrong= p202ItemsStrongList.get(position);

        String katar="DisplayName="+p202ItemsStrong.getDisplay_name()+"\nLocation="+p202ItemsStrong.getLocation()+"\nAge="+p202ItemsStrong.getAge();
        textViewP202.setText(katar);

        Picasso.with(context)
                .load(p202ItemsStrong.getProfile_image())
                .resize(100,100)
                .into(imageViewP202);
        return view;
    }
}
