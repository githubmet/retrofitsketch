package com.example.incir.retrofitsketch;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class P009UserInfo extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p009userinfo);

        ImageView imageViewInfoP009=(ImageView)findViewById(R.id.imageViewInfoP009);
        TextView textViewInfoId=(TextView)findViewById(R.id.textViewInfoId);

        Intent intent =getIntent();
        Bundle bundle= intent.getExtras();
        String katar= bundle.getString("InfoOfUser");

        String[] dizi=katar.split(" ");  //10 eleman
        Picasso.with(getApplicationContext())
                .load(dizi[2])  //"https://avatars.githubusercontent.com/u/1?v=3")
                .resize(400,400)
                .into(imageViewInfoP009);

        textViewInfoId.setText("Id="+dizi[0]+"\nLogin="+dizi[1]+"\nName="+dizi[3]+"\nEmail="+dizi[4]+"\nRepos="+dizi[5]+"\nGists="+dizi[6]+
                "\nFollowers="+dizi[7]+"\nFollowing="+dizi[8]+"\nDate="+dizi[9]);

    }
}
