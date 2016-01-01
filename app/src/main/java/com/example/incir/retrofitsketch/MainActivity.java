package com.example.incir.retrofitsketch;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String activityNames[]= getResources().getStringArray(R.array.activity_names);

        ListView listView=(ListView)findViewById(R.id.listView);
        ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,activityNames);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        try {
            Class activityNameClass=Class.forName("com.example.incir.retrofitsketch."+parent.getItemAtPosition(position));
            Intent intent =new Intent(this,activityNameClass);
            startActivity(intent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
