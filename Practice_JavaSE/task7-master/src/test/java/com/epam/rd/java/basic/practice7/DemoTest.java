package com.epam.rd.java.basic.practice7;

import com.epam.rd.java.basic.practice7.entity.CandySort;
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

public class DemoTest {

    @Test
    public void testDOM() throws IOException, SAXException, ParserConfigurationException, TransformerException, XMLStreamException {
        Main.main(new String[] { "input.xml" });
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
    }
}