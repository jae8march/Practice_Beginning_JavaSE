package com.epam.rd.java.basic.practice7.controller;

import com.epam.rd.java.basic.practice7.constants.XML;
import com.epam.rd.java.basic.practice7.entity.Candy;
import com.epam.rd.java.basic.practice7.entity.CandySort;
import com.epam.rd.java.basic.practice7.constants.Constants;
import com.epam.rd.java.basic.practice7.entity.Chocolatetype;
import com.epam.rd.java.basic.practice7.entity.Ingredients;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class DOM {

    private final String xmlFileName;
    private CandySort candySort;

    public DOM(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public CandySort getCandySort() {
        return candySort;
    }

    public void parse(boolean val) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        dbf.setNamespaceAware(true);

        if(val){
            dbf.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
            dbf.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }

        DocumentBuilder db = dbf.newDocumentBuilder();
        db.setErrorHandler(new DefaultHandler(){
            @Override
            public void error(SAXParseException e) throws SAXException {
                throw e;
            }
        });

        Document doc = db.parse(xmlFileName);
        Element root = doc.getDocumentElement();
        candySort = new CandySort();
        NodeList candySortNodes = root.getElementsByTagName(XML.CANDY.value());
        for(int i=0; i<candySortNodes.getLength(); ++i){
            Candy candy = getCandy(candySortNodes.item(i));
            candySort.getCandySort().add(candy);
        }
    }

    private Candy getCandy(Node candyNode) {
        Candy candy = new Candy();
        Element gElement = (Element) candyNode;

        Node nameNode = gElement.getElementsByTagName(XML.NAME.value()).item(0);
        candy.setName(nameNode.getTextContent());


        Node energyNode = gElement.getElementsByTagName(XML.ENERGY.value()).item(0);
        candy.setEnergy(energyNode.getTextContent());

        Node chocolatetypeNode = gElement.getElementsByTagName(XML.CHOCOLATETYPE.value()).item(0);
        candy.setChocolatetype(Chocolatetype.fromValue(chocolatetypeNode.getTextContent()));

        Node productionNode = gElement.getElementsByTagName(XML.PRODUCTION.value()).item(0);
        candy.setProduction(productionNode.getTextContent());

        Node ingredientsNode = gElement.getElementsByTagName(XML.INGREDIENTS.value()).item(0);
        candy.setIngredients(getIngredients(ingredientsNode));

        return candy;
    }

    private Ingredients getIngredients(Node ingredientsNode){
        Ingredients ingredients = new Ingredients();
        Element iElement = (Element) ingredientsNode;

        Node waterNode = iElement.getElementsByTagName(XML.WATER.value()).item(0);
        ingredients.setWater(Integer.parseInt(waterNode.getTextContent()));

        Node sugarNode = iElement.getElementsByTagName(XML.SUGAR.value()).item(0);
        ingredients.setSugar(Integer.parseInt(sugarNode.getTextContent()));

        Node fructoseNode = iElement.getElementsByTagName(XML.FRUCTOSE.value()).item(0);
        ingredients.setFructose(Integer.parseInt(fructoseNode.getTextContent()));

        Node vanillaNode = iElement.getElementsByTagName(XML.VANILLA.value()).item(0);
        ingredients.setVanilla(Integer.parseInt(vanillaNode.getTextContent()));

        return ingredients;
    }

    public static Document getDocument(CandySort candySort) throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        dbf.setNamespaceAware(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();

        Element element = document.createElement(XML.CANDYSORT.value());
        document.appendChild(element);

        for(Candy candy : candySort.getCandySort()){
            Element gElement = document.createElement(XML.CANDY.value());
            element.appendChild(gElement);

            Element nameElement = document.createElement(XML.NAME.value());
            nameElement.setTextContent(candy.getName());
            gElement.appendChild(nameElement);

            Element energyElement = document.createElement(XML.ENERGY.value());
            energyElement.setTextContent(candy.getEnergy());
            gElement.appendChild(energyElement);

            Element chocolatetypeElement = document.createElement(XML.CHOCOLATETYPE.value());
            chocolatetypeElement.setTextContent(candy.getChocolatetype().value());
            gElement.appendChild(chocolatetypeElement);

            Element productionElement = document.createElement(XML.PRODUCTION.value());
            productionElement.setTextContent(candy.getProduction());
            gElement.appendChild(productionElement);

            Element ingredientsElement = document.createElement(XML.INGREDIENTS.value());
            gElement.appendChild(ingredientsElement);

            Element waterElement = document.createElement(XML.WATER.value());
            waterElement.setTextContent(String.valueOf(candy.getIngredients().getWater()));
            ingredientsElement.appendChild(waterElement);

            Element sugarElement = document.createElement(XML.SUGAR.value());
            sugarElement.setTextContent(String.valueOf(candy.getIngredients().getSugar()));
            ingredientsElement.appendChild(sugarElement);

            Element fructoseElement = document.createElement(XML.FRUCTOSE.value());
            fructoseElement.setTextContent(String.valueOf(candy.getIngredients().getFructose()));
            ingredientsElement.appendChild(fructoseElement);

            Element vanillaElement = document.createElement(XML.VANILLA.value());
            vanillaElement.setTextContent(String.valueOf(candy.getIngredients().getVanilla()));
            ingredientsElement.appendChild(vanillaElement);
        }
        return document;
    }

    public static void saveToXML(CandySort candySort, String xmlFileName) throws ParserConfigurationException, TransformerException {
        saveToXML(getDocument(candySort), xmlFileName);
    }

    public static void saveToXML(Document document, String xmlFileName) throws TransformerException {
        StreamResult result = new StreamResult(new File(xmlFileName));

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        transformer.transform(new DOMSource(document), result);
    }
}
