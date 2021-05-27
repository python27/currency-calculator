package com.currency_calculator.main;

import java.io.IOException;

public class MenuDisplayer {
    Values values = new Values();
    Calculator calculator = new Calculator();
    int count;

    public void DisplayMenu(){
        count = 1;
        Parser parser = new Parser();
        System.out.println("Wybierz walute:");
        for (CurrencyRate currencyRate : parser.parsing()) {
            System.out.println(count + ". " + currencyRate.getCurrency() + " - " + currencyRate.getRate());
            count++;
        }
    }

    public void getCurrencyFromUser() throws IOException{
        values.setRate();
    }

    public void getAmountFromUser() throws IOException {
        System.out.println("Podaj kwotę EUR:");
        values.setAmountOfCash();
    }

    public void displayResult(){
        System.out.println("Wynik: " + calculator.calculate(values.getAmountOfCash(), values.getRate()));
    }
}
