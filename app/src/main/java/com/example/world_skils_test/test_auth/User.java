package com.example.world_skils_test.test_auth;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("token")
    private String token;

    public String getToken(){
        return token;
    }
}
