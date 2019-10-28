package com.example.world_skils_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.app.ListActivity;

import androidx.appcompat.app.AppCompatActivity;

public class main_class extends ListActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String[] type = new String[]{"Дебетовая карта","Дебетовая карта","Дебетовая карта"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.card_item, R.id.type_card, type);
        setListAdapter(adapter);

    }
    public void onSetting (View view){
        Intent intent = new Intent(main_class.this,setting_class.class);
        startActivity(intent);
    }
}
