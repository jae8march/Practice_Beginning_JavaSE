package com.epam.rd.java.basic.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Class in a loop reads the key and the localization name from the console and, in response,
 * prints out the corresponding value to the console. The sign of the input end is the word 'stop'.
 */
public class Part5 {
    private static final String LS = System.lineSeparator();
    private static final String ENCODING = "CP1251";
    private static final String FILE = "resources";

    public static void main(String[] args) {
        Locale locale;
        ResourceBundle bundle;

        Scanner sc = new Scanner(System.in, ENCODING);
        StringBuilder str = new StringBuilder(sc.nextLine());

        while (!str.toString().equals("stop")){
            String[] arr = str.toString().split(" ");
            locale = new Locale(arr[1]);
            bundle = ResourceBundle.getBundle(FILE, locale);
            System.out.print(bundle.getString(arr[0]) + LS);

            str.delete(0, str.length());
            str.append(sc.nextLine());
        }
    }
}
