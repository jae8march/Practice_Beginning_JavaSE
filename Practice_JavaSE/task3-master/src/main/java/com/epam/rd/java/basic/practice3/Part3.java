package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Task 3. The input data should be uploaded from the "part3.txt" file.
 */
public class Part3 {
    public static void main(String[] args) {
        String input = Util.getInput("part3.txt");
        System.out.print("\tTest method convert:\n" + convert(input));
    }

    /**
     * @param input text
     * @return the original text, but the case of the first character of each word,
     * that consists of three or more characters, inverted
     */
    public static String convert(String input) {
        StringBuilder str = new StringBuilder(input);
        Pattern pattern = Pattern.compile("(([A-ZА-Я])[a-zA-Zа-яА-Я]{2,})|(([a-zа-я])[a-za-zA-Zа-яА-Я]{2,})");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            if (matcher.group(4) != null) {
                str.replace(matcher.start(), matcher.start() + 1, matcher.group().substring(0, 1).toUpperCase());
            } else if (matcher.group(2) != null) {
                str.replace(matcher.start(), matcher.start() + 1, matcher.group().substring(0, 1).toLowerCase());
            }
        }
        return str.toString();
    }
}

