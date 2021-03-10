package com.epam.rd.java.basic.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Range for Task 4.
 */
public class Range implements Iterable<Integer> {
    int n;
    int m;
    boolean reverse;

    public Range(int n, int m) {
        this(n, m, false);
    }

    public Range(int n, int m, boolean reverse) {
        if (n > m) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.m = m;
        this.reverse = reverse;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator();
    }

    private class RangeIterator implements Iterator<Integer> {
        private int counter;

        RangeIterator() {
            counter = reverse ? (m + 1) : (n - 1);
        }

        @Override
        public boolean hasNext() {
            return reverse ? (counter > n) : (counter < m);
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return reverse ? (--counter) : (++counter);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
