package com.epam.rd.java.basic.practice4;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The file contains words written with Cyrillic and Latin letters.
 * Class reads the user input from console and in response prints out all specific words from the file.
 * 1 - If user enters "cyrl" then all words with Russian or Ukrainian symbols are printed.
 * 2 - If user enters "latn" then all words with Latin set of symbols are printed.
 * 3 - If a user enters the word "stop" then the application quits.
 * 4 - In other cases program prints "Incorrect input".
 */
public final class Part6 {
    private static boolean flag = true;
    private static final String LS = System.lineSeparator();
    private static final String FILE = "part6.txt";

    public static void main(String[] args) {
        HashMap<String, String> regex = new HashMap<>();
        regex.put("latn", "[A-Za-z]+");
        regex.put("cyrl", "[\\p{IsCyrillic}]+");

        Scanner sc = new Scanner(System.in);
        String type;
        while (flag) {
            type = sc.nextLine();
            if (regex.containsKey(type.toLowerCase())) {
                System.out.print(Part6.input(regex.get(type.toLowerCase()), type.toLowerCase()) + LS);
            } else if ("stop".equalsIgnoreCase(type)) {
                flag = false;
            } else {
                System.out.print(type + ": Incorrect input" + LS);
            }
        }
        sc.close();
    }

    public static String input(String regex, final String key) {
        String input = Demo.readFile(FILE);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        StringBuilder sb = new StringBuilder();
        sb.append(key).append(": ");
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        while (matcher.find()) {
            sb.append(matcher.group()).append(" ");
        }
        return sb.toString().trim();
    }
}