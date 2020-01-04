package com.example.changex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.changex.db.AppDatabase;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public ListView listView;
    public ListViewAdapter itemsAdapter;
    public ArrayList<CurrencyPair> items;
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            //
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetworkAdapter.getInstance(getApplicationContext()).getData("USD");
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.exchangeratesapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CurrencyExchangeAPI service = retrofit.create(CurrencyExchangeAPI.class);
        Call<List<Currencies>> rates = service.listRates("USD");
        Log.i("test:", rates.toString());
        */
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
            CurrencyPair pair = new CurrencyPair("USD",s,"1.567");
            currencyPairs.add(pair);
        }
        return currencyPairs;

    }
}
