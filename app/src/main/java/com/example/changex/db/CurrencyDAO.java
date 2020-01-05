package com.example.changex.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface CurrencyDAO {

    @Query("DELETE FROM currencies")
    void nukeTable();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Currency... currencies);


}
