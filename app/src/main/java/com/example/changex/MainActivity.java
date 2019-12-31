package com.example.changex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListView listView;
    public ListViewAdapter itemsAdapter;
    public ArrayList<CurrencyPair> items = new ArrayList<>();
    public CurrencyPair cp = new CurrencyPair("USD", "EUR", 1.025F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        items.add(cp);
        itemsAdapter = new ListViewAdapter(this, items);
        listView.setAdapter(itemsAdapter);
    }
}
