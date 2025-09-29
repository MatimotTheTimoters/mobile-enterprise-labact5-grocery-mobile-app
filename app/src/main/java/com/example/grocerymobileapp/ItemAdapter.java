package com.example.grocerymobileapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {
    public ItemAdapter(Context context, int resource, ArrayList<Item> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        Item item = getItem(position);
        TextView tvName = convertView.findViewById(R.id.tvItemName);
        TextView tvQuantity = convertView.findViewById(R.id.tvQuantity);
        TextView tvPrice = convertView.findViewById(R.id.tvPrice);

        tvName.setText(item.getName());
        tvQuantity.setText(String.valueOf(item.getQuantity()));
        tvPrice.setText(String.valueOf(item.getPrice()));

        return convertView;
    }
}
