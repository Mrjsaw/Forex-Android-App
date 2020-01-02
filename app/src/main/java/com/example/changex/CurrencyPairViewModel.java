package com.example.changex;

import android.media.Image;

public class CurrencyPairViewModel {
    Image flag;
    String country;
    String exchange;
    String amount;

    public CurrencyPairViewModel(CurrencyPair pair) {
        country = getCountry(pair.getQuote());
        exchange = "1 " + pair.getBase() + " = " + pair.getExchangeRate() + " " + pair.getQuote();
        amount = "$" + String.format("%.02f",pair.getExchangeRate());
        //TODO: add flag
        //flag = ?
    }

    public String getCountry() {
        return country;
    }

    public String getExchange() {
        return exchange;
    }

    public String getAmount() {
        return amount;
    }

    public Image getFlag() {
        return flag;
    }

    public String getCountry(String currency) {
        String country = "N/A";
        switch (currency) {
            case "USD": country = "United States";
                break;
            case "EUR": country = "Europe";
                break;
            case "AUD": country = "Australia";
                break;
            case "GBP": country = "Great Britain";
                break;
            case "JPY": country = "Japan";
                break;
            case "CAD": country = "Canada";
                break;
            case "CNY": country = "China";
                break;
            case "INR": country = "India";
                break;
            case "HKD": country = "Hong Kong";
                break;
            case "IDR": country = "Indonesia";
                break;
            case "TRY": country = "Turkey";
                break;
            case "ZWD": country = "Zimbabwe";
                break;
            case "BTC": country = "Bitcoin";
                break;
        }
        return country;
    }
}
