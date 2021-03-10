package com.epam.rd.java.basic.practice5;

/**
 Task 1.
 */
public class Part1 {
    private static final String SEPARATOR = System.lineSeparator();

    public static void main(String[] args) {
        Thread fw = new FirstWay();
        Thread sw = new Thread(new SecondWay());

        try {
            fw.start();
            fw.join(1000);
            fw.interrupt();

            sw.start();
            sw.join(1000);
            sw.interrupt();
        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt();
        }
    }

    static class FirstWay extends Thread {
        @Override
        public void run() {
            Thread.currentThread().setName("firstWay");

            for (int i = 0; i < 4; i++) {
                System.out.print(Thread.currentThread().getName() + SEPARATOR);
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class SecondWay implements Runnable {
        @Override
        public void run() {
            Thread.currentThread().setName("secondWay");
            for (int i = 0; i < 4; i++) {
                System.out.print(Thread.currentThread().getName() + SEPARATOR);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println(e);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
