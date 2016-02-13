package com.example.incir.retrofitsketch;


import android.os.Bundle;
import android.os.StrictMode;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.incir.retrofitsketch.backbone.AddMtdToAppCompatActivity;
import com.example.incir.retrofitsketch.model.StackexchangeQuatoRemainigStrong;

public class P012StackexchageQuato extends AddMtdToAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        TextView textView=new TextView(this);
        relativeLayout.addView(textView);
        setContentView(relativeLayout);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());  //bir sikilastirma ama neden bilmiyorum

        StackexchangeQuatoRemainigStrong stackexchangeQuatoRemainigStrong=
                getStackexchangeNetwork().getStackexchageQuotaInfo();

        textView.setText(stackexchangeQuatoRemainigStrong.toString());

    }
}
