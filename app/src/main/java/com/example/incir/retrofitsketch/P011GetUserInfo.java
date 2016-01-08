package com.example.incir.retrofitsketch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Endpoint;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

public class P011GetUserInfo extends Activity {
    String[] dizi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();
        String userName=bundle.getString("userName");
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
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

        RestAdapter restAdapter =new RestAdapter.Builder()
                .setEndpoint(endpoint.getUrl())
                .build();

        UserInterface service= restAdapter.create(UserInterface.class); //asil cache storage alanina direk mudehale etmemeliyim.

        UserClass userClass= service.getUserItems(userName);
         List<UserItemsClass> userItemsClasses= userClass.items;
        ////for(int i=0;i<userItemsClasses.size();i++){   //eger bu sekilde bir arama yaparsan ilgili enson eleman gosterilir. Aradigini bulamazsin.
        ////Ornek ben githubmet ararim o bana githubmeteorz gosterir
            dizi=new String []{userItemsClasses.get(0).getId(),userItemsClasses.get(0).getLogin(),userItemsClasses.get(0).getAvatar_url(),userItemsClasses.get(0).getUrl(),
                    userItemsClasses.get(0).getHtml_url(),userItemsClasses.get(0).getFollowers_url(),userItemsClasses.get(0).getFollowing_url(),userItemsClasses.get(0).getGists_url(),
                    userItemsClasses.get(0).getStarred_url(),userItemsClasses.get(0).getSubscriptions_url(),userItemsClasses.get(0).getOrganizations_url(),
                    userItemsClasses.get(0).getRepos_url(),userItemsClasses.get(0).getEvents_url(),userItemsClasses.get(0).getEvents_url(),userItemsClasses.get(0).getReceived_events_url(),
                    userItemsClasses.get(0).getType(),userItemsClasses.get(0).getSite_admin(),userItemsClasses.get(0).getScore()};
        ////}


        // String[] dizi=new String[]{"1","2","3","4","5","6","1","1","1","1","1","1","1","1","1","1","1","1"};  //kontrol tamam
        Intent intent2=new Intent(getApplicationContext(),P011ShowUserInfo.class);
        intent2.putExtra("katar", dizi);
        startActivity(intent2);

    }
    public interface UserInterface{
        @GET("/search/users")
        UserClass getUserItems(@Query("q") String query);//, Callback<UserItemsClass> callback);
    }
    public class UserClass{
        public List<UserItemsClass> items;  //bilginden fazlasini tarama hataya sebep olur
        //acaba Map<String,String> kullanip tum verileri cekse idik daha iyi yapardik gibi. Hadi yapalim
        //Map<String,String> items;  //olmadi  mapUser.get("type").toString() seklinde cekecektik olmadi

    }
    public class UserItemsClass{
        private String login;      //eger bir yerde neden bos is yapayim dersen mutlaka bir kisa yolu vardir. make public to private.
        private String id;
        private String avatar_url;
        private String gravatar_id;
        private String url;
        private String html_url;
        private String followers_url;
        private String following_url;
        private String gists_url;
        private String starred_url;
        private String  subscriptions_url;
        private String  organizations_url;
        private String  repos_url;
        private String  events_url;
        private String  received_events_url;
        private String  type;
        private String  site_admin;
        private String score;

        public String getLogin() {
            return login;
        }

        public String getId() {
            return id;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public String getGravatar_id() {
            return gravatar_id;
        }

        public String getUrl() {
            return url;
        }

        public String getHtml_url() {
            return html_url;
        }

        public String getFollowers_url() {
            return followers_url;
        }

        public String getFollowing_url() {
            return following_url;
        }

        public String getGists_url() {
            return gists_url;
        }

        public String getStarred_url() {
            return starred_url;
        }

        public String getSubscriptions_url() {
            return subscriptions_url;
        }

        public String getOrganizations_url() {
            return organizations_url;
        }

        public String getRepos_url() {
            return repos_url;
        }

        public String getEvents_url() {
            return events_url;
        }

        public String getReceived_events_url() {
            return received_events_url;
        }

        public String getType() {
            return type;
        }

        public String getSite_admin() {
            return site_admin;
        }

        public String getScore() {
            return score;
        }


    }
}

/*
private HashMap<String,UserItemsClass> items;
public HashMap<String, UserItemsClass> getItems() {
return items;
HashMap<String,UserItemsClass> hashMapUserItemsClass= userClass.getItems();
UserItemsClass userItemsClasses= hashMapUserItemsClass.get("items");  //begin an object oluyor hata
for(Object key :hashMapUserItemsClass.keySet()){
UserItemsClass userItemsClasses= hashMapUserItemsClass.get(key);
dizi=new String []{userItemsClasses.getId(),userItemsClasses.getLogin(),userItemsClasses.getAvatar_url(),userItemsClasses.getUrl(),
userItemsClasses.getHtml_url(),userItemsClasses.getFollowers_url(),userItemsClasses.getFollowing_url(),userItemsClasses.getGists_url(),
userItemsClasses.getStarred_url(),userItemsClasses.getSubscriptions_url(),userItemsClasses.getOrganizations_url(),
userItemsClasses.getRepos_url(),userItemsClasses.getEvents_url(),userItemsClasses.getEvents_url(),userItemsClasses.getReceived_events_url(),
userItemsClasses.getType(),userItemsClasses.getSite_admin(),userItemsClasses.getScore()};
}
*/







