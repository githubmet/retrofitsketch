package com.example.incir.retrofitsketch.backbone;

import android.support.v7.app.AppCompatActivity;

import com.example.incir.retrofitsketch.network.GithubInterface;
import com.example.incir.retrofitsketch.network.HanselandpetalInterface;
import com.example.incir.retrofitsketch.network.StackexchageInterface;

import retrofit.RestAdapter;

public class AddMtdToAppCompatActivity extends AppCompatActivity {

    public RestAdapter getRetrofitGithub(){
        RestAdapter restAdapter= ((AddObjectToApp)getApplication()).getRetrofitGithub();
        return restAdapter;
    }
    public GithubInterface getGithubNetwork(){
        GithubInterface githubInterface=(GithubInterface)getRetrofitGithub()
                .create(GithubInterface.class);

        return githubInterface;
    }

    public RestAdapter getRetrofitHanselandpetal(){
        RestAdapter restAdapter=((AddObjectToApp) getApplication()).getRetrofitHaselandpetal();
        return restAdapter;
    }
    public HanselandpetalInterface getHansepetalNetwork(){
        HanselandpetalInterface hanselandpetalInterface=(HanselandpetalInterface)
                getRetrofitHanselandpetal().create(HanselandpetalInterface.class);
        return hanselandpetalInterface;
    }
    public RestAdapter getRetrofitStackexchange(){
        return ((AddObjectToApp)getApplication()).getRestAdapterStackexchange();
    }
    public StackexchageInterface getStackexchangeNetwork(){
        StackexchageInterface stackexchageInterface
                = getRetrofitStackexchange().create(StackexchageInterface.class);
        return stackexchageInterface;
    }


}


/* Hata
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RestAdapter restAdapter=((AddObjectToApp)getApplication()).getRetrofit();
    }
*/