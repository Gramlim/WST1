package com.example.world_skils_test;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class CustomAdapter extends ArrayAdapter<Valuet> {


    private final Activity context;
    private final List<Valuet> listValuet;
    public CustomAdapter(Callback<ValCurs> context, List<Valuet> valuet) {
        super(context,R.layout.valuet_item, valuet);
        this.listValuet = valuet;
        this.context = (Activity) context;
    }
    static class ViewHolder {
        public TextView name;
        public TextView code;
        public TextView value;

        ViewHolder(View view) {
            this.name = view.findViewById(R.id.name_txt);
            this.code = view.findViewById(R.id.code_txt);
            this.value = view.findViewById(R.id.value_txt);
        }

        void setData (Valuet valuet){
            this.name.setText(valuet.getName());
            this.code.setText(valuet.getCharCode());
            this.value.setText(valuet.getValue());
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View rowView;
        LayoutInflater inflater = context.getLayoutInflater();
        rowView = inflater.inflate(R.layout.valuet_item, null, true);
        holder = new ViewHolder(rowView);
        holder.setData(listValuet.get(position));
        return rowView;
    }



}
