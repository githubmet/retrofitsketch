package com.example.incir.retrofitsketch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class P124MapExample extends Activity {
    TextView textViewP124;
    TextView textView2P124;
    TextView textView3P124;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p124mapexample);

        textViewP124=(TextView)findViewById(R.id.textViewP124);
        textView2P124=(TextView)findViewById(R.id.textView2P124);
        textView3P124=(TextView)findViewById(R.id.textView3P124);
    }

    public void onClickP124(View view) {

        //Map map=new HashMap();  //+
        HashMap map=new HashMap();  //+
        map.put("key","value");
        map.put("key2", "value2");
        map.put("key3", "value3");


       //String veri= (String) map.get("key");
       //textViewP124.setText("veri="+veri);  //veri=value

        StringBuilder sb=new StringBuilder();

        for(Object key:map.keySet()){
            sb.append(map.get(key)+" ");  //value3 value2 value  //neden tersten siralar
        }
        textViewP124.setText(sb);
    }

    public void onClick2P124(View view){

        Map<String, EmployeeP124> mapClass=new HashMap<String ,EmployeeP124>();
        mapClass.put("key",new EmployeeP124("id","name"));
        mapClass.put("key2",new EmployeeP124("id2","name2"));
        mapClass.put("key3",new EmployeeP124("id3","name3"));

        //EmployeeP124 emp=mapClass.get("key");
        //textView2P124.setText("id="+emp.id+" name="+emp.name);  //id=id name=name
        //--
        //String katar="";
        //for(Object gex : mapClass.keySet()){                    //Id=id3 Name=name3
            //EmployeeP124 empX= mapClass.get(gex);               //Id=id2 Name=name2
            //katar +="Id=" + empX.id+ " Name="+empX.name+"\n";   //Id=id Name=name
        //}
        //textView2P124.setText(katar);
        //--
        String katar="";
        for(Object gex: mapClass.values()){    //bir ustteki sonuc ile ayni sonuc
            EmployeeP124 emp=(EmployeeP124)gex;
            katar +="Id="+emp.id+" Name="+emp.name+"\n";
        }
        textView2P124.setText(katar);
    }
    public  class EmployeeP124{
        String id;
        String name;

        public EmployeeP124(String id, String name) {
            this.id = id;
            this.name = name;
        }
    }
    public void onClick3P124(View view){

        HashMap hasMap=new HashMap();
        hasMap.put("key","value");
        hasMap.put("key2", "value2");
        hasMap.put("key3","value3");

        Set set= hasMap.entrySet();
        //textView3P124.setText("Set="+set);  //Set=[key3=value3, key2=value2, key=value]

        Object[] objectArray=set.toArray();
        String katar="FirstRow="+objectArray[0]+     //FirstRow=key3=value3
                "\nSecondRow="+objectArray[1]+       //SecondRow=key2=value2
                "\nThirdRow="+objectArray[2];        //ThirdRow=key=value

        textView3P124.setText(katar);
    }
}


//--
//for(Map gex : map.keySet()){
//sb.append(gex.get()) //bu sekilde her bir deger icin key belirtmen gerekir
//}