package com.epam.rd.java.basic.practice1;

/**
 * The class implements the functionality of defining the greatest common divisor of two whole positive numbers
 * passed to the application as the command line parameters.
 */
public class Part4 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        System.out.print(a + b);
    }
}
