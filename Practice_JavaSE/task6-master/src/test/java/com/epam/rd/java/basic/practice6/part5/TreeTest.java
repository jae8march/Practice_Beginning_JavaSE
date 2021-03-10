package com.epam.rd.java.basic.practice6.part5;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TreeTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    @Test
    public void shouldAddElement() {
        Tree<Integer> tree = new Tree<>();
        assertTrue(tree.add(1));
    }

    @Test
    public void shouldReturnFalseWhenAddingADuplicate() {
        Tree<Integer> tree = new Tree<>();
        tree.add(1);
        assertFalse(tree.add(1));
    }

    @Test
    public void shouldAddElementToTree_Array() {
        Tree<Integer> tree = new Tree<>();
        tree.add(new Integer[] { 2, 5, 4, 6, 0 });
        assertTrue(tree.add(1));
    }

    @Test
    public void shouldPrintWithTreeStructure() {
        PrintStream old = System.out;
        Tree<Integer> tree = new Tree<>();
        tree.add(new Integer[] { 3, 7, 1, 8, 6, 2, 5 });

        System.setOut(new PrintStream(output));
        tree.print();
        String expected = "  1" + System.lineSeparator() +
                "    2" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "      5" + System.lineSeparator() +
                "    6" + System.lineSeparator() +
                "  7" + System.lineSeparator() +
                "    8" + System.lineSeparator();
        assertEquals(output.toString(), expected);
        System.setOut(old);
    }

    @Test
    public void shouldNotAddRepeatedElement () {
        PrintStream old = System.out;
        Tree<Integer> tree = new Tree<>();
        tree.add(3);        tree.add(3);
        tree.add(7);        tree.add(7);
        tree.add(1);
        tree.add(8);
        tree.add(6);        tree.add(6);
        tree.add(2);
        tree.add(5);

        System.setOut(new PrintStream(output));
        tree.print();
        String expected = "  1" + System.lineSeparator() +
                "    2" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "      5" + System.lineSeparator() +
                "    6" + System.lineSeparator() +
                "  7" + System.lineSeparator() +
                "    8" + System.lineSeparator();
        assertEquals(output.toString(), expected);
        System.setOut(old);
    }

    @Test
    public void shouldRemoveExistedElement () {
        Tree<Integer> tree = new Tree<>();
        tree.add(1);
        assertTrue(tree.remove(1));
    }

    @Test
    public void shouldReturnFalse_IfRemoveUnexistedElement () {
        Tree<Integer> tree = new Tree<>();
        assertFalse(tree.remove(1));
    }

    @Test
    public void shouldReturnFalse_IfRemoveUnexistedElement_PrintTree () {
        PrintStream old = System.out;
        Tree<Integer> tree = new Tree<>();
        tree.add(new Integer[] { 3, 7, 1, 8, 6, 2, 5 });
        tree.remove(20);

        System.setOut(new PrintStream(output));
        tree.print();
        String expected = "  1" + System.lineSeparator() +
                "    2" + System.lineSeparator() +
                "3" + System.lineSeparator() +
                "      5" + System.lineSeparator() +
                "    6" + System.lineSeparator() +
                "  7" + System.lineSeparator() +
                "    8" + System.lineSeparator();
        assertEquals(output.toString(), expected);
        System.setOut(old);
    }

}
