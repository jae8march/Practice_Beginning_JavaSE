package com.epam.rd.java.basic.practice6.part4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class RangeTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfPlaceIndexIsOutOfRange () {
        try {
            Range range = new Range(10, 3);
            fail("Expected IllegalArgumentException");
            fail(" Throw Exception If Place Index Is Out Of Range ");
        } catch (IllegalArgumentException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void shouldReturnRangeIncreased() {
        String expected = "8 7 6 ";
        Range range = new Range(6, 8, true);
        StringBuilder actual = new StringBuilder();
        for (Integer el : range) {
            actual.append(el).append(" ");
        }
        assertEquals(expected, actual.toString());
    }

    @Test
    public void shouldReturnRangeDecreased() {
        String expected = "6 7 8 ";
        Range range = new Range(6, 8);
        StringBuilder actual = new StringBuilder();
        for (Integer el : range) {
            actual.append(el).append(" ");
        }
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testMain() {
        PrintStream old=System.out;
        Part4 p4 = new Part4();
        System.setOut(new PrintStream(output));
        p4.main(null);
        String expected = "6 7 8 " + System.lineSeparator() +
                "10 9 8 7 6 5 4 3 " + System.lineSeparator();
        Assert.assertEquals(output.toString(),expected);
        System.setOut(old);
    }
}
