package com.currency_calculator.main;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        MenuDisplayer menuDisplayer = new MenuDisplayer();
        menuDisplayer.DisplayMenu();
        menuDisplayer.getCurrencyFromUser();
        menuDisplayer.getAmountFromUser();
        menuDisplayer.displayResult();
    }
}