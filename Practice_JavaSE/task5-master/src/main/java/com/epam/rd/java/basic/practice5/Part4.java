package com.epam.rd.java.basic.practice5;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Task 4.
 */
public class Part4 {
    private static final String SEPARATOR = System.lineSeparator();
    private static final int ROWS = 4;
    private static final int SIZE = 100;
    private static final int[][] matrix = new int[ROWS][SIZE];
    private static long timeOut;

    public static void main(String[] args) {
        getInput("part4.txt");
        run();
    }

    public static void getInput(String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < SIZE; ++j) {
                    if (scanner.hasNextInt()) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
            }
            scanner.close();
        } catch (IOException ex) {
            //catch-block
        }
        matrix.clone();
    }

    public static void run() {
        int[] temp = threads();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.out.println(e);
            Thread.currentThread().interrupt();
        }
        Arrays.sort(temp);
        System.out.print(temp[ROWS - 1] + SEPARATOR + timeOut + SEPARATOR);
        oneThread();
    }

    public static int[] threads() {
        final int[] temp = new int[ROWS];

        for (int i = 0; i < ROWS; i++) {
            final int count = i;

            Thread myThread = new Thread(() -> {
                long time = System.currentTimeMillis();
                temp[count] = max(matrix[count]);
                time = System.currentTimeMillis() - time;
                if (timeOut < time) {
                    timeOut = time;
                }
            });
            myThread.start();
        }
        return temp;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            try {
                Thread.sleep(1);
                if (arr[i] > max) {
                    max = arr[i];
                }
            } catch (InterruptedException e) {
                System.out.println(e);
                Thread.currentThread().interrupt();
            }
        }
        return max;
    }

    public static void oneThread() {
        long time = System.currentTimeMillis();
        int max = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    Thread.sleep(1);
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                    }
                } catch (InterruptedException e) {
                    System.out.println(e);
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.print(max + SEPARATOR + (System.currentTimeMillis() - time) + SEPARATOR);
    }
}
