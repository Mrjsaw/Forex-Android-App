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

    public String getBase() {
        return base;
    }

    public String getPair() {
        return pair;
    }

    public float getExchangeRate() {
        return exchangeRate;
    }
}
