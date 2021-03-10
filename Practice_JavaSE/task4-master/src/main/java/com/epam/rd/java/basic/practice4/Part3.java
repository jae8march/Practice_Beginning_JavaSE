package com.epam.rd.java.basic.practice4;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class has the following functionality: in a loop, a user enters the data type
 * (one of them: char, int, double, String), in response, the application prints out to the console all the values of
 * the corresponding types that exist in the file. If a user enters the word 'stop',
 * then the application exits the loop. In other cases "Incorrect input" should be printed.
 */
public class Part3 {
    private static final String LS = System.lineSeparator();

    public static void main(String[] args) {
        getType();
    }

    public static void getType() {
        HashMap<String, String> regex = new HashMap<>();
        regex.put("INT", "(?<![-.])(\\b[0-9]+\\b)(?!\\.[0-9])");
        regex.put("DOUBLE", "(\\.\\d\\d|\\d+\\.\\d+|\\d+\\.)");
        regex.put("CHAR", "\\b(\\p{L})\\1*\\b");
        regex.put("STRING", "\\b\\p{L}{2,}\\b");
        boolean flag = true;

        Scanner sc = new Scanner(System.in);
        String type;
        while (flag) {
            type = sc.nextLine();
            if (regex.containsKey(type.toUpperCase())) {
                System.out.print(Part3.getData(regex.get(type.toUpperCase())) + LS);
            } else if ("stop".equalsIgnoreCase(type)) {
                flag = false;
            } else {
                System.out.print("Incorrect input" + LS);
            }
        }
        sc.close();
    }

    public static String getData(String regex) {
        String input = Demo.getInput("part3.txt");
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            sb.append(matcher.group()).append(" ");
        }
        return sb.toString();
    }
}
