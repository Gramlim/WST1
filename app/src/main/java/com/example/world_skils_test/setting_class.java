package com.example.world_skils_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class setting_class extends AppCompatActivity {
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.setting);

        }
        public void onPasSWP(View view){
            FragmentManager manager = getSupportFragmentManager();
            DialogFragment nF = new swip_pswrd_class();
            nF.show(manager, "swap_p");
        }
        public void onLogSWP(View view){
            FragmentManager manager = getSupportFragmentManager();
            DialogFragment nF = new swp_log_class();
            nF.show(manager, "swap_l");
        }
        public void onInfo (View view){
            Intent intent = new Intent(setting_class.this,about_app_class.class);
            startActivity(intent);
        }
        public void onExit (View view){
            Intent intent = new Intent(setting_class.this,MainActivity.class);
            startActivity(intent);
        }
}
