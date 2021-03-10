package com.epam.rd.java.basic.practice7.constants;

import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class XMLTest {
    @Test
    public void addTest() {
        assertEquals("CANDY", XML.CANDY.toString());
    }

    @Test
    public void equalsToTest() {
        assertTrue(XML.CANDY.equalsTo("Candy"));
    }

    @Test
    public void valueTest() {
        assertEquals("Candy", XML.CANDY.value());
    }

    @After
    public void clean() throws IOException {
        Path pathDom = Paths.get("output.dom.xml");
        Path pathSax = Paths.get("output.sax.xml");
        Path pathStax = Paths.get("output.stax.xml");
        Files.deleteIfExists(pathDom);
        Files.deleteIfExists(pathSax);
        Files.deleteIfExists(pathStax);
    }
}