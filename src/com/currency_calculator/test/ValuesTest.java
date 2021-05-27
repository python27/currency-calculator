package com.currency_calculator.test;

import com.currency_calculator.main.Values;
import org.junit.jupiter.api.Assertions;

class ValuesTest {

    Values values = new Values();
    @org.junit.jupiter.api.Test
    void getAmountOfCash() {
        Assertions.assertEquals(0,values.getAmountOfCash(), "");
    }

    @org.junit.jupiter.api.Test
    void getRate() {
        Assertions.assertEquals(0,values.getRate(), "");
    }
}