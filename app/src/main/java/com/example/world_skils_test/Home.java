package com.example.world_skils_test;

import com.google.gson.annotations.SerializedName;

public class Home {
    @SerializedName("address")
    private String address;
    @SerializedName("timeend")
    private String timeend;
    @SerializedName("timestart")
    private String timestart;
    @SerializedName("type")
    public String type;


    public String getAddress(){
        return address;
    }
    public String getTimeend(){
        return timeend;
    }
    public String getTimestart() {
        return timestart;
    }
    public String getType(){
        return type;
    }
}
