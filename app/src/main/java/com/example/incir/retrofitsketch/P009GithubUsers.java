package com.example.incir.retrofitsketch;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import com.example.incir.retrofitsketch.backbone.AddMtdToAppCompatActivity;
import com.example.incir.retrofitsketch.model.GithubUsersStrong;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class P009GithubUsers extends AddMtdToAppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p009githubusers);

        final ListView listViewUsersP009=(ListView)findViewById(R.id.listViewUsersP009);

        getGithubNetwork().getGithubUsersStrongCallBackList(new Callback<List<GithubUsersStrong>>() {
            @Override
            public void success(List<GithubUsersStrong> githubUsersStrongs, Response response) {
                ArrayAdapter arrayAdapter=new P009ArrayAdapterUsersP009(getApplicationContext(),
                        R.layout.p009githubuserscustomrow,githubUsersStrongs);
                listViewUsersP009.setAdapter(arrayAdapter);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }
}



/*

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.Endpoint;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;

import android.os.Parcelable;

public class P009GithubUsers extends Activity implements AdapterView.OnItemClickListener{
    public Endpoint endpoint;
    public String login="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p009githubusers);
        final ListView listViewUsersP009=(ListView)findViewById(R.id.listViewUsersP009);

        endpoint=new Endpoint() {
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
                .setEndpoint(endpoint)
                .build();

        GithubUsersInterfaceP009 service=restAdapter.create(GithubUsersInterfaceP009.class);
        service.getUsersData(new Callback<List<GithubUsersStrongP009>>() {
            @Override
            public void success(List<GithubUsersStrongP009> githubUsersStrongP009s, Response response) {

                ArrayAdapter arrayAdapter=new P009ArrayAdapterUsersP009(getApplicationContext(),R.layout.p009githubuserscustomrow,githubUsersStrongP009s);
                listViewUsersP009.setAdapter(arrayAdapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });

        listViewUsersP009.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       GithubUsersStrongP009 githubUsersStrongP009=(GithubUsersStrongP009)parent.getItemAtPosition(position);
       login=githubUsersStrongP009.getLogin();

        RestAdapter restAdapter =new RestAdapter.Builder()
                .setEndpoint(endpoint.getUrl())
                .build();

        GithubUserInfoInterfaceP009 serviceUser=restAdapter.create(GithubUserInfoInterfaceP009.class);
        serviceUser.getUserInfo(login, new Callback<GithubUserInfoStrongP009>() {
            @Override
            public void success(GithubUserInfoStrongP009 githubUserInfoStrongP009, Response response) {

                String katar=githubUserInfoStrongP009.getId()+" "+githubUserInfoStrongP009.getLogin()+" "+githubUserInfoStrongP009.getAvatar_url()+
                        " "+githubUserInfoStrongP009.getName()+" "+githubUserInfoStrongP009.getEmail()+" "+githubUserInfoStrongP009.getPublic_repos()+
                        " "+githubUserInfoStrongP009.getPublic_gists()+ " "+githubUserInfoStrongP009.getFollowers()+" "+githubUserInfoStrongP009.getFollowing()+
                        " "+githubUserInfoStrongP009.getCreated_at();

                //String katar="1 2 3 4 5 6 7 8 9 10";  //kontrol tamamdir
                Intent intent=new Intent(P009GithubUsers.this,P009UserInfo.class);
                intent.putExtra("InfoOfUser",katar);
                startActivity(intent);

            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });
    }
    public interface GithubUserInfoInterfaceP009{
        @GET("/users/{login}")
        void getUserInfo(@Path("login") String login, Callback<GithubUserInfoStrongP009> callback);
    }
    public class GithubUserInfoStrongP009{
        private String id;
        private String login;
        private String avatar_url;
        private String name;
        private String email;
        private int public_repos;
        private int public_gists;
        private String followers;
        private String following;
        private String created_at;

        public String getId() {
            return id;
        }

        public String getLogin() {
            return login;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public int getPublic_repos() {
            return public_repos;
        }

        public int getPublic_gists() {
            return public_gists;
        }

        public String getFollowers() {
            return followers;
        }

        public String getFollowing() {
            return following;
        }

        public String getCreated_at() {
            return created_at;
        }
    }

    public interface GithubUsersInterfaceP009{
        @GET("/users")
        void getUsersData(Callback<List<GithubUsersStrongP009>> callback);
    }
    public class GithubUsersStrongP009{
        private String  login;
        private String id;
        private String avatar_url;
        private String url;

        public String getLogin() {
            return login;
        }

        public String getId() {
            return id;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public String getUrl() {
            return url;
        }
    }

}
*/
