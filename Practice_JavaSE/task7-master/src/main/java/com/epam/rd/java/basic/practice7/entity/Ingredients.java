package com.epam.rd.java.basic.practice7.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ingredients", propOrder = {
        "water",
        "sugar",
        "fructose",
        "vanilla"
})
public class Ingredients {
    @XmlElement(name = "Water", required = true)
    protected int water;
    @XmlElement(name = "Sugar", required = true)
    protected int sugar;
    @XmlElement(name = "Fructose", required = true)
    protected int fructose;
    @XmlElement(name = "Vanilla", required = true)
    protected int vanilla;

    public int getFructose() {
        return fructose;
    }
    public void setFructose(int fructose) {
        this.fructose = fructose;
    }

    public int getSugar() {
        return sugar;
    }
    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getVanilla() {
        return vanilla;
    }
    public void setVanilla(int vanilla) {
        this.vanilla = vanilla;
    }

    public int getWater() {
        return water;
    }
    public void setWater(int water) {
        this.water = water;
    }
}