package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class displays the content of the text file to console, deleting the first two characters of each word
 * with the length of 4 and more characters.
 */
public class Part1 {
    public static final String ENCODING = "Cp1251";

    public static void main(String[] args) {
        try {
            convert("part1.txt");
        } catch (IOException e) {
            //catch-block
        }
    }

    public static String convert(String file) throws IOException {
        StringBuilder sb = new StringBuilder();
        String regex = "([\\p{L}]+)[^\\p{L}]+";
        Pattern pattern = Pattern.compile(regex);
        try (Scanner scanner = new Scanner(new File(file), ENCODING)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine() + System.lineSeparator();

                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String block = matcher.group();
                    String word = block.replaceAll(regex, "$1");
                    sb.append((word.length() >= 4 ? block.substring(2) : block));
                }
            }
        } catch (IOException ex) {
            //catch-block
        }
        writeFile(file, sb.toString());
        System.out.println(sb.toString().replaceAll("\\r", "").trim());
        return regex;
    }

    public static void writeFile(String file, String str) {
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(str);
            writer.flush();
        } catch (IOException e) {
            //catch-block
        }
    }
}
