package com.example.world_skils_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class main_class extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }
    public void onSetting (View view){
        Intent intent = new Intent(main_class.this,setting_class.class);
        startActivity(intent);
    }
}
