package com.currency_calculator.main;

public class CurrencyRate {
    private final String currency;
    private final String rate;

    public CurrencyRate(String currency, String rate) {
        super();
        this.currency = currency;
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }
    public String getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "CurrencyRate [currency=" + currency + ", rate=" + rate + "]";
    }
}
