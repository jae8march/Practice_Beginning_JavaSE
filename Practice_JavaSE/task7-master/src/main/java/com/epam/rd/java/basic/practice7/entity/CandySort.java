package com.epam.rd.java.basic.practice7.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "candySort"
})
@XmlRootElement(name = "CandySort")
public class CandySort {
    @XmlElement(name = "Candy", required = true)
    protected List<Candy> cSort;

    public List<Candy> getCandySort() {
        if (cSort == null) {
            cSort = new ArrayList<>();
        }
        return this.cSort;
    }
}
