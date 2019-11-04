package com.example.world_skils_test;

import android.app.ListActivity;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class bankomat_list_activity extends ListActivity implements OnMapReadyCallback {

    GoogleMap mMap;
    SupportMapFragment mapFragment;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bank);


        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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


    void setDataToList(List<Home> building) {
        setListAdapter(new CustomAdapterAdres(this, building));
    }

    public void onMapReady(GoogleMap map) {
        this.mMap = map;
        this.mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.addMarker(new MarkerOptions().position(latLng).title("click"));
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(latLng);
                mMap.animateCamera(cameraUpdate);
            }
        });

    }



}

