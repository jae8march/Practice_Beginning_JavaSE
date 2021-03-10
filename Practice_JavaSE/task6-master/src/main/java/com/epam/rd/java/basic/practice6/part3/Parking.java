package com.epam.rd.java.basic.practice6.part3;

import java.util.ArrayList;

/**
 * Class Parking for Task 3.
 */
public class Parking {
    private ArrayList<Integer> park = new ArrayList<>();

    public Parking(int n) {
        for (int i = 0; i < n; i++) {
            park.add(0);
        }
    }

    public boolean arrive(int k) {
        if (k < 0 || k > (park.size() - 1)) {
            throw new IllegalArgumentException(" IllegalArgumentException exception, k < 0 or k > (n - 1) ");
        }
        for (int j = k; j < park.size(); j++){
            if (park.get(j) == 0) {
                park.set(j, 1);
                return true;
            }
        }
        for (int i = 0; i < k; i++) {
            if (park.get(i) == 0) {
                park.set(i, 1);
                return true;
            }
        }
        return false;
    }

    public boolean depart(int k) {
        if (k < 0 || k > (park.size() - 1)) {
            throw new IllegalArgumentException(" IllegalArgumentException exception, k < 0 or k > (n - 1) ");
        }
        if (park.get(k) == 1) {
            park.set(k, 0);
            return true;
        }
        return false;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int o : park) {
            sb.append(o);
        }
        System.out.println(sb.toString());
    }
}
