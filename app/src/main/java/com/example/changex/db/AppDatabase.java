package com.example.changex.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Currency.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CurrencyDAO currencyDAO();
}
