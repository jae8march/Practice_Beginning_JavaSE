package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

/**
 * Task 0. Create Container interface.
 */
public interface Container extends Iterable<Object> {
    /**
     * Removes all of the elements.
     */
    void clear();

    /**
     * @return the number of elements
     */
    int size();

    /**
     * @return a string representation of this container
     */
    String toString();

    /**
     * @return an iterator over elements. Iterator must implements the remove method
     */
    Iterator<Object> iterator();
 
}
