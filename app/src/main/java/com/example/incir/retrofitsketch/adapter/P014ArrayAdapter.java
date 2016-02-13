package com.example.incir.retrofitsketch.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.List;
import com.example.incir.retrofitsketch.model.StackexchangeSitesStrong;
import com.example.incir.retrofitsketch.R;

import com.squareup.picasso.Picasso;

public class P014ArrayAdapter extends ArrayAdapter<StackexchangeSitesStrong.itemsDetails>{
    List<StackexchangeSitesStrong.itemsDetails> itemsDetailsList;
    Context context;
    public P014ArrayAdapter(Context context, int resource,
                            List<StackexchangeSitesStrong.itemsDetails> itemsDetailsList) {
        super(context, resource,itemsDetailsList);
        this.itemsDetailsList=itemsDetailsList;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.p014customrow,parent,false);
        TextView textViewKatarP014=(TextView)view.findViewById(R.id.textViewKatarP014);
        ImageView imageViewP014=(ImageView)view.findViewById(R.id.imageViewP014);

        StringBuilder sb=new StringBuilder();
        sb.append("name=" + itemsDetailsList.get(position).getName() +
                "\nurl=" + itemsDetailsList.get(position).getSite_url() +
                "\nbackgroundColor=" + itemsDetailsList.get(position).getStyling()
                .get(position).getTag_background_color() +
                "\nforegroundColor=" + itemsDetailsList.get(position).getStyling()
                .get(position).getTag_foreground_color());
        textViewKatarP014.setText(sb.toString());

        Picasso.with(context)
                .load(itemsDetailsList.get(position).getIcon_url())
                .resize(100,100)
                .into(imageViewP014);

        return view;
    }
}
