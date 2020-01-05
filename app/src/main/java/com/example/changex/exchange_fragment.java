package com.example.changex;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.changex.db.AppDatabase;
import com.example.changex.db.Currency;

import java.util.ArrayList;

public class exchange_fragment extends Fragment {
    public ListView listView;
    public ListViewAdapter itemsAdapter;
    public ArrayList<CurrencyPair> items;
    public static AppDatabase myDatabase;
    public SwipeRefreshLayout mySwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.exchange_layout, null);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getActivity().setContentView(R.layout.exchange_layout);

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        NetworkAdapter.getInstance(getActivity().getApplicationContext()).getData("USD");
        listView = getView().findViewById(R.id.listView);
        items = getCurrencies();
        itemsAdapter = new ListViewAdapter(getActivity(), items);
        listView.setAdapter(itemsAdapter);
        mySwipeRefreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.pullToRefresh);
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Log.i("SwipeRefresh:", "onRefresh called from SwipeRefreshLayout");
                        // This method performs the actual data-refresh operation.
                        // The method calls setRefreshing(false) when it's finished.
                        NetworkAdapter.getInstance(getActivity().getApplicationContext()).getData("USD");
                        items=getCurrencies();
                        itemsAdapter.notifyDataSetChanged();
                        mySwipeRefreshLayout.setRefreshing(false);
                    }

                }
        );

        myDatabase = Room.databaseBuilder(getActivity().getApplicationContext(),
                AppDatabase.class, "ChangeX-db").allowMainThreadQueries().build();
        myDatabase.currencyDAO().nukeTable();
        seedDatabase();
    }
    public ArrayList<CurrencyPair> getCurrencies() {
        ArrayList<CurrencyPair> currencyPairs = new ArrayList<>();
        Resources res = getResources();
        String[] currencies = res.getStringArray(R.array.currencies);
        String[] symbols = res.getStringArray(R.array.symbols);
        int ctr = 0;
        for (String s:currencies
        ) {
            CurrencyPair pair = new CurrencyPair("USD",s,symbols[ctr]+NetworkAdapter.getInstance(getActivity().getApplicationContext()).getRates().get(ctr));
            currencyPairs.add(pair);
            ctr++;
        }
        return currencyPairs;

    }
    public void seedDatabase() {
        final String[] currencies = getActivity().getApplicationContext().getResources().getStringArray(R.array.currencies);
        final String[] symbols = getActivity().getApplicationContext().getResources().getStringArray(R.array.symbols);
        final String[] countries = getActivity().getApplicationContext().getResources().getStringArray(R.array.countries);
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
