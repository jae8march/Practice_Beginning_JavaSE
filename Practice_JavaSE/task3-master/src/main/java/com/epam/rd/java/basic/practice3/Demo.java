package com.epam.rd.java.basic.practice3;

import java.security.NoSuchAlgorithmException;

/**
 * Practical task #3. The Demo class, demonstrating the actions of all the written functionality.
 */
public class Demo {
    private static final String SEPARATOR = "***************************************";
    private static final String TAB = "\n\t\t\t\t";
    private static final String TEXTFROM = "\n\tText from file part";
    private static final String TEXT = ".txt";
    private static final String PART = "Part";

    public static void main(String[] args) {
        for (int i = 1; i < 7; i++) {
            System.out.print(System.lineSeparator() + SEPARATOR);
            switch(i) {
                case (1):
                    System.out.print(TAB + PART + i + TEXTFROM + i + TEXT);
                    Part1.main(args);
                    break;
                case (2):
                    System.out.print(TAB + PART + i + TEXTFROM + i + TEXT);
                    Part2.main(args);
                    break;
                case (3):
                    System.out.print(TAB + PART + i + TEXTFROM + i + TEXT);
                    Part3.main(args);
                    break;
                case (4):
                    System.out.print(TAB + PART + i);
                    try {
                        Part4.main(args);
                    } catch (NoSuchAlgorithmException e) {
                        //do something
                    }
                    break;
                case (5):
                    System.out.print(TAB + PART + i);
                    Part5.main(args);
                    break;
                case (6):
                    System.out.print(TAB + PART + i + TEXTFROM + i + TEXT);
                    Part6.main(args);
                    break;
                default:
                    System.out.print("This line is never displayed, but it's here because EMentor demands default block. So I did it.");
            }
        }
    }
}