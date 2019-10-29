package com.example.world_skils_test;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerAPI {

    @GET("scripts/XML_daily.asp")
    Call<ValCurs> getData(@Query("date_req") String date_req);
}
