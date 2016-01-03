package com.example.incir.retrofitsketch;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import com.squareup.picasso.Picasso;

public class P123ArrayAdapter extends ArrayAdapter<P123FlowersStronglyType> {
    public Context context;
    public List<P123FlowersStronglyType>  flowersList;
    public P123ArrayAdapter(Context context, int resource,List<P123FlowersStronglyType> objects) {
        super(context, resource,objects);
        this.context=context;
        this.flowersList=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //LayoutInflater layoutInflater=LayoutInflater.from(context);
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE); //THE NEW ONE
        View view=layoutInflater.inflate(R.layout.p123customrow, parent, false);
        final ImageView imageViewCustomRowP123=(ImageView)view.findViewById(R.id.imageViewCustomRowP123);
        TextView textViewCustomRowP123=(TextView)view.findViewById(R.id.textViewCustomRowP123);
        textViewCustomRowP123.setTypeface(null, Typeface.BOLD);

        P123FlowersStronglyType flower= flowersList.get(position);
        textViewCustomRowP123.setText("Id=" + flower.getProductId() + "\nName=" + flower.getName() +
                "\nCategory=" + flower.getCategory() + "\nPrice=" + flower.getPrice() + "\nInstructions=" + flower.getInstructions());
        textViewCustomRowP123.setTypeface(null, Typeface.ITALIC);
        textViewCustomRowP123.setTextColor(Color.parseColor("#006699"));

        Picasso.Builder builder=new Picasso.Builder(context);  //asagidaki ile bir farki yok gibi
        builder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception e) {
            }
        }).build()
                .load("http://services.hanselandpetal.com/photos/"+flower.getPhoto())
                .resize(300,300)
                .into(imageViewCustomRowP123);
        return view;
    }
}

/*
Picasso.with(context)
.load("http://services.hanselandpetal.com/photos/"+flower.getPhoto())
.resize(200,300)
.into(imageViewCustomRowP123);
*/




