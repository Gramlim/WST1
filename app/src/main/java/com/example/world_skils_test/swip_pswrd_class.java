package com.example.world_skils_test;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.DialogFragment;

public class swip_pswrd_class extends DialogFragment {
    public Dialog onCreateDialog (final Bundle savedInstanceState){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.swip_pswrd, null);
        builder.setView(view);
        Button pasSWP = view.findViewById(R.id.pas_swp);
        pasSWP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        Button pasCan = view.findViewById(R.id.dont_swap_l);
        pasCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            dismiss();
            }
        });
        return builder.create();
    }
}
