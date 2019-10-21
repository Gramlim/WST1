package com.example.world_skils_test;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

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
                Intent intent = new Intent(MainActivity.this,bankomat_list_activity.class);
                startActivity(intent);
            }
        });
        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,valuet_list_activity.class);
                startActivity(intent);
            }
        });

    }

    public Dialog onDialogAlert (){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.auth, null));
        return builder.create();

    }




    private void initData (){
        linear = findViewById(R.id.bankomat);
        linear2 = findViewById(R.id.valuet);
    }

}
