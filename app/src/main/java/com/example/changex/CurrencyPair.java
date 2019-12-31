package com.example.changex;

public class CurrencyPair {
    public String base;
    public String pair;
    public float exchangeRate;

    public CurrencyPair(String base, String pair, float exchangeRate) {
        this.base = base;
        this.pair = pair;
        this.exchangeRate = exchangeRate;
    }
}
