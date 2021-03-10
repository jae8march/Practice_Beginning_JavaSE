package com.epam.rd.java.basic.practice7;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public final class Demo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException, XMLStreamException {
        Main.main(new String[] { "input.xml" });
    }
}
