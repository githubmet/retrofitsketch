package com.example.incir.retrofitsketch.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.List;

import com.example.incir.retrofitsketch.R;
import com.example.incir.retrofitsketch.model.StackexchangeQuatoRemainigStrong;

import com.squareup.picasso.Picasso;

public class P013ArrayAdapter extends ArrayAdapter<StackexchangeQuatoRemainigStrong.itemsDetail>  {
    List<StackexchangeQuatoRemainigStrong.itemsDetail> itemsDetailList;
    Context context;
    public P013ArrayAdapter (Context context, int resource,
                             List<StackexchangeQuatoRemainigStrong.itemsDetail> itemsDetailList) {
        super(context, resource,itemsDetailList);
        this.itemsDetailList=itemsDetailList;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.p013customrow,parent,false);
        TextView textViewP013=(TextView)view.findViewById(R.id.textViewP013);
        ImageView imageViewP013=(ImageView)view.findViewById(R.id.imageViewP013);

        String katar= "DisplayName="+itemsDetailList.get(position).getDisplay_name()+
                "\nAge="+ itemsDetailList.get(position).getAge()+
                "\nLocation="+ itemsDetailList.get(position).getLocation();
        textViewP013.setText(katar);

        Picasso.with(context)
                .load(itemsDetailList.get(position).getProfile_image())
                .resize(100,100)
                .into(imageViewP013);
        return view;
    }
}
