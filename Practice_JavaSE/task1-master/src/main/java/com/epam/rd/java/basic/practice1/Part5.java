package com.epam.rd.java.basic.practice1;

/**
 * The class implements the functionality of defining the sum of the digits of a whole positive number
 * passed to the application as the command line parameter.
 */
public class Part5 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int sum = 0;

        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        System.out.print(sum);
    }
}
