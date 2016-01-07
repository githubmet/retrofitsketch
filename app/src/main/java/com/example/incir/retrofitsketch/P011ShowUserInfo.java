package com.example.incir.retrofitsketch;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.StringBuilder;

public class P011ShowUserInfo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p011showuserinfo);

        ImageView imageViewShowUserP011= (ImageView)findViewById(R.id.imageViewShowUserP011);
        TextView textViewShowUserP011= (TextView)findViewById(R.id.textViewShowUserP011);

        Intent intent =getIntent();
        Bundle bundle= intent.getExtras();
        String[] katarDizi= bundle.getStringArray("katar");
        Picasso.with(getApplicationContext())
                .load(katarDizi[2])
                .resize(100,100)
                .into(imageViewShowUserP011);

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<katarDizi.length;i++){
            if(i==2){
                continue;
            }
            sb.append(katarDizi[i]+"\n");
        }
        textViewShowUserP011.setText(sb.toString());
    }
}
