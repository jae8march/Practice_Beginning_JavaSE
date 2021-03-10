package com.epam.rd.java.basic.practice7.entity;

import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class CandyTest {
    final Candy pj = new Candy();

    @Test
    public void testSetter_name() {
        pj.setName("Q");
        assertEquals("Q", pj.getName());
    }

    @Test
    public void testSetter_energy() {
        pj.setEnergy("A");
        assertEquals("A", pj.getEnergy());
    }

    @Test
    public void testSetter_production() {
        pj.setProduction("W");
        assertEquals("W", pj.getProduction());
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