package com.example.incir.retrofitsketch.network;

import com.example.incir.retrofitsketch.model.StackexchangeQuatoRemainigStrong;
import com.example.incir.retrofitsketch.model.StackexchangeSitesStrong;

import retrofit.Callback;
import retrofit.http.GET;
import java.util.List;
public interface StackexchageInterface {
    @GET("/2.2/users?order=desc&sort=reputation&site=stackoverflow")
    StackexchangeQuatoRemainigStrong getStackexchageQuotaInfo();

    @GET("/2.2/users?order=desc&sort=reputation&site=stackoverflow")
    void getItemsDetails (Callback<StackexchangeQuatoRemainigStrong> callback );

    @GET("/2.2/sites" )  //manipulate the url
    void getSitesStrong(Callback<StackexchangeSitesStrong> callback);

}
