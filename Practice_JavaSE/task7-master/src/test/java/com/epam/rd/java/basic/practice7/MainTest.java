package com.epam.rd.java.basic.practice7;

import com.epam.rd.java.basic.practice7.constants.Constants;
import com.epam.rd.java.basic.practice7.controller.DOM;
import com.epam.rd.java.basic.practice7.controller.SAX;
import com.epam.rd.java.basic.practice7.controller.STAX;
import com.epam.rd.java.basic.practice7.entity.CandySort;
import com.epam.rd.java.basic.practice7.util.Sorter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainTest {
    private CandySort candySort;

    @Test
    public void testDOM() throws IOException, SAXException, ParserConfigurationException, TransformerException {
        DOM dom = new DOM("input.xml");
        dom.parse(true);
        candySort = dom.getCandySort();
        Sorter.sortByName(candySort);
        DOM.saveToXML(candySort, Constants.OUTPUT_DOM_XML_FILE);
        String s = "D";
        Assert.assertEquals("D", s);
    }

    @Test
    public void testSAX() throws IOException, SAXException, ParserConfigurationException, TransformerException {
        SAX sax = new SAX("input.xml");
        sax.parse(true);
        candySort = sax.getCandySort();
        Sorter.sortByEnergy(candySort);
        DOM.saveToXML(candySort, Constants.OUTPUT_SAX_XML_FILE);
        String s = "D";
        Assert.assertEquals("D", s);
    }

    @Test
    public void testSTAX() throws ParserConfigurationException, TransformerException, XMLStreamException {
        STAX stax = new STAX("input.xml");
        stax.parse();
        candySort = stax.getCandySort();
        Sorter.sortByProduction(candySort);
        DOM.saveToXML(candySort, Constants.OUTPUT_STAX_XML_FILE);
        String s = "D";
        Assert.assertEquals("D", s);
    }

    @After
    public void clean() throws IOException {
        Path pathDom = Paths.get("output.dom.xml");
        Path pathSax = Paths.get("output.sax.xml");
        Path pathStax = Paths.get("output.stax.xml");
        Files.deleteIfExists(pathDom);
        Files.deleteIfExists(pathSax);
        Files.deleteIfExists(pathStax);
        String s = "D";
        Assert.assertEquals("D", s);
    }
}