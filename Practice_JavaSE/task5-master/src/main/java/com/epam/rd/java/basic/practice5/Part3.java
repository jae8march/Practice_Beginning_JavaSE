package com.epam.rd.java.basic.practice5;

/**
 * Task 3.
 */
public class Part3 {
    private int counter;
    private int counter2;
    private final int numberOfIterations;
    private final Thread[] threads;

    static Part3 p3 = new Part3(2, 5);

    public Part3(int numberOfThreads, int numberOfIterations) {
        this.threads = new Thread[numberOfThreads];
        this.numberOfIterations = numberOfIterations;
    }

    public static void main(final String[] args) {
        p3.compare();
        p3.reset();
        p3.compareSync();
        Thread.currentThread().interrupt();
    }

    public void compare() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new CompareExt();
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.err.println(e);
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Class for creating unsynchronized threads.
     */
    public class CompareExt extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < numberOfIterations; i++) {
                print();
            }
        }
    }

    public void compareSync() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new CompareSyncExt();
            threads[i].start();
        }
    }

    /**
     * Class for creating synchronized threads.
     */
    public class CompareSyncExt extends Thread {
        @Override
        public void run() {
            synchronized (Part3.this) {
                for (int i = 0; i < numberOfIterations; i++) {
                    print();
                }
            }
        }
    }

    public void print() {
        System.out.print(counter + " = " + counter2 + System.lineSeparator());
        try {
            setCounter(getCounter() + 1);
            int sleep = 100;
            Thread.sleep(sleep);
            setCounter2(getCounter2() + 1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void reset() {
        counter = 0;
        counter2 = 0;
    }

    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
    public int getCounter2() {
        return counter2;
    }
    public void setCounter2(int counter2) {
        this.counter2 = counter2;
    }
}