package com.epam.rd.java.basic.practice7.controller;

import com.epam.rd.java.basic.practice7.constants.XML;
import com.epam.rd.java.basic.practice7.entity.Candy;
import com.epam.rd.java.basic.practice7.entity.CandySort;
import com.epam.rd.java.basic.practice7.entity.Chocolatetype;
import com.epam.rd.java.basic.practice7.entity.Ingredients;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.helpers.DefaultHandler;

public class STAX extends DefaultHandler{
    private final String xmlFileName;
    private final CandySort candySort = new CandySort();

    public CandySort getCandySort() {
        return candySort;
    }

    public STAX(String xmlFileName) { this.xmlFileName = xmlFileName; }

    public void parse() throws XMLStreamException {
        Candy candy = null;
        Ingredients ingredients = null;

        String currentElement = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);
        XMLEventReader reader = factory.createXMLEventReader(new StreamSource(xmlFileName));

        while (reader.hasNext()){
            XMLEvent event = reader.nextEvent();
            if (event.isCharacters() && event.asCharacters().isWhiteSpace()) {
                continue;
            }

            if(event.isStartElement()){
                StartElement startElement = event.asStartElement();
                currentElement = startElement.getName().getLocalPart();

                if(XML.CANDY.equalsTo(currentElement)){
                    candy = new Candy();
                }
                if(XML.INGREDIENTS.equalsTo(currentElement)){
                    ingredients = new Ingredients();
                }
            }

            if(event.isCharacters()){
                Characters characters = event.asCharacters();

                if(XML.NAME.equalsTo(currentElement)){
                    candy.setName(characters.getData());
                }
                if(XML.ENERGY.equalsTo(currentElement)){
                    candy.setEnergy(characters.getData());
                }
                if(XML.CHOCOLATETYPE.equalsTo(currentElement)){
                    candy.setChocolatetype(Chocolatetype.fromValue(characters.getData()));
                }
                if(XML.PRODUCTION.equalsTo(currentElement)){
                    candy.setProduction(characters.getData());
                }
                if (XML.WATER.equalsTo(currentElement)){
                    ingredients.setWater(Integer.parseInt(characters.getData()));
                }
                if (XML.SUGAR.equalsTo(currentElement)){
                    ingredients.setSugar(Integer.parseInt(characters.getData()));
                }
                if (XML.FRUCTOSE.equalsTo(currentElement)){
                    ingredients.setFructose(Integer.parseInt(characters.getData()));
                }
                if (XML.VANILLA.equalsTo(currentElement)){
                    ingredients.setVanilla(Integer.parseInt(characters.getData()));
                }
            }

            if(event.isEndElement()){
                EndElement endElement = event.asEndElement();
                String localName = endElement.getName().getLocalPart();

                if(XML.CANDY.equalsTo(localName)){
                    candySort.getCandySort().add(candy);
                }
                if(XML.INGREDIENTS.equalsTo(localName)){
                    candy.setIngredients(ingredients);
                }
            }
        }
        reader.close();
    }
}
