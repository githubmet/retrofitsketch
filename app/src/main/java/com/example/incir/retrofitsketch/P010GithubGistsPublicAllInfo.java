package com.example.incir.retrofitsketch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import retrofit.Callback;
import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;

import java.util.HashMap;
import java.util.List;

public class P010GithubGistsPublicAllInfo extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p010githubgistspublicallinfo);

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

        P010GithubGistsInterface service=restAdapter.create(P010GithubGistsInterface.class);
        service.getGistsPublicData(new Callback<List<P010GithubGistsStrong>>() {
            @Override
            public void success(List<P010GithubGistsStrong> p010GithubGistsStrongs, Response response) {
                ListView listViewP010=(ListView)findViewById(R.id.listViewP010);
                ArrayAdapter arrayAdapter=new P010ArrayAdapterGithub(getApplicationContext(),R.layout.p010customrow,p010GithubGistsStrongs);
                listViewP010.setAdapter(arrayAdapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });

    }
    public interface P010GithubGistsInterface{
         @GET("/gists/public")
        void getGistsPublicData(Callback<List<P010GithubGistsStrong>> callback);
    }

    public class P010GithubGistsStrong{
        private String id;
        private HashMap<String,P010OwnerStrong> owner;

        public String getId() {
            return id;
        }

        public HashMap<String, P010OwnerStrong> getOwner() {
            return owner;
        }
    }
    public class P010OwnerStrong{
        private String login;
        private String avatar_url;

        public String getLogin() {
            return login;
        }
        public String getAvatar_url() {
            return avatar_url;
        }
    }
}
