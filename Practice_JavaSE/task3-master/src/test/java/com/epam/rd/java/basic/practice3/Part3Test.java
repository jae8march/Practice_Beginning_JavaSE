package com.epam.rd.java.basic.practice3;

import static org.junit.Assert.*;

public class Part3Test {
    @org.junit.Test
    public void testConvertMethodForSecretInputData(){
        Part3 p3 = new Part3();
        String actual = p3.convert("When I was younger\n" +
                "I never needed\n" +
                "when I Was Younger\n" +
                "I Never Needed");
        String expected = "when I Was Younger\n" +
                "I Never Needed\n" +
                "When I was younger\n" +
                "I never needed";
        assertEquals(expected, actual);
    }
}