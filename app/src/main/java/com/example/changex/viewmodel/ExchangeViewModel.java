package com.example.changex.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.changex.model.CurrencyPair;

public class ExchangeViewModel extends BaseObservable {
    private CurrencyPair _currencyPair;

    @Bindable
    private String getCurrency1() {
        return _currencyPair.getCurrency1();
    }
    @Bindable
    private String getCurrency2() {
        return _currencyPair.getCurrency2();
    }
    @Bindable
    private float getExchangeAmount() { return _currencyPair.getExchangeAmount(); }

    public void setCurrencyPair1(String currency) {
        _currencyPair.setCurrency1(currency);
       // notifyPropertyChanged(com.example.changex.BR.currencyOne);
    }
    public void setCurrencyPair2(String currency) {
        _currencyPair.setCurrency2(currency);
       // notifyPropertyChanged(com.example.changex.BR.currencyTwo);
    }
    public void setExchangeAmount(float amount) {
        _currencyPair.setExchangeAmount(amount);

    }
    public ExchangeViewModel() {
        //TODO: bind the xml stuff here _currencypair = new Currenypair(?,"","")
    }
}
