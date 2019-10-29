package com.example.world_skils_test;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerAPI {

    @GET("/api/get")
    Call<ValCurs> getData(@Query("date_req") String date_req);


}
