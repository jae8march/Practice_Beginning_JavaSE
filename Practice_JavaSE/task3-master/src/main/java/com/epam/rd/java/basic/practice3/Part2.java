package com.epam.rd.java.basic.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Task 2. The input data uploaded from the "part2.txt" file.
 */
public class Part2 {
    public static void main(String[] args) {
        String input = Util.getInput("part2.txt");
        System.out.print("\tTest method convert:\n" + convert(input));
    }

    /**
     * @param input data
     * @return words of the minimum length and the maximum length in the singular,
     * minding the order of their occurrence in the text and considering the character case.
     */
    public static String convert(String input) {
        return getMin(input) + System.lineSeparator() + getMax(input);
    }

    /**
     * @param input data
     * @return words the minimum length in the singular
     */
    public static String getMin(String input) {
        StringBuilder min = new StringBuilder();
        Pattern pattern1 = Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher1 = pattern1.matcher(input);
        int count = Integer.MAX_VALUE;

        min.append("Min: ");
        while (matcher1.find()) {
            Pattern pattern2 = Pattern.compile(matcher1.group());
            Matcher matcher2 = pattern2.matcher(min.substring(5));

            if (count > matcher1.group().length()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Min: ");
                count = matcher1.group().length();
                sb2.append(matcher1.group());
                min = sb2;
            } else if (count == matcher1.group().length() && !(matcher2.find())) {
                min.append(", ").append(matcher1.group());
            }
        }
        return min.toString();
    }

    /**
     * @param input data
     * @return words the maximum length in the singular
     */
    public static String getMax(String input) {
        StringBuilder max = new StringBuilder();
        Pattern pattern1 = Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher1 = pattern1.matcher(input);
        int count = 0;

        max.append("Max: ");
        while (matcher1.find()) {
            Pattern pattern2 = Pattern.compile(matcher1.group());
            Matcher matcher2 = pattern2.matcher(max.substring(5));

            if (count < matcher1.group().length()) {
                StringBuilder str = new StringBuilder();
                str.append("Max: ");
                count = matcher1.group().length();
                str.append(matcher1.group());
                max = str;
            } else if (count == matcher1.group().length() && !(matcher2.find())) {
                max.append(", ").append(matcher1.group());
            }
        }
        return max.toString();
    }
}
