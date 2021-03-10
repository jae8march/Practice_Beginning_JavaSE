package com.epam.rd.java.basic.practice1;

/**
 * The class implements the functionality of displaying of the command line parameters
 * in console (display using a space between them), the result doesn't end with a space.
 */
public class Part3 {
    public static void main (String[] args) {
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg + " ");
        }
        System.out.print(sb.toString().trim());
    }
}
