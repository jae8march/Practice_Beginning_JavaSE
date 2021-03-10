package com.epam.rd.java.basic.practice2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ArrayImplTest {
private ArrayImpl array  = new ArrayImpl(4);

    private void init(){
    	
        array.add("A");
        array.add("B");
        array.add("C");
        array.add(null);
    }



    @Test
    public void shouldReturnArraySize() {
        init();
        assertEquals(4, array.size());
    }

    @Test
    public void shouldAddWithoutArrayExtension() {
        array = new ArrayImpl(4);
        try {
            array.add("A");
            array.add("B");
            array.add("C");
            array.add(null);
        } catch (java.util.NoSuchElementException e) {
            fail();
        }
    }

    @Test
    public void shouldGetByIndex() {
        init();
        assertEquals("A", array.get(0));
        assertEquals("B", array.get(1));
        assertEquals("C", array.get(2));
        assertEquals(null, array.get(3));
    }

    @Test
    public void shouldRemoveByIndex() {
        init();
        array.remove(0);
        assertEquals("[B, C, null]", array.toString());
        assertEquals(3, array.size());
        array.remove(2);
        assertEquals("[B, C]", array.toString());
        assertEquals(2, array.size());
    }

    @Test
    public void forEachTest() {
        init();
        StringBuilder result = new StringBuilder();
        for (Object element: array) {
            result.append(element);
        }
        assertEquals("ABCnull", result.toString());
    }

    @Test
    public void toStringTest() {
        init();
        assertEquals("[A, B, C, null]", array.toString());
    }

    @Test
    public void shouldSetByIndex() {
        init();
        array.set(0, null);
        array.set(1, "C");
        array.set(2, "B");
        array.set(3, "A");
        assertEquals("[null, C, B, A]", array.toString());
        assertEquals(3, array.indexOf("A"));
        assertEquals(2, array.indexOf("B"));
        assertEquals(1, array.indexOf("C"));
        assertEquals(0, array.indexOf(null));
    }

    @Test
    public void shouldClearArray() {
        init();
        array.clear();
        assertEquals("[]", array.toString());
        assertEquals(0, array.size());
    }

    @Test
    public void shouldReturnIndexOf() {
        init();
        assertEquals("[A, B, C, null]", array.toString());
        assertEquals(0, array.indexOf("A"));
        assertEquals(1, array.indexOf("B"));
        assertEquals(2, array.indexOf("C"));
        assertEquals(3, array.indexOf(null));
    }

    @Test
    public void ShouldReturnElementFromTheFirstPosition() {
        init();
        assertEquals("[A, B, C, null]", array.toString());
        assertEquals("A", array.get(0));
    }
}
