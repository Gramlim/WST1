package com.example.world_skils_test;

import android.app.ListActivity;
//import android.graphics.Point;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class bankomat_list_activity extends ListActivity {
    private MapView mapview;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey("f417b19f-469c-4852-bcd5-ce84f5a402bc");
        MapKitFactory.initialize(this);
        setContentView(R.layout.layout_bank);
        mapview = (MapView)findViewById(R.id.mapview);
        mapview.getMap().move(
                new CameraPosition(new Point(55.807068, 38.424886), 15.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);

        final List<Home> listHome;
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("http://intelligent-system.online/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        adres_interface api = retrofit.create(adres_interface.class);
        api.getData().enqueue(new Callback<HomeAdres>() {
            @Override
            public void onResponse(Call<HomeAdres> call, Response<HomeAdres> response) {
                if (response.isSuccessful()) {
                    setDataToList(response.body().getList());
                } else {
                    TextView tvv = findViewById(R.id.title_bank);
                    tvv.setText(response.message());
                }
            }

            @Override
            public void onFailure(Call<HomeAdres> call, Throwable t) {
                TextView tv = findViewById(R.id.title_bank);
                tv.setText("Fail");
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapview.onStart();
        MapKitFactory.getInstance().onStart();
    }
    void setDataToList(List<Home> sss){
        setListAdapter(new CustomAdapterAdres(this,sss));
    }

}

