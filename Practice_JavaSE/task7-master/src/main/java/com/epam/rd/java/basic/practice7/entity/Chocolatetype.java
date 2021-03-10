package com.epam.rd.java.basic.practice7.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Chocolatetype")
@XmlEnum
public enum Chocolatetype {
    @XmlEnumValue("dark")
    DARK("dark"),
    @XmlEnumValue("white")
    WHITE("white"),
    @XmlEnumValue("milk")
    MILK("milk");

    private final String value;

    Chocolatetype(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Chocolatetype fromValue(String v) {
        for (Chocolatetype c: Chocolatetype.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
