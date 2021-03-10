package com.epam.rd.java.basic.practice3;

import static org.junit.Assert.*;

public class Part5Test {
    @org.junit.Test
    public void decimal2RomanTest() {
        Part5 p5 = new Part5();
        String actual = p5.decimal2Roman(25);
        String expected = "XXV";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void roman2DecimalTest() {
        Part5 p5 = new Part5();
        int actual = p5.roman2Decimal("XXVIII");
        int expected = 28;
        assertEquals(expected, actual);
    }
}