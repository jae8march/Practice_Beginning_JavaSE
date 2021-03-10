package com.epam.rd.java.basic.practice7.entity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class ChocolatetypeTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void addTest() {
        assertEquals("DARK", Chocolatetype.DARK.toString());
    }

    @Test
    public void valueTest() {
        assertEquals("dark", Chocolatetype.DARK.value());
    }

    @Test
    public void fromValueTest_Exception() {
        try {
            Chocolatetype.fromValue("DARK");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
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