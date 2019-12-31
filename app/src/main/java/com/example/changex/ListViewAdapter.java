package com.example.changex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<CurrencyPair> {


    public ListViewAdapter(@NonNull Context context,  @NonNull List<CurrencyPair> objects) {
        super(context, 0, objects);
    }
    private static class ViewHolder {
        TextView country;
        TextView exchange;
        TextView amount;
        ImageView flag;
    }
    private int lastPosition = -1;
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CurrencyPair currencyPair = getItem(position);
        ViewHolder viewHolder;
        final View result;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row, parent, false);
            viewHolder.country = (TextView) convertView.findViewById(R.id.country);
            viewHolder.exchange = (TextView) convertView.findViewById(R.id.exchange);
            viewHolder.amount = (TextView) convertView.findViewById(R.id.amount);
            viewHolder.flag = (ImageView) convertView.findViewById(R.id.flag);
            convertView.setTag(viewHolder);
            //convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);

        }
    else {
        viewHolder = (ViewHolder) convertView.getTag();
    }
        lastPosition = position;
        viewHolder.country.setText(currencyPair.getBase());
        viewHolder.exchange.setText("1 " + currencyPair.getBase() + " = " + (currencyPair.getExchangeRate() * 1) + " " + currencyPair.getPair());
        viewHolder.amount.setText("$" + String.format("%.02f",currencyPair.getExchangeRate()));
        //viewHolder.flag(this);
        //viewHolder.flag.setTag(position);
        return convertView;
    }
}
