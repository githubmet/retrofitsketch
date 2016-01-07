package com.example.incir.retrofitsketch;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.RestAdapter;
import retrofit.http.GET;
import android.app.ListActivity;

public class P001RetrofitRestAdapterList extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());  //bunun ne ise yaradigini bilmiyorum
        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        GithubService service=restAdapter.create(GithubService.class);
        ArrayAdapter listAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        listAdapter.addAll(service.getPublicGist());
        setListAdapter(listAdapter);  //extends Activity ile dolanma.

    }
    public interface GithubService{
        @GET("/gists/public")  //url lin ednpoint ini belirtioyruz
        List<Gist> getPublicGist();  //Callback kullanmamizin tek nedeni elde edilen verileri islemeyecegiz .toString() ile raw olarak yazdiriyoruz.
    }
    private class Gist{
        public String id;
        public HashMap<String, GistFile> files;  //eger files a baska bir isim vermek istiyor isen @serialzi.. attribute kullan

        @Override
        public String toString() {
            String output="Id="+id + "\n";
            for(Map.Entry<String,GistFile> file: files.entrySet()){           //buradaki key degeri JSON objelerinden biri olan "files" array objesinin icersindeki
                output +="Key="+file.getKey()+" Value="+file.getValue().type; //JSON arrayinin adidir(key), value degerleri icin alttaki sinif ile veri
            }                                                                 //cache store alanlari olusturman gerekir.
            return output;
        }
    }
    private class GistFile{
        public String type;
    }
}


