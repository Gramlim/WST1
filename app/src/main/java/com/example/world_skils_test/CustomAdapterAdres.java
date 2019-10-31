package com.example.world_skils_test;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterAdres extends ArrayAdapter<Home> {
    private final Activity context;
    private final List<Home> listHome;

    public CustomAdapterAdres(Activity context, List<Home> homeA) {
        super(context, R.layout.item_bank,homeA);
        this.context = context;
        this.listHome = homeA;
    }

    static class ViewHolder {
        public TextView adres;
        public TextView timeend;
        public TextView timestart;
        public TextView type;

        ViewHolder (View view){
            this.adres = view.findViewById(R.id.adres);
            this.timeend = view.findViewById(R.id.endW);
            this.timestart = view.findViewById(R.id.startW);
            this.type = view.findViewById(R.id.type_bank);
        }
        void setData (Home home){
            this.adres.setText(home.getAddress());
            this.timeend.setText(home.getTimeend());
            this.timestart.setText(home.getTimestart());
            this.type.setText(home.getType());
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        CustomAdapterAdres.ViewHolder holder;
        View rowView;
        LayoutInflater inflater = context.getLayoutInflater();
        rowView = inflater.inflate(R.layout.item_bank, null, true);
        holder = new CustomAdapterAdres.ViewHolder(rowView);
        holder.setData(listHome.get(position));
        return rowView;
    }
}
