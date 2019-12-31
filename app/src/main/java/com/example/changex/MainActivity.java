package com.example.changex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListView listView;
    public ListViewAdapter itemsAdapter;
    public ArrayList<CurrencyPair> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        items = getCurrencies();
        itemsAdapter = new ListViewAdapter(this, items);
        listView.setAdapter(itemsAdapter);

    }
    public ArrayList<CurrencyPair> getCurrencies() {
        ArrayList<CurrencyPair> currencyPairs = new ArrayList<>();
        Resources res = getResources();
        String[] currencies = res.getStringArray(R.array.currencies);
        for (String s:currencies
             ) {
            CurrencyPair pair = new CurrencyPair("USD",s,2.0456f);
            currencyPairs.add(pair);
        }
        return currencyPairs;

    }
}
