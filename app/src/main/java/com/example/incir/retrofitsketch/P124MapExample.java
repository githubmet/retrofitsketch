package com.example.incir.retrofitsketch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P124MapExample extends Activity {
    TextView textViewP124;
    TextView textView2P124;
    TextView textView3P124;
    TextView textView4P124;
    TextView textView5P124;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p124mapexample);

        textViewP124=(TextView)findViewById(R.id.textViewP124);
        textView2P124=(TextView)findViewById(R.id.textView2P124);
        textView3P124=(TextView)findViewById(R.id.textView3P124);
        textView4P124=(TextView)findViewById(R.id.textView4P124);
        textView5P124=(TextView)findViewById(R.id.textView5P124);
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
    public void onClick4P124(View view){
/*
        List listSade=new ArrayList();
        listSade.add("Picasso");
        listSade.add("Retrofit");
        listSade.add("JSON");
        listSade.add("Api");

        String katar="";
        for(int i=0;i<listSade.size();i++){
            katar +=listSade.get(i)+" ";   //.toString() ve implicit birlestirme yapmasan da sorun yok ! belkide bastaki "" densebep sorun yok.
        }
*/
        List<String> genericList=new ArrayList<String>();
        genericList.add("Picasso");
        genericList.add("Retrofit");
        genericList.add("JSON");
        genericList.add("Api");

        String katar="";
        for(int i=0;i<genericList.size();i++){
            katar +=genericList.get(i)+" ";
        }
        textView4P124.setText(katar);

        //iterator denemedik
        //List<> bu zimbirtinin adi Generic Lists
    }
    public void onClick5P124(View view){

        Field[] field=MemberForAClass.class.getDeclaredFields();
        textView5P124.setText((String.valueOf(field.length)));  //sadece asagidaki private elemanlarin 1 eksigi olarak cikarim yaptik
    //sonuc 2
    }
    public class MemberForAClass{
        private String Id;
        private String Name;
        private String Surname;

        public String getSurname() {
            return Surname;
        }

        public String getId() {
            return Id;
        }

        public String getName() {
            return Name;
        }
    }

}


//--
//for(Map gex : map.keySet()){
//sb.append(gex.get()) //bu sekilde her bir deger icin key belirtmen gerekir
//}




















