package com.epam.rd.java.basic.practice1;

/**
 * The class demonstrates the actions of all the 7 subtasks{@link Part1}, {@link Part2},
 * {@link Part3}, {@link Part4}, {@link Part5}, {@link Part6}, {@link Part7}.
 */
public class Demo {
    private static final String SEPARATOR = "======";
    public static void main(String[] args) {
        System.out.print(SEPARATOR + "part1" + System.lineSeparator());
        Part1.main(args);
        System.out.print(SEPARATOR + "part2" + System.lineSeparator());
        Part2.main(new String[]{"5", "6", "4"});
        System.out.print(SEPARATOR + "part3" + System.lineSeparator());
        Part3.main(new String[]{"a", "4", "aa", "b", "-", " ", "!1Rq0!"});
        System.out.print(SEPARATOR + "part4" + System.lineSeparator());
        Part4.main(new String[]{"5", "6"});
        System.out.print(SEPARATOR + "part5" + System.lineSeparator());
        Part5.main(new String[]{"123454321"});
        System.out.print(SEPARATOR + "part6" + System.lineSeparator());
        Part6.main(new String[]{"15"});
        System.out.print(SEPARATOR + "part7" + System.lineSeparator());
        Part7.main(args);
    }
}
