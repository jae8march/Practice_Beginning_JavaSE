package com.epam.rd.java.basic.practice3;

import static org.junit.Assert.*;

public class Part2Test {
    @org.junit.Test
    public void convertTest() {
        Part2 p2 = new Part2();
        String actual = p2.convert("When I was younger, so much younger than today\n" +
                "I never needed anybody's help in any way\n" +
                "But now these days are gone, I'm not so self-assured\n" +
                "Now I find I've changed my mind\n" +
                "I've opened up the doors");
        String expected = "Min: I, s, m\nMax: younger, anybody, assured, changed";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void getMaxTest() {
        Part2 p2 = new Part2();
        String actual = p2.getMax("When I was younger, so much younger than today\n" +
                "I never needed anybody's help in any way\n" +
                "But now these days are gone, I'm not so self-assured\n" +
                "Now I find I've changed my mind\n" +
                "I've opened up the doors");
        String expected = "Max: younger, anybody, assured, changed";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void getMinTest() {
        Part2 p2 = new Part2();
        String actual = p2.getMin("When I was younger, so much younger than today\n" +
                "I never needed anybody's help in any way\n" +
                "But now these days are gone, I'm not so self-assured\n" +
                "Now I find I've changed my mind\n" +
                "I've opened up the doors");
        String expected = "Min: I, s, m";
        assertEquals(expected, actual);
    }
}
