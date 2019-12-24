package com.example.changex.model;

public class CurrencyPair {
    private float exchangeAmount;
    private String currency1;
    private String currency2;

    public CurrencyPair(float exchangeAmount, String currency1, String currency2) {
        this.exchangeAmount = exchangeAmount;
        this.currency1 = currency1;
        this.currency2 = currency2;
    }

    public float getExchangeAmount() {
        return exchangeAmount;
    }

    public void setExchangeAmount(float exchangeAmount) {
        this.exchangeAmount = exchangeAmount;
    }

    public String getCurrency1() {
        return currency1;
    }

    public void setCurrency1(String currency1) {
        this.currency1 = currency1;
    }

    public String getCurrency2() {
        return currency2;
    }

    public void setCurrency2(String currency2) {
        this.currency2 = currency2;
    }
}
