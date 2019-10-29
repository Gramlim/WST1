package com.example.world_skils_test;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


public class valuet_list_activity extends ListActivity {


    private Context listValue;
    private Object Valuet;
    private Object List;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valuet_layout);
        final List<Valuet> listValuet;
        Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("http://www.cbr.ru/scripts/XML_daily.asp")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        ServerAPI api = retrofit.create(ServerAPI.class);


        api.getData("27/10/2019").enqueue(new Callback<ValCurs>() {
            @Override
            public void onResponse(Call<ValCurs> call, Response<ValCurs> response) {
                if (response.isSuccessful()) {
                    setDataToList(response.body().getList());

                } else {
                    TextView tvv = findViewById(R.id.valut_war);
                    tvv.setText(response.message());
                }

            }

            private void setDataToList(List<Valuet> listValuet) {
                setListAdapter(new CustomAdapter(this, listValuet));
            }

            @Override
            public void onFailure(Call<ValCurs> call, Throwable t) {
                TextView tv = findViewById(R.id.valut_war);
                tv.setText("Fail");
            }
        });





    }
}
