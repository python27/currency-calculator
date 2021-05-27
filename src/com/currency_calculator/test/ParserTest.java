package com.currency_calculator.test;

import com.currency_calculator.main.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void parsing() {
        Parser parser = new Parser();
        Assertions.assertEquals("USD", parser.parsing().get(0).getCurrency(), "Pierwszą w kolejności walutą musi być USD");
    }
}