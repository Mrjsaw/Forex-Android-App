package com.example.changex.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "currencies")
public class Currency {
    @PrimaryKey
    public int cid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "country")
    public String country;

    @ColumnInfo(name = "symbol")
    public String symbol;
}
