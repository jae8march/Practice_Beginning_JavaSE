package com.epam.rd.java.basic.practice1;

/**
 * Class implements functionality of addition of numbers passed to the application as the command line parameters.
 */
public class Part2 {
    public static void main (String[] args) {
        int sum = 0;

        for (String arg : args) {
            sum += Integer.parseInt(arg);
        }
        System.out.print(sum);
    }
}
