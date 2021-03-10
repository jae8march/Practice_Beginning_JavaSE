package com.epam.rd.java.basic.practice7.entity;

import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class IngredientsTest {
    final Ingredients pj = new Ingredients();

    @Test
    public void testSetter_fructose() {
        pj.setFructose(5);
        assertEquals(5, pj.getFructose());
    }

    @Test
    public void testSetter_sugar() {
        pj.setSugar(4);
        assertEquals(4, pj.getSugar());
    }

    @Test
    public void testSetter_vanilla() {
        pj.setVanilla(35);
        assertEquals(35, pj.getVanilla());
    }

    @Test
    public void testSetter_water() {
        pj.setWater(12);
        assertEquals(12, pj.getWater());
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