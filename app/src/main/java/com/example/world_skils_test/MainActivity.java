package com.example.world_skils_test;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    LinearLayout linear2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, bankomat_list_activity.class);
                startActivity(intent);
            }
        });
        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, valuet_list_activity.class);
                startActivity(intent);
            }
        });

    }

    public void onDialogAlert (View view){
        FragmentManager manager = getSupportFragmentManager();
        DialogFragment nF = new auth_class();
        nF.show(manager, "signin");

    }




    private void initData (){
        linear = findViewById(R.id.bankomat);
        linear2 = findViewById(R.id.valuet);
    }

}
