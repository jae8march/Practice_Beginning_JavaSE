package com.epam.rd.java.basic.practice6.part2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Task 2.
 */
public class Part2 {
    private static final int N = 10000;
    private static final int K = 4;
    private static final String ARRAY_LIST = "ArrayList";

    private static List<Integer> array;
    private static List<Integer> node;

    public static void main(String[] args) {
        fillData(ARRAY_LIST);
        fillData("LinkedList");

        System.out.println("ArrayList#Index: " + removeByIndex(array, K) + " ms");
        System.out.println("LinkedList#Index: " + removeByIndex(node, K) + " ms");
        System.out.println("ArrayList#Iterator: " + removeByIterator(array, K) + " ms");
        System.out.println("LinkedList#Iterator: " + removeByIterator(node, K) + " ms");
    }

    public static List<Integer> fillData(String str) {
        if (str.equals(ARRAY_LIST)) {
            array = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                array.add(i);
            }
        } else {
            node = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                node.add(i);
            }
        }
        return (str.equals(ARRAY_LIST) ? new ArrayList<>(array) : new LinkedList<>(node));
    }

    public static long removeByIndex(List<Integer> list, int k) {
        long time = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; (i <= list.size() - 1) || (list.size() == 1); i++) {
            count += k - 1;
            while (count >= list.size()) {
                count -= list.size();
            }
            list.remove(count);
        }
        return System.currentTimeMillis() - time;
    }

    public static long removeByIterator(List<Integer> list, int k) {
        long time = System.currentTimeMillis();
        int count = 0;
        Iterator<Integer> iter = list.iterator();
        while (list.size() > 1 ) {
            if (iter.hasNext()) {
                iter.next();
                count++;
                if (count == k) {
                    iter.remove();
                    count = 0;
                }
            } else {
                iter = list.iterator();
            }
        }
        return System.currentTimeMillis() - time;
    }
}
