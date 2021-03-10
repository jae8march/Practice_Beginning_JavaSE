package com.epam.rd.java.basic.practice6.part1;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class WordContainerTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Test
    public void hashCodeTest() {
        Word x = new Word("W");
        Word y = new Word("W");
        assertTrue(x.equals(y) && y.equals(x));
        assertTrue(x.hashCode() == y.hashCode());
    }

    @Test
    public void equalsTest() {
        Word x = new Word("W");
        Word y = new Word("WW");
        assertFalse(x.equals(y) && y.equals(x));
    }

    @Test
    public void shouldSortEqualDuplicateCountWordsLexicographically() {
        String input = "asd asd asd a a a stop";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String expected = "a : 3" + System.lineSeparator() +
                "asd : 3";
        String actual = WordContainer.getWord();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortWordsByDuplicateCount() {
        String input = "A A A C C C C B B stop";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String expected = "C : 4" + System.lineSeparator() +
                "A : 3" + System.lineSeparator() +
                "B : 2";
        String actual = WordContainer.getWord();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPrintCorrectResult() {
        String input = "asd 43 asdf asd 43\n" +
                "434 asdf \n" +
                "kasdf asdf asdf\n" +
                "stop";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String expected = "asdf : 4" + System.lineSeparator() +
                "43 : 2" + System.lineSeparator() +
                "asd : 2" + System.lineSeparator() +
                "434 : 1" + System.lineSeparator() +
                "kasdf : 1";
        String actual = WordContainer.getWord();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldIgnoreWordsAfterStop() {
        String input = "asd 43 asdf asd 43\n" +
                "434 asdf \n" +
                "stop asdf asdf\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String expected = "43 : 2" + System.lineSeparator() +
                "asd : 2" + System.lineSeparator() +
                "asdf : 2" + System.lineSeparator() +
                "434 : 1";
        String actual = WordContainer.getWord();
        assertEquals(expected, actual);
    }
}


