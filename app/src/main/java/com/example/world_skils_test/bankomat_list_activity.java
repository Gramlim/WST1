package com.example.world_skils_test;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class bankomat_list_activity extends ListActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        String[] values = new String[]{"Москва,ул.Вавилова,д.7","Москва,ул.Вавилова,д.8",
                "Москва,ул.Вавилова,д.9","Москва,ул.Вавилова,д.10","Москва,ул.Вавилова,д.11"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.bank_layout, R.id.adres, values);
        setListAdapter(adapter);
    }
}

