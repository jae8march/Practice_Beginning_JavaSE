package com.epam.rd.java.basic.practice4;

import java.io.*;

import java.util.Scanner;

/**
 * It's demo class.
 */
public class Demo {
    private static final String LS = System.lineSeparator();
    private static final String ENCODING = "Cp1251";

    public static void main(String[] args) {
        System.out.print("It's just works." + LS);
    }

    public static String readFile(String file) {
        String str = null;
        try (FileReader fr = new FileReader(file)){
            try (BufferedReader br = new BufferedReader(fr)) {
                str = br.readLine();
                while (str != null) {
                    System.out.print(str);
                    str = br.readLine();
                }
            }
        } catch (IOException e) {
            //catch-block
        }
        return str;
    }

    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        System.setProperty("console.encoding", ENCODING);
        try {
            Scanner scanner = new Scanner(new File(fileName), ENCODING);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return sb.toString();
    }

}