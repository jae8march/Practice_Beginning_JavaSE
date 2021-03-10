package com.epam.rd.java.basic.practice6.part1;

/**
 * Class Word for Task 1.
 */
public class Word implements Comparable {
    private final String wor;
    private int frequency;

    public Word(String word) {
        this.wor = word;
        this.frequency = 1;
    }

    public void increment() {
        frequency++;
    }

    @Override
    public int compareTo(Object o) {
        Word w = (Word) o;
        if (w.frequency == frequency) {
            return wor.compareTo(w.wor);
        } else {
            return w.frequency - frequency;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Word) {
            Word wo = (Word) obj;
            return wor.equals(wo.wor);
        } else {
            return equals(obj);
        }
    }

    @Override
    public int hashCode(){
        final int PRIME = 30;
        int result = 1;
        result = PRIME * result;
        return result;
    }

    @Override
    public String toString() {
        return wor + " : " + frequency;
    }
}
