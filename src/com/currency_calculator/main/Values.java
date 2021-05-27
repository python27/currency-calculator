package com.currency_calculator.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Values {
    private double amountOfCash;
    private double rate;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Parser parser;

    public double getAmountOfCash(){
        return this.amountOfCash;
    }

    public void setAmountOfCash() throws IOException {
        amountOfCash = Double.parseDouble(reader.readLine());
    }

    public double getRate(){
        return rate;
    }

    public void setRate() {
        parser = new Parser();
        System.out.println("Proszę wybrać liczbę z przedziału 1-32");
        tryParseInt();
    }
    public boolean tryParseInt() {
        try {
            String name = reader.readLine();
            this.rate = Double.parseDouble(parser.parsing().get((Integer.parseInt(name)) - 1).getRate());
            return false;
        } catch (Exception e) {
            System.out.println("Proszę wybrać liczbę z przedziału 1-32!");
            return tryParseInt();
        }
    }
}
