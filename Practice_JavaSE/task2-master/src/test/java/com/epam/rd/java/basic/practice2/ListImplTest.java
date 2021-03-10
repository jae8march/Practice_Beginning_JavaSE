package com.epam.rd.java.basic.practice2;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

public class ListImplTest {
    private ListImpl list = new ListImpl();
    private void init(){
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast(null);
    }

    @Test
    public void ShouldSearchElementByValue_IfDoesNotExist(){
        assertNull(list.search("A")
        );
    }

    @Test
    public void ShouldSearchElementByValue_IfExists(){
        init();
        assertEquals("[A, B, C, null]", list.toString());
        assertEquals("A",list.search("A"));
    }

    @Test
    public void shouldReturnListSize(){
        init();
        assertEquals("[A, B, C, null]", list.toString());
        assertEquals(4,list.size());
    }

    @Test
    public void ShouldAddElementToTheLastPosition(){
        init();
        list.addLast("D");
        assertEquals("[A, B, C, null, D]", list.toString());
        assertEquals(5, list.size());
    }

    @Test
    public void forEachTest(){
        init();
        StringBuilder result = new StringBuilder();
        for (Object element: list) {
            result.append(element);
        }
        assertEquals("ABCnull", result.toString());
    }

    @Test
    public void ShouldRemoveElementByValue_IfDoesNotExist(){
        init();
        list.remove("Z");
        assertEquals("[A, B, C, null]", list.toString());
        assertEquals(4, list.size());
    }

    @Test
    public void ShouldRemoveElementByValue_IfExists(){
        init();
        list.remove("A");
        assertEquals("[B, C, null]", list.toString());
        assertEquals(3, list.size());
    }

    @Test
    public void toStringTest(){
        init();
        assertEquals("[A, B, C, null]", list.toString());
    }

    @Test
    public void ShouldRemoveElementByValue_IfIsNull(){
        init();
        list.remove(null);
        assertEquals("[A, B, C]", list.toString());
        assertEquals(3, list.size());
    }

    @Test
    public void ShouldRemoveElementFromTheLastPosition(){
        init();
        list.removeLast();
        assertEquals("[A, B, C]", list.toString());
        assertEquals(3, list.size());
    }

    @Test
    public void shouldClearList_getFirst_getLastMustReturnNull(){
        init();
        list.clear();
        assertNull(list.getFirst());
        assertNull(list.getLast());
        assertEquals(0, list.size());
    }

    @Test
    public void ShouldRemoveElementFromTheFirstPosition(){
        init();
        list.removeFirst();
        assertEquals("[B, C, null]", list.toString());
        assertEquals(3, list.size());
    }

    @Test
    public void ShouldAddElementToTheFirstPosition(){
        init();
        list.addFirst("Z");
        assertEquals("[Z, A, B, C, null]", list.toString());
        assertEquals(5, list.size());
    }

    @Test
    public void ShouldReturnElementFromTheFirstPosition(){
        init();
        assertEquals("A",list.getFirst());
    }

    @Test
    public void ShouldReturnElementFromTheLastPosition(){
        init();
        assertNull(list.getLast());
    }

}
