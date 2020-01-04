package com.example.changex;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.example.changex.db.AppDatabase;
import com.example.changex.db.Currency;

import java.util.List;


public class DatabaseAdapter extends Application {
    private static DatabaseAdapter mInstance;
    private static Context ctx;
    private AppDatabase db;

    private DatabaseAdapter(Context context) {
        ctx = context;
        db = getDatabase();
        loadCurrencies();
    }

    public static synchronized DatabaseAdapter getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseAdapter(context);
        }
        return mInstance;
    }
    public AppDatabase getDatabase() {
        if (db == null) {
            db = Room.databaseBuilder(ctx,
                    AppDatabase.class, "ChangeX-db").allowMainThreadQueries().build();
        }
        return db;
    }
    public void loadCurrencies() {
        String[] currencies = ctx.getResources().getStringArray(R.array.currencies);
        String[] symbols = ctx.getResources().getStringArray(R.array.symbols);
        String[] countries = ctx.getResources().getStringArray(R.array.countries);

        for(int i = 0; i < currencies.length; i++) {
            Currency currency = new Currency();
            currency.setCountry(countries[i]);
            currency.setSymbol(symbols[i]);
            currency.setName(currencies[i]);
            Currency[] currencyList = {currency};
            mInstance.db.currencyDAO().insertAll(currencyList);
            Log.i("info:", currency.toString());
        }


    }
}
