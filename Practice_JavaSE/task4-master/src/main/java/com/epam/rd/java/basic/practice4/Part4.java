package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implements interface java.lang.Iterable<String>. The class parse the text file and return sentences.
 * The input data uploaded from the 'part4.txt' file.
 */
public class Part4 {
    private static final String LS = System.lineSeparator();

    public static void main(String[] args) {
        EpamKruto epamKruto;
        epamKruto = new EpamKruto(new File("part4.txt"));
        for (String str : epamKruto) {
            System.out.print(str + LS);
        }
    }

    static class EpamKruto implements Iterable<String> {
        private Matcher matcher;
        private static final String REGEX = "\\p{javaUpperCase}.*?\\.";

        public EpamKruto(File file) {
            StringBuilder sb = new StringBuilder();
            try {
                final Scanner scanner = new Scanner(file, "Cp1251");
                while (scanner.hasNextLine()) {
                    sb.append(scanner.nextLine()).append(" ").append(LS);
                    sb.delete(sb.length() - 1, sb.length());
                    Pattern p = Pattern.compile(REGEX);
                    setMatcher(p.matcher(sb));
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.getMessage();
            }
        }

        @Override
        public Iterator<String> iterator() {
            return new EpamKrutoIterator(getMatcher());
        }

        private class EpamKrutoIterator implements Iterator<String> {
            public EpamKrutoIterator(Matcher matcher) {
                setMatcher(matcher);
            }

            @Override
            public boolean hasNext() {
                return getMatcher().find();
            }

            @Override
            public String next() {
                try {
                    return getMatcher().group();
                } catch (NoSuchElementException e) {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public final Matcher getMatcher() {
            return matcher;
        }
        public final void setMatcher(Matcher matcher) {
            this.matcher = matcher;
        }
    }
}
