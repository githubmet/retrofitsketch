package com.example.incir.retrofitsketch.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.incir.retrofitsketch.R;
import com.example.incir.retrofitsketch.model.HanselandpetalStrong;

import java.util.List;

import com.squareup.picasso.Picasso;

public class P005ArrayAdapterClass extends ArrayAdapter<HanselandpetalStrong>{
    Context context;
    List<HanselandpetalStrong> hanselandpetalStrongList;
    String photoUrl="http://services.hanselandpetal.com/photos/";
    public P005ArrayAdapterClass(Context context, int resource,
                                 List<HanselandpetalStrong> hanselandpetalStrongList) {
        super(context, resource,hanselandpetalStrongList);
        this.hanselandpetalStrongList=hanselandpetalStrongList;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.p005picassoretrofitcustomrow,parent,false);

        TextView textViewCustomRowP005=(TextView)view.findViewById(R.id.textViewCustomRowP005);
        String veri=hanselandpetalStrongList.get(position).toString();
        textViewCustomRowP005.setText(veri);

        ImageView imageViewCustomRowP005=(ImageView)view.findViewById(R.id.imageViewCustomRowP005);

        Picasso.Builder builder=new Picasso.Builder(context);
        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                //Say something
                    }
                }).build()
                .load(photoUrl+hanselandpetalStrongList.get(position).getPhoto())
                .resize(300,300)
                .into(imageViewCustomRowP005);
        return view;
    }
}
