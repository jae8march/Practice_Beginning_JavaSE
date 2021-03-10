package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Paths;

import java.security.SecureRandom;

import java.util.Arrays;
import java.util.Scanner;

import static com.epam.rd.java.basic.practice4.Demo.readFile;

/**
 * Class creates and fills the file 'part2.txt' with random whole numbers from 0 to 50 (10 numbers),
 * then reads the file and writes its content to the other file (part2_sorted.txt) having sorted the numbers
 * in the ascending order. After displays the content of both files in the console.
 */
public class Part2 {
    private static final String LS = System.lineSeparator();
    public static final String ENCODING = "Cp1251";
    private static final String FILE = "part2.txt";
    private static final String NEW_FILE = "part2_sorted.txt";

    public static void main(String[] args) {
            Part2 part2 = new Part2();
            part2.newRandom();
            System.out.print("input ==> ");
            readFile(FILE);
            System.out.print(LS);

            System.out.print("output ==> ");
            part2.sortAndWriteFile();
            readFile(NEW_FILE);
            System.out.print(LS);
    }

    public void newRandom() {
        int[] array = new int[10];
        int rand;
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            rand = random.nextInt(50) + 1;
            array[i] = rand;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(array[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        try (FileWriter write = new FileWriter(FILE)) {
            write.write(sb.toString());
        } catch (IOException e) {
            //catch-block
        }
    }

    public void sortAndWriteFile() {
        Heapsort hp = new Heapsort();

        Scanner scanner;
        try {
            scanner = new Scanner(Paths.get(FILE), ENCODING);
            String data = scanner.useDelimiter("$").next();
            scanner.close();
            File file = new File(NEW_FILE);
            try (FileWriter fw = new FileWriter(file)) {
                fw.write(hp.sort(data));
                fw.flush();
            }
        } catch (IOException e) {
            //catch-block
        }
    }

    private class Heapsort {
        private int heapSize;

        public String sort(String str) {
            int[] array = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            heapSize = array.length;
            buildHeap(array);
            while (heapSize > 1) {
                swap(array, 0, heapSize - 1);
                heapSize--;
                heapify(array, 0);
            }
            return getString(array);
        }
        private void buildHeap(int[] array) {
            heapSize = array.length;
            for (int i = array.length / 2; i >= 0; i--) {
                heapify(array, i);
            }
        }

        private void heapify(int[] array, int i) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int largest = i;
            if (l < heapSize && array[i] < array[l]) {
                largest = l;
            }
            if (r < heapSize && array[largest] < array[r]) {
                largest = r;
            }
            if (i != largest) {
                swap(array, i, largest);
                heapify(array, largest);
            }
        }

        private void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        public String getString(int[] array) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                str.append(array[i]).append(" ");
            }
            return str.deleteCharAt(str.length() - 1).toString();
        }
    }
}
