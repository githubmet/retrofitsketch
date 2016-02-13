package com.example.incir.retrofitsketch.network;

import com.example.incir.retrofitsketch.model.GithubGistsStrong;
import com.example.incir.retrofitsketch.model.GithubPublicGistsStrong;
import com.example.incir.retrofitsketch.model.GithubUserSearchStrong;
import com.example.incir.retrofitsketch.model.GithubUsersDetailsStrong;
import com.example.incir.retrofitsketch.model.GithubUsersStrong;
import com.example.incir.retrofitsketch.model.GithubUsersUserReposStrong;

import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.Path;
import retrofit.Callback;


import java.util.List;

public interface GithubInterface {

    @GET("/gists/public")
    List<GithubGistsStrong> getGithubGistsStrongList();
    //Callback kullanmamizin tek nedeni elde edilen verileri islemeyecegiz .toString() ile raw olarak yazdiriyoruz.

    @GET("/gists/public")
    void getGithubGistsPublicListCallback(Callback<List<GithubGistsStrong>>
                                          githubGistsStrongListCallback);


    @GET("/search/users")
    GithubUserSearchStrong getGithubUserSearchStrong(@Query("q") String UserName);

    @GET("/users/{username}")
    GithubUsersDetailsStrong getGithubUsersDetailsStrong(@Path("username") String username);

    @GET("/users/{username}")
    void getGithubUserDetailsStrongCallBack (@Path("username") String userName,
                                             Callback<GithubUsersDetailsStrong> callback);
    @GET("/gists/public")
    //List<GithubPublicGistsStrong> getGithubPublicGistsStrongList(); //this time try callback
    void getGithubPublicGistsStrongCallback(Callback<List<GithubPublicGistsStrong>>
                                            githubPublicGistsStrongListCallback);
    @GET("/users/{user}/repos")
    void getGithubUsersUserReposStrongCallback(@Path("user") String userName,
                                               Callback<List<GithubUsersUserReposStrong>>
                                                       githubUsersUserReposStrongListCallback);

    @GET("/users")
    void getGithubUsersStrongCallBackList(Callback<List<GithubUsersStrong>>
                                          githubUsersStrongCallbackList);
}
