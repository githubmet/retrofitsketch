package com.example.incir.retrofitsketch.network;

import com.example.incir.retrofitsketch.model.HanselandpetalStrong;

import retrofit.http.GET;
import java.util.List;

public interface HanselandpetalInterface {
    @GET("/feeds/flowers.json")
    List<HanselandpetalStrong> getHanselandpetalStrongList();
}
