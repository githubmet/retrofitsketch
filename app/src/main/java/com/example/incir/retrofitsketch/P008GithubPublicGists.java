package com.example.incir.retrofitsketch;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import retrofit.Callback;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;

import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class P008GithubPublicGists extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p008githubpublicgists);

        final ListView listViewPublicGistsP008=(ListView)findViewById(R.id.listViewPublicGistsP008);

        Endpoint endpoint=new Endpoint() {
            @Override
            public String getUrl() {
                return "https://api.github.com";
            }

            @Override
            public String getName() {
                return null;
            }
        };
        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint(endpoint.getUrl())
                .build();

        GithubGistsInterface service=restAdapter.create(GithubGistsInterface.class);
        service.getGithubGistsData(new Callback<List<GithubPublicGistsStrong>>() {
            @Override
            public void success(List<GithubPublicGistsStrong> githubPublicGistsStrongs, Response response) {

                ArrayAdapter arrayAdapter= new P008ArrayAdapterPublicGists(getApplicationContext(),R.layout.p008publicgistscustomrow,githubPublicGistsStrongs);
                listViewPublicGistsP008.setAdapter(arrayAdapter);
            }
            @Override
            public void failure(RetrofitError retrofitError) {
            }
        });

    }
    //verileri tutmak icin gecici cache bellek ortami yaratalim (bu bir class)
    public class GithubPublicGistsStrong{
        @SerializedName("id")
        private String MyId;
        @SerializedName("url")
        private String MyUrl;
        @SerializedName("files")
        private HashMap<String,filesStrong> MyHashMapFiles;
        public HashMap<String, filesStrong> getMyHashMapFiles() {
            return MyHashMapFiles;
        }

        public String getMyId() {
            return MyId;  //dikkat burada da siz developer lar bu veri ilede renk v.b. ile oynayabilmek istemelisiniz.
        }

        public String getMyUrl() {
            return MyUrl;
        }


    }
    public class filesStrong{
    private String filename;
    private String type;
    private String language;

    public String getFilename() {
        return filename;
    }
    public String getType() {
        return type;
    }
    public String getLanguage() {
        return language;
    }
}

    //gecici ve cache bellek ortami olan GithubPublicGistsStrong Class ina dokunmadan ulasabilmek icin bize bir KOPRU lazim (interface)
    public interface GithubGistsInterface{
        @GET("/gists/public")
        void getGithubGistsData(Callback<List<GithubPublicGistsStrong>> callback);  //bu kisim neden veri dondermez anlamadim.
    }
}

/*
@SerializedName("owner")
private Map<String, String> MyMapOwner;

    public GithubPublicGistsStrong() {
    }

    public Map<String, String> getMyMapOwner() {
        if(MyMapOwner.isEmpty()){
            MyMapOwner.put("id","Null");
            MyMapOwner.put("login","Null");
            MyMapOwner.put("avatar_url","https://avatars.githubusercontent.com/u/9884282?v=3");
        }
        return MyMapOwner;
    }
*/














































