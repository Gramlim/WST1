package com.example.world_skils_test;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;


public class valuet_list_activity extends ListActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] values = new String[] {"Американский доллар","Американский доллар",
                "Американский доллар","Американский доллар","Американский доллар"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.valuet_layout, R.id.valute_name,values);
        setListAdapter(adapter);

    }
}
