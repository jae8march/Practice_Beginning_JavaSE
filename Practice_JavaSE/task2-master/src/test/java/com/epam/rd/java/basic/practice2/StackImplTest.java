package com.epam.rd.java.basic.practice2;
import static org.junit.Assert.*;

import org.junit.Test;

public class StackImplTest {
  private StackImpl stack = new StackImpl();


    private void init(){
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push(null);
    }

    @Test
    public void shouldReturnStackSize(){
        init();
        assertEquals("[A, B, C, null]", stack.toString());
        assertEquals(4, stack.size());
    }

    @Test
    public void shouldReturnTail(){
        init();
        assertEquals(4, stack.size());
        assertEquals(null, stack.top());
    }

    @Test
    public void shouldPopFromTheTail_IfEmpty(){
        assertNull(stack.top());
    }

    @Test
    public void forEachTest(){
        init();
        StringBuilder result = new StringBuilder();
        for (Object element: stack) {
            result.append(element);
        }
        assertEquals("nullCBA", result.toString());
    }

    @Test
    public void toStringTest(){
        init();
        assertEquals("[A, B, C, null]", stack.toString());
    }

    @Test
    public void shouldPushToTheTail(){
        init();
        stack.push("D");
        assertEquals("[A, B, C, null, D]", stack.toString());
    }

    @Test
    public void shouldPopFromTheTail(){
        init();
        assertNull(stack.pop());
        assertEquals("[A, B, C]", stack.toString());
    }

    @Test
    public void shouldClearStack(){
        init();
        stack.clear();
        assertNull(stack.pop());
        assertNull(stack.top());
        assertEquals("[]", stack.toString());
        assertEquals(0, stack.size());
    }
}
