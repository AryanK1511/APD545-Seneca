package com.apd;

class ExchangeRate {
    String fromCurrency;
    String toCurrency;
    double rate;

    public ExchangeRate(String fromCurrency, String toCurrency, double rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "From Currency: " + fromCurrency + ", To Currency: " + toCurrency + ", Exchange rate: " + rate;
    }
}


