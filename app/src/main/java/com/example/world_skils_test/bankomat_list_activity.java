package com.example.world_skils_test;

import android.app.ListActivity;
//import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;



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

        String[] values = new String[]{"Москва,ул.Вавилова,д.7","Москва,ул.Вавилова,д.8",
                "Москва,ул.Вавилова,д.9","Москва,ул.Вавилова,д.10","Москва,ул.Вавилова,д.11"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.item_bank, R.id.adres, values);
        setListAdapter(adapter);
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
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mapview.getMap().move(
                new CameraPosition(new Point(55.783724, 38.445249), 15.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);
    }
}

