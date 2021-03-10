package com.epam.rd.java.basic.practice7;

import com.epam.rd.java.basic.practice7.constants.Constants;
import com.epam.rd.java.basic.practice7.controller.DOM;
import com.epam.rd.java.basic.practice7.controller.SAX;
import com.epam.rd.java.basic.practice7.controller.STAX;
import com.epam.rd.java.basic.practice7.entity.CandySort;
import com.epam.rd.java.basic.practice7.util.Sorter;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException, XMLStreamException {
        if (args.length != 1) {
            System.out.println("java com.epam.rd.java.basic.practice7.Main xmlFileName");
            return;
        }

        String xmlFileName = args[0];

        DOM dom = new DOM(xmlFileName);
        dom.parse(true);
        CandySort candySort = dom.getCandySort();
        Sorter.sortByName(candySort);
        DOM.saveToXML(candySort, Constants.OUTPUT_DOM_XML_FILE);

        SAX sax = new SAX(xmlFileName);
        sax.parse(true);
        candySort = sax.getCandySort();
        Sorter.sortByEnergy(candySort);
        DOM.saveToXML(candySort, Constants.OUTPUT_SAX_XML_FILE);

        STAX stax = new STAX(xmlFileName);
        stax.parse();
        candySort = stax.getCandySort();
        Sorter.sortByProduction(candySort);
        DOM.saveToXML(candySort, Constants.OUTPUT_STAX_XML_FILE);
    }
}
