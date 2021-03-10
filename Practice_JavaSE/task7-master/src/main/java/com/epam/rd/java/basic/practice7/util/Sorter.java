package com.epam.rd.java.basic.practice7.util;
import com.epam.rd.java.basic.practice7.entity.Candy;
import com.epam.rd.java.basic.practice7.entity.CandySort;

import java.util.Collections;
import java.util.Comparator;

public class Sorter {
    private Sorter(){}

    public static final Comparator<Candy> SORT_BY_NAME =
            Comparator.comparing(Candy::getName);

    public static final Comparator<Candy> SORT_BY_ENERGY =
            Comparator.comparing(Candy::getEnergy);

    public static final Comparator<Candy> SORT_BY_PRODUCTION =
            Comparator.comparing(Candy::getProduction);

    public static void sortByName(CandySort candySort){
        Collections.sort(candySort.getCandySort(), SORT_BY_NAME);
    }

    public static void sortByEnergy(CandySort candySort){
        Collections.sort(candySort.getCandySort(), SORT_BY_ENERGY);
    }

    public static void sortByProduction(CandySort candySort){
        Collections.sort(candySort.getCandySort(), SORT_BY_PRODUCTION);
    }
}
