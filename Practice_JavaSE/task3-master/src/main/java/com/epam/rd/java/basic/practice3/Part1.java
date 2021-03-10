package com.epam.rd.java.basic.practice3;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Task 1.
 */
public class Part1 {
    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");
        System.out.print("\tmethod convert1:" + System.lineSeparator() + convert1(input) + System.lineSeparator());
        System.out.print("\tmethod convert2:" + System.lineSeparator() + convert2(input) + System.lineSeparator());
        System.out.print("\tmethod convert3:" + System.lineSeparator() + convert3(input) + System.lineSeparator());
        System.out.print("\tmethod convert4:" + System.lineSeparator() + convert4(input));
    }

    /**
     * @param input data
     * @return a string
     */
    public static String convert1(String input) {
        String[] text = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < text.length; i++) {
            String[] a = text[i].split(";");
            sb.append(a[0] + ": " + a[2] + System.lineSeparator());
        }
        return sb.toString();
    }

    /**
     * @param input data
     * @return string
     */
    public static String convert2(String input) {
        String[] text = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < text.length; i++) {
            String[] a = text[i].split("[\\s\\;]");
            sb.append(a[2] + " " + a[1] + " (email: " + a[3] + ")" + System.lineSeparator());
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * @param input data
     * @return string
     */
    public static String convert3(String input) {
        Pattern pattern = Pattern.compile("^?(.+;)(.+;)(.+)(@.+)");
        Matcher matcher = pattern.matcher(input);
        StringBuilder str = new StringBuilder();
        str.append(" ");
        while (matcher.find()) {
            Pattern p2 = Pattern.compile(matcher.group(4).substring(1));
            Matcher m2 = p2.matcher(str);
            if (!m2.find()) {
                str.append(System.lineSeparator() + matcher.group(4).substring(1) + " ==> "
                        + matcher.group(1).substring(0, matcher.group(1).length() - 1));
            } else {
                Pattern p3 = Pattern.compile(matcher.group(4).substring(1) + ".+");
                Matcher m3 = p3.matcher(str);
                m3.find();
                str.insert(m3.end(), ", " + matcher.group(1).substring(0, matcher.group(1).length() - 1));
            }
        }
        str.append(System.lineSeparator());
        return str.substring(2);
    }

    /**
     * @param input data
     * @return string
     */
    public static String convert4(String input) {
        final int MAX = 10000;
        final int MIN = 1000;
        SecureRandom rand = new SecureRandom();
        String[] text = input.split(System.lineSeparator());
        StringBuilder sb = new StringBuilder();
        sb.append(text[0] + ";Password" + System.lineSeparator());
        for (int i = 1; i < text.length; i++) {
            int random = rand.nextInt(MAX);
            while (random < MIN) {
                random = rand.nextInt(MAX);
            }
            sb.append(text[i] + ";" + random + System.lineSeparator());

        }
        return sb.toString();
    }
}
