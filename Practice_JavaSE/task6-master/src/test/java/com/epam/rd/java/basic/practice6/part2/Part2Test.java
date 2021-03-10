package com.epam.rd.java.basic.practice6.part2;

import org.junit.Test;
import static org.junit.Assert.*;

public class Part2Test {
    static final int K = 4;

    @Test
    public void removeByIndexArrayListShouldBeFasterAtLeastFourTimesThanLinkedList () {
        long arr = Part2.removeByIndex(Part2.fillData("ArrayList"), K);
        long nod = Part2.removeByIndex(Part2.fillData("LinkedList"), K);
        boolean actual = arr <= nod;
        assertTrue(actual);
    }

    @Test
    public void removeByIteratorLinkedListShouldBeFasterInMostCasesThanArrayList  () {
        long arr = Part2.removeByIterator(Part2.fillData("ArrayList"), K);
        long nod = Part2.removeByIterator(Part2.fillData("LinkedList"), K);
        boolean actual = arr >= nod;
        assertTrue(actual);
    }
}
