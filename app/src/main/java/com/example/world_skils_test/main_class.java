package com.example.world_skils_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.app.ListActivity;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class main_class extends ListActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_menu);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
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
                        break;
                    case R.id.menu_pay:
                        final List<Valuet> listValuet;
                        Retrofit retrofit_val = new retrofit2.Retrofit.Builder()
                                .baseUrl("http://www.cbr.ru/")
                                .addConverterFactory(SimpleXmlConverterFactory.create())
                                .build();
                        ServerAPI api_val = retrofit_val.create(ServerAPI.class);


                        api_val.getData("27/10/2019").enqueue(new Callback<ValCurs>() {
                            @Override
                            public void onResponse(Call<ValCurs> call, Response<ValCurs> response) {
                                if (response.isSuccessful()) {
                                    setDataList(response.body().getList());

                                } else {
                                    TextView tvv = findViewById(R.id.valute_name);
                                    tvv.setText(response.message());
                                }

                            }

                            @Override
                            public void onFailure(Call<ValCurs> call, Throwable t) {
                                TextView tv = findViewById(R.id.valute_name);
                                tv.setText("Fail");
                            }
                        });

                        break;
                    case R.id.menu_dialogs:

                        break;
                }
                return false;
            }
        });

    }
    public void onSetting (View view){
        Intent intent = new Intent(main_class.this,setting_class.class);
        startActivity(intent);
    }
    private void setDataList(List<Valuet> listValuet  ) {
        setListAdapter(new CustomAdapter(this, listValuet));
    }
    void setDataToList(List<Home> building) {
        setListAdapter(new CustomAdapterAdres(this, building));
    }
}
