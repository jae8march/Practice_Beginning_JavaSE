package com.epam.rd.java.basic.practice1;

/**
 * Columns of spreadsheets (like Excel) have letter numbering in the form of latin capital letters
 * (sequentially, from left to right): A, B, ..., Y, Z, AA, AB, ..., AY, AZ, BA, BB, …, etc.
 * At the same time, each column has its sequence number: A - 1; B - 2; ... ; Y - 25; Z - 26; AA - 27; AB - 28; …, etc.
 * The class contains three methods that find data by incoming parameters.
 */
public class Part7 {
    private static final int ENG = 26;
    private static final int START = 64;
    private static final String ARROW = " ==> ";

    /**
     * The method of defining the column sequence number by its letter number.
     * @param number - column letter.
     * @return the column sequence number.
     */
    public static int str2int (String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            char sym = number.charAt(i);
            sum += (int) Math.pow(ENG, (double) number.length() - 1 - i) * (sym - START);
        }
        sum += Math.pow(ENG, 0) - 1;
        return sum;
    }

    /**
     * The method of defining the column letter number by its sequence number.
     * @param number - the column sequence number.
     * @return the column letter.
     */
    public static String int2str (int number) {
        String chr = "";
        String chr2 = "";
        int sym;
        while (number != 0) {
            sym = number % ENG;
            if (sym == 0) {
                chr += "Z";
                number = (number - 1) / ENG;
            } else {
                chr += (char) (sym + START);
                number = (number - sym) / ENG;
            }
        }
        for (int i = 0; i < chr.length(); i++) {
            chr2 += chr.charAt(chr.length() - i - 1);
        }
        return chr2;
    }

    /**
     * Using the column letter number, write a method of defining the number of the column
     * that is placed on the right side of the given one.
     * @param number the column letter.
     * @return the next letter of the column.
     */
    public static String rightColumn (String number) {
        return int2str(str2int(number) + 1);
    }

    /**
     * The methods,{@link #str2int(String number)} and {@link #int2str (int number),
     * functionality is checked using the following data.
     */
    public static void main(String[] args) {
        String[] letter = new String[]{"A", "B", "Z", "AA", "AZ", "BA", "ZZ", "AAA"};
        int[] number = new int[]{1, 2, 26, 27, 52, 53, 702, 703};
        for (int i = 0; i < letter.length; i++) {
            System.out.print(letter[i] + ARROW + str2int(letter[i]) + ARROW + int2str(number[i]) + "\n");
        }
    }
}
