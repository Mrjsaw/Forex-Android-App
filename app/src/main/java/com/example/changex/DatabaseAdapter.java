package com.example.changex;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.example.changex.db.AppDatabase;
import com.example.changex.db.Currency;

import java.util.ArrayList;

public class DatabaseAdapter extends Application {
    private static DatabaseAdapter mInstance;
    private static Context ctx;
    private AppDatabase db;

    private DatabaseAdapter(Context context) {
        ctx = context;
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "ChangeX-db").build();
    }

    public static synchronized DatabaseAdapter getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseAdapter(context);
        }
        return mInstance;
    }
    public void loadCurrencies() {
        Currency[] currencies = {};
        Currency usd = new Currency();
        db.currencyDAO().insertAll(currencies);
    }
}
