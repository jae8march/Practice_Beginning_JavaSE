package com.epam.rd.java.basic.practice7.controller;

import com.epam.rd.java.basic.practice7.constants.Constants;
import com.epam.rd.java.basic.practice7.constants.XML;
import com.epam.rd.java.basic.practice7.entity.Candy;
import com.epam.rd.java.basic.practice7.entity.CandySort;
import com.epam.rd.java.basic.practice7.entity.Chocolatetype;
import com.epam.rd.java.basic.practice7.entity.Ingredients;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAX extends DefaultHandler {

    private final String xmlFileName;
    private String currentElement;

    private CandySort candySort;
    private Candy candy;
    private Ingredients ingredients;

    public SAX(String xmlFileName) { this.xmlFileName = xmlFileName; }

    public void parse(boolean validate) throws SAXException, ParserConfigurationException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        factory.setNamespaceAware(true);
        if(validate){
            factory.setFeature(Constants.FEATURE_TURN_VALIDATION_ON,true);
            factory.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON,true);
        }
            factory.newSAXParser().parse(xmlFileName, this);
    }


    @Override
    public void error(SAXParseException e) throws SAXException {
        throw e;
    }
    public CandySort getCandySort() {
        return candySort;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = localName;
        if(XML.CANDYSORT.equalsTo(currentElement)){
            candySort = new CandySort();
            return;
        }
        if(XML.CANDY.equalsTo(currentElement)){
            candy = new Candy();
            return;
        }
        if(XML.INGREDIENTS.equalsTo(currentElement)){
            ingredients = new Ingredients();
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) {
        String elementText = new String(ch,start,length).trim();
        if(elementText.isEmpty()) return;

        if(XML.CHOCOLATETYPE.equalsTo(currentElement)){
            candy.setChocolatetype(Chocolatetype.fromValue(elementText));
            return;
        }
        if(XML.NAME.equalsTo(currentElement)) {
            candy.setName(elementText);
            return;
        }
        if(XML.ENERGY.equalsTo(currentElement)){
            candy.setEnergy(elementText);
            return;
        }
        if(XML.PRODUCTION.equalsTo(currentElement)){
            candy.setProduction(elementText);
            return;
        }
        if(XML.WATER.equalsTo(currentElement)){
            ingredients.setWater(Integer.parseInt(elementText));
            return;
        }
        if(XML.SUGAR.equalsTo(currentElement)){
            ingredients.setSugar(Integer.parseInt(elementText));
            return;
        }
        if(XML.FRUCTOSE.equalsTo(currentElement)){
            ingredients.setFructose(Integer.parseInt(elementText));
            return;
        }
        if(XML.VANILLA.equalsTo(currentElement)){
            ingredients.setVanilla(Integer.parseInt(elementText));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if(XML.CANDY.equalsTo(localName)){
            candySort.getCandySort().add(candy);
            return;
        }
        if(XML.INGREDIENTS.equalsTo(localName)){
            candy.setIngredients(ingredients);
        }
    }
}
