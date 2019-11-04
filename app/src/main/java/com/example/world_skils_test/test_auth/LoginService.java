package com.example.world_skils_test.test_auth;

import retrofit2.Call;
import retrofit2.http.POST;

public interface LoginService {
    @POST("api/tokens")
    Call<User> basicLogin();
}
