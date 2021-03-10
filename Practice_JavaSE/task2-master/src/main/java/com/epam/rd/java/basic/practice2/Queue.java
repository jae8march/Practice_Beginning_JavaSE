package com.epam.rd.java.basic.practice2;

/**
 * Task 3. Create Queue interface.
 */
public interface Queue extends Container {
    /**
     * Appends the specified element to the end.
     * @param element
     */
    void enqueue(Object element);

    /**
     * Removes the head.
     * @return the head
     */
    Object dequeue();

    /**
     * @return the head
     */
    Object top();
}
