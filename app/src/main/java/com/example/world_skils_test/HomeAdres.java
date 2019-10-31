package com.example.world_skils_test;

import com.example.world_skils_test.Home;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeAdres {
    @SerializedName("addresses")
    public List<Home> home;
    public List<Home> getList(){
        return this.home;
    }
}
