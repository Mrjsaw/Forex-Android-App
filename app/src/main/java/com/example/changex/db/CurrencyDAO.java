package com.example.changex.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CurrencyDAO {
    @Query("SELECT * FROM currencies")
    List<Currency> getAll();

    @Query("DELETE FROM currencies")
    void nukeTable();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Currency... currencies);

    @Delete
    void delete(Currency currency);

}
