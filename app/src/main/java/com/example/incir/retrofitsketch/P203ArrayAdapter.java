package com.example.incir.retrofitsketch;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Map;

public class P203ArrayAdapter extends ArrayAdapter<P203ApiStyle.P203ItemsObjects> {
    Context context;
    List<P203ApiStyle.P203ItemsObjects> p203ItemsObjectsList;
    public P203ArrayAdapter(Context context, int resource,List<P203ApiStyle.P203ItemsObjects> p203ItemsObjectsList) {
        super(context, resource,p203ItemsObjectsList);
        this.context=context;
        this.p203ItemsObjectsList=p203ItemsObjectsList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //ilgili Activity nin service lerinden yardim
       //talep ediyoruz.
        View view=layoutInflater.inflate(R.layout.p203customrow,parent,false);   //sisir
        ImageView imageViewP203= (ImageView)view.findViewById(R.id.imageViewP203);
        TextView textViewNameP203= (TextView)view.findViewById(R.id.textViewNameP203);
        TextView textViewSiteUrlP203= (TextView)view.findViewById(R.id.textViewSiteUrlP203);

        P203ApiStyle.P203ItemsObjects p203ItemsObjects= p203ItemsObjectsList.get(position);
        Map<String,String> mapStyle=p203ItemsObjects.getStyling();
        String backgroundColor= mapStyle.get("tag_background_color");
        String foregroundColor= mapStyle.get("tag_foreground_color");

        textViewNameP203.setText("Name="+p203ItemsObjects.getName()+" BackgroundColor="+backgroundColor);  //one result--> Name=Webmasters BacgroundColor=#FFF
        textViewSiteUrlP203.setText("SiteUrl=" + p203ItemsObjects.getSite_url() + " BackgroundColor=" + foregroundColor); //one result-->SiteUrl=The url BackgoundColor=#1B8FBB
        //if statement for some websafe color to change it hex color exp #FFF --> #FFFFFF
        if(backgroundColor.length()==4){
            char harf= backgroundColor.charAt(1);
            String suffix=String.valueOf(harf)+String.valueOf(harf)+String.valueOf(harf);
            backgroundColor=backgroundColor.concat(suffix);
        }
        if(foregroundColor.length()==4){
            char harf= foregroundColor.charAt(1);
            String suffix=String.valueOf(harf)+String.valueOf(harf)+String.valueOf(harf);
            foregroundColor=foregroundColor.concat(suffix);
        }
        textViewNameP203.setBackgroundColor(Color.parseColor(backgroundColor));
        textViewSiteUrlP203.setBackgroundColor(Color.parseColor(foregroundColor));

        Picasso.with(context).load(p203ItemsObjects.getIcon_url()).resize(100, 100).into(imageViewP203);
        return view;
    }
}
