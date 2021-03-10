package com.epam.rd.java.basic.practice3;

import static org.junit.Assert.*;

public class Part1Test {
    String input = Util.getInput("part1.txt");

    @org.junit.Test
    public void convert1Test() {
        Part1 p1 = new Part1();
        String actual = p1.convert1(input);
        String expected = "ivanov: ivanov@mail.com\n" +
                "петров: petrov@google.com\n" +
                "obama: obama@google.com\n" +
                "bush: bush@mail.com";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void convert2Test() {
        Part1 p1 = new Part1();
        String actual = p1.convert2(input);
        String expected = "Ivanov Ivan (email: ivanov@mail.com)\n" +
                "Петров Петр (email: petrov@google.com)\n" +
                "Obama Barack (email: obama@google.com)\n" +
                "Буш Джордж (email: bush@mail.com)";
        assertEquals(expected, actual);
    }
}
