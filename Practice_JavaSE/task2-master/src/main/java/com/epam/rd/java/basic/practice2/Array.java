package com.epam.rd.java.basic.practice2;

/**
 * Task 1. Create Array interface.
 */
public interface Array extends Container {
    /**
     * Add the specified element to the end.
     * @param element
     */
    void add(Object element);

    /**
     * Sets the element at the specified position.
     * @param index the specified position
     * @param element
     */
    void set(int index, Object element);

    /**
     * @param index the specified position.
     * @return the element at the specified position
     */
    Object get(int index);

    /**
     * @param element
     * @return the index of the first occurrence of the specified element,
     * or -1 if this array does not contain the element
     */
    int indexOf(Object element);

    /**
     * Removes the element at the specified position.
     * @param index the specified position
     */
    void remove(int index);
}
