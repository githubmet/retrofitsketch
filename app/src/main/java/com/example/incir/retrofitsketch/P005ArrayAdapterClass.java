package com.example.incir.retrofitsketch;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import android.view.LayoutInflater;

import java.util.List;
import java.util.ArrayList;
import com.squareup.picasso.Picasso;


public class P005ArrayAdapterClass extends ArrayAdapter<P005PicassoAndRetrofit.P005FlowerStrongClass> {

    String UrlPhoto="http://services.hanselandpetal.com/photos/";
    private Context context;
    private List<P005PicassoAndRetrofit.P005FlowerStrongClass> flowerList;
    public P005ArrayAdapterClass(Context context, int resource,List<P005PicassoAndRetrofit.P005FlowerStrongClass> flowerList) {
        super(context, resource,flowerList);
        this.context=context;
        this.flowerList=flowerList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //LayoutInflater layoutInflater=LayoutInflater.from(getContext()); //Eski yontem
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE); //THE NEW ONE
        View view= layoutInflater.inflate(R.layout.p005picassoretrofitcustomrow,parent,false);

         ImageView imageViewCustomRowP005=(ImageView)view.findViewById(R.id.imageViewCustomRowP005);
        TextView textViewCustomRowP005=(TextView)view.findViewById(R.id.textViewCustomRowP005);
        //textViewCustomRowP005.setTextColor(Color.BLACK);
        textViewCustomRowP005.setTypeface(null,Typeface.BOLD);
        P005PicassoAndRetrofit.P005FlowerStrongClass Flower= flowerList.get(position);
        Picasso.with(context)
                .load(UrlPhoto+Flower.getPhoto())
                .resize(300,300)
                .into(imageViewCustomRowP005);

        textViewCustomRowP005.setText("Id=" + Flower.getProductId() + "\nName=" + Flower.getName() + "\nCategory=" + Flower.getCategory() +
                "\nPrice=" + Flower.getPrice() + "\nInsturction=" + Flower.getInstructions()+"\nBitmap="+Flower.getBitmap());

        return view;
    }
}
