package com.epam.rd.java.basic.practice3;

/**
 * Task 5.
 */
public class Part5 {
    private static final String[] ROMAN = new String[] { "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    private static final int[] DECIMAL = new int[] { 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " --> " + decimal2Roman(i) + " --> " + roman2Decimal(decimal2Roman(i)) 
                    + System.lineSeparator());
        }
    }

    /**
     * @param dec arabic numeral
     * @return roman numeral
     */
    public static String decimal2Roman(int dec) {
        final StringBuilder s = new StringBuilder();

        for (int i = 0; i < ROMAN.length; i++) {
            while (dec >= DECIMAL[i]) {
                s.append(ROMAN[i]);
                dec -= DECIMAL[i];
            }
        }
        return s.toString();
    }

    /**
     * @param roman numeral
     * @return arabic numeral
     */
    public static int roman2Decimal(String roman) {
        final StringBuilder str = new StringBuilder(roman);
        int decimal = 0;
        int number = 0;

        while (str.length() != 0) {
            if (str.indexOf(ROMAN[number]) == 0) {
                decimal += DECIMAL[number];
                str.delete(0, ROMAN[number].length());
                continue;
            }
            number++;
        }
        return decimal;
    }
}
