package com.example.changex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.changex.db.AppDatabase;
import com.example.changex.db.Currency;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public ListView listView;
    public ListViewAdapter itemsAdapter;
    public ArrayList<CurrencyPair> items;
    public static FragmentManager fragmentManager;
    public static AppDatabase myDatabase;
    public SwipeRefreshLayout mySwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetworkAdapter.getInstance(getApplicationContext()).getData("USD");
        mySwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.pullToRefresh);
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Log.i("SwipeRefresh:", "onRefresh called from SwipeRefreshLayout");
                        // This method performs the actual data-refresh operation.
                        // The method calls setRefreshing(false) when it's finished.
                        NetworkAdapter.getInstance(getApplicationContext()).getData("USD");
                    }

                }
        );

        fragmentManager = getSupportFragmentManager();
        myDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "ChangeX-db").allowMainThreadQueries().build();
        myDatabase.currencyDAO().nukeTable();
        seedDatabase();
        listView = findViewById(R.id.listView);
        items = getCurrencies();
        itemsAdapter = new ListViewAdapter(this, items);
        listView.setAdapter(itemsAdapter);

    }
    public ArrayList<CurrencyPair> getCurrencies() {
        ArrayList<CurrencyPair> currencyPairs = new ArrayList<>();
        Resources res = getResources();
        String[] currencies = res.getStringArray(R.array.currencies);
        String[] symbols = res.getStringArray(R.array.symbols);
        int ctr = 0;
        for (String s:currencies
             ) {
            CurrencyPair pair = new CurrencyPair("USD",s,symbols[ctr]+NetworkAdapter.getInstance(getApplicationContext()).getRates().get(ctr));
            currencyPairs.add(pair);
            ctr++;
        }
        return currencyPairs;

    }
    public void seedDatabase() {
        final String[] currencies = this.getApplicationContext().getResources().getStringArray(R.array.currencies);
        final String[] symbols = this.getApplicationContext().getResources().getStringArray(R.array.symbols);
        final String[] countries = this.getApplicationContext().getResources().getStringArray(R.array.countries);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < currencies.length; i++) {
                        Currency currency = new Currency();
                        currency.setCountry(countries[i]);
                        currency.setSymbol(symbols[i]);
                        currency.setName(currencies[i]);
                        Currency[] currencyList = {currency};
                        myDatabase.currencyDAO().insertAll(currencyList);
                    }
                }
        });
            t.run();
    }
}
