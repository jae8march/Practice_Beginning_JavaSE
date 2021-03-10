package com.epam.rd.java.basic.practice7.constants;

public enum XML {
    CANDY("Candy"), CANDYSORT("CandySort"), NAME("Name"), ENERGY("Energy"),
    INGREDIENTS("Ingredients"), WATER("Water"), SUGAR("Sugar"), FRUCTOSE("Fructose"),
    CHOCOLATETYPE("Chocolatetype"), VANILLA("Vanilla"), PRODUCTION("Production");

    private final String value;

    XML(String value) { this.value = value; }

    public boolean equalsTo(String name) { return value.equals(name); }
    public String value() { return value; }
}
