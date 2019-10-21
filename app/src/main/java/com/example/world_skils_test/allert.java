package com.example.world_skils_test;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.view.LayoutInflater;

public class allert extends ListActivity {
    public Dialog onDialogAlert (){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater =  getActivity().getLayoutInflarter();
        builder.setView(inflater.inflate(R.layout.auth, null));
        return builder.create();

    }
}
