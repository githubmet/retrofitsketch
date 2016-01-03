package com.example.incir.retrofitsketch;


import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
public interface P123FlowersInterface {
    @GET("/feeds/flowers.json")
    void getFlowersData(Callback<List<P123FlowersStronglyType>> callback);
}
