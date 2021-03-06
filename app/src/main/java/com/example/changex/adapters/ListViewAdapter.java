package com.example.changex.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.changex.CurrencyPair;
import com.example.changex.R;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<CurrencyPair> {

    public ListViewAdapter(@NonNull Context context, @NonNull List<CurrencyPair> objects) {
        super(context, 0, objects);
    }

    private static class ViewHolder {
        TextView country;
        TextView exchange;
        TextView amount;
        ImageView flag;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CurrencyPair currencyPair = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row, parent, false);
            viewHolder.country = (TextView) convertView.findViewById(R.id.country);
            viewHolder.exchange = (TextView) convertView.findViewById(R.id.exchange);
            viewHolder.amount = (TextView) convertView.findViewById(R.id.amount);
            viewHolder.flag = (ImageView) convertView.findViewById(R.id.flag);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.country.setText(getCountry(currencyPair.getQuote()));
        viewHolder.exchange.setText("1 " + currencyPair.getBase() + " = " + (currencyPair.getExchangeRate()) + " " + currencyPair.getQuote());
        viewHolder.amount.setText(currencyPair.getExchangeRate());
        //TODO: Refactor this
        switch(currencyPair.getQuote()) {
            case "USD": viewHolder.flag.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_flag_usa));
                break;
            case "EUR": viewHolder.flag.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_flag_eu));
                break;
            case "AUD": viewHolder.flag.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_flag_au));
                break;
            case "GBP": viewHolder.flag.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_flag_uk));
                break;
            case "JPY": viewHolder.flag.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_flag_japan));
                break;
            case "CAD": viewHolder.flag.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_flag_canada));
                break;
            case "CNY": viewHolder.flag.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_flag_china));
                break;
            case "INR": viewHolder.flag.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_flag_india));
                break;
            case "HKD": viewHolder.flag.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_flag_hk));
                break;
            case "IDR": viewHolder.flag.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_flag_indo));
                break;
            case "TRY": viewHolder.flag.setImageDrawable(ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_flag_turkey));
                break;
        }

        return convertView;
    }
    public String getCountry(String currency) {
        String country = "N/A";
        switch (currency) {
            case "USD": country = "United States";
                break;
            case "EUR": country = "Europe";
                break;
            case "AUD": country = "Australia";
                break;
            case "GBP": country = "United Kingdom";
                break;
            case "JPY": country = "Japan";
                break;
            case "CAD": country = "Canada";
                break;
            case "CNY": country = "China";
                break;
            case "INR": country = "India";
                break;
            case "HKD": country = "Hong Kong";
                break;
            case "IDR": country = "Indonesia";
                break;
            case "TRY": country = "Turkey";
                break;
        }
        return country;
    }
}
