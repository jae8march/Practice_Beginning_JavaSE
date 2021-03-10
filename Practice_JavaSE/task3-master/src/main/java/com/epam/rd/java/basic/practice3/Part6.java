package com.epam.rd.java.basic.practice3;

import java.util.regex.Pattern;

/**
 * Task 6. The input data uploaded from the "part6.txt" file.
 */
public class Part6 {
    public static void main(String[] args) {
        String input = Util.getInput("part6.txt");
        System.out.print("\tTest method convert:\n" + convert(input) + "\n");
    }

    /**
     * @param input text
     * @return the original text, but all the recurring words should be preceded by underscore "_"
     */
    public static String convert(String input) {
        Pattern pattern = Pattern.compile("(\\b\\w+\\b)(?=[\\s\\S]*\\b\\1\\b[\\s\\S]*\\b\\1\\b)",
                Pattern.UNICODE_CHARACTER_CLASS);
        String result = pattern.matcher(input + " " + input).replaceAll("_$1");
        result = result.substring(0, result.length() - 1 - pattern.matcher(input).replaceAll("_$1").length());

        return result;
    }
}
