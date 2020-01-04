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
    /*
    @Query("SELECT * FROM currency WHERE cid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "name LIKE :last LIMIT 1")
    User findByName(String first, String last);
    */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Currency... currencies);

    @Delete
    void delete(Currency currency);

}
