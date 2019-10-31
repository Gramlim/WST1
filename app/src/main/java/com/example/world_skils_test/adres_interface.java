package com.example.world_skils_test;

import retrofit2.Call;
import retrofit2.http.GET;

public interface adres_interface {
    @GET("api/system/address")
    Call<HomeAdres> getData();
}
