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

public class P001RetrofitRestAdapterList extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001retrofitrestadapterlist);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        GithubService service=restAdapter.create(GithubService.class);

        ArrayAdapter<Object> listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        ListView listViewP126=(ListView)findViewById(R.id.listViewP001);
        listViewP126.setAdapter(listAdapter);

        listAdapter.addAll(service.getPublicGist());

    }
    public interface GithubService{
        @GET("/gists/public")  //url lin ednpoint ini belirtioyruz
        List<Gist> getPublicGist();
    }
    private class Gist{
        public String id;
        public HashMap<String, GistFile> files;  //eger files a baska bir isim vermek istiyor isen @serialzi.. attribute kullan

        @Override
        public String toString() {
            String output=id + ": ";
            for(Map.Entry<String,GistFile> file: files.entrySet()){        //buradaki key degeri JSON objelerinden biri olan "files" array objesinin icersindeki
                output +=file.getKey()+"="+file.getValue().type+", ";      //JSON arrayinin adidir(key), value degerleri icin alttaki sinif ile veri
            }                                                              //cache store alanlari olusturman gerekir.
            return output;
        }
    }
    private class GistFile{
        public String type;
    }
}


