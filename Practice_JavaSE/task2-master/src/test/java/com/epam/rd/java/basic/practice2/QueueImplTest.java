package com.epam.rd.java.basic.practice2;
import static org.junit.Assert.*;

import org.junit.Test;

public class QueueImplTest {
    private QueueImpl queue = new QueueImpl();
    private void init(){
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue(null);
    }

    @Test
    public void shouldDequeueFromTheHead_IfEmpty(){
        assertNull(queue.dequeue());
    }

    @Test
    public void shouldReturnQueueSize(){
        init();
        assertEquals("[A, B, C, null]", queue.toString());
        assertEquals(4, queue.size());
    }

    @Test
    public void shouldEnqueueToTheTail(){
        init();
        queue.enqueue("D");
        assertEquals("[A, B, C, null, D]", queue.toString());
        assertEquals(5, queue.size());
        System.out.println("dddddddddddddddddddddddddd");

    }
    @Test
    public void shouldReturnHead(){
        init();
        assertEquals("A", queue.top());
        assertEquals(4, queue.size());
        System.out.println("dddddddddddddddddddddddddd");

    }

    @Test
    public void forEachTest(){
        init();
        StringBuilder result = new StringBuilder();
        for (Object element: queue) {
            result.append(element);
        }
        assertEquals("ABCnull", result.toString());
        System.out.println("dddddddddddddddddddddddddd");

    }

    @Test
    public void toStringTest(){
        init();
        assertEquals("[A, B, C, null]", queue.toString());
    }

    @Test
    public void shouldDequeueFromTheHead(){
        init();
        assertEquals("A", queue.dequeue());
        assertEquals(3, queue.size());
        assertEquals("[B, C, null]", queue.toString());
    }

    @Test
    public void shouldClearQueue(){
        init();
        queue.clear();
        assertNull(queue.dequeue());
        assertNull(queue.top());
        assertEquals(0, queue.size());
        assertEquals("[]", queue.toString());

    }
}
