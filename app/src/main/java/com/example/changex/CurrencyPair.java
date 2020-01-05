package com.example.changex;

public class CurrencyPair {
    public String base;
    public String quote;
    public String exchangeRate;

    public CurrencyPair(String base, String quote, String exchangeRate) {
        this.base = base;
        this.quote = quote;
        this.exchangeRate = exchangeRate;
    }

    public String getBase() {
        return base;
    }

    public String getQuote() {
        return quote;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }
}
