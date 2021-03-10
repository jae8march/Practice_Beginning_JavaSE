package com.epam.rd.java.basic.practice6.part3;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ParkingTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionIfPlaceIndexIsOutOfRangeWhenCallingArrive () {
        try {
            Parking parking = new Parking(4);
            parking.arrive(5);
            fail("Expected IllegalArgumentException");
            fail(" Throw Exception If Place Index Is Out Of Range ");
        } catch (IllegalArgumentException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void shouldThrowExceptionIfPlaceIndexIsOutOfRangeWhenCallingDepart () {
        try {
            Parking parking = new Parking(4);
            parking.depart(5);
            fail("Expected IllegalArgumentException");
            fail(" Throw Exception If Place Index Is Out Of Range ");
        } catch (IllegalArgumentException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void shouldShiftRightWhenArriveToOccupiedPlace () {
        PrintStream old = System.out;
        Parking p = new Parking(4);
        p.arrive(1);
        p.arrive(1);
        System.setOut(new PrintStream(output));
        p.print();
        String expected = "0110";
        assertEquals(output.toString().replaceAll(System.lineSeparator(), ""), expected);
        System.setOut(old);
    }

    @Test
    public void shouldShiftToTheStartWhenAllPlacesOnTheRightAreOccupied () {
        PrintStream old = System.out;
        Parking p = new Parking(4);
        p.arrive(2);
        p.arrive(2);
        p.arrive(2);
        System.setOut(new PrintStream(output));
        p.print();
        String expected = "1011";
        assertEquals(output.toString().replaceAll(System.lineSeparator(),""), expected);
        System.setOut(old);
    }

    @Test
    public void shouldDepartFromEngagedPlace () {
        Parking p = new Parking(4);
        p.arrive(2);
        assertTrue(p.depart(2));
    }

    @Test
    public void shouldArriveToEmptyPlace () {
        Parking p = new Parking(4);
        p.arrive(1);
        assertTrue(p.depart(1));
    }

    @Test
    public void shouldReturnFalseIfThePlaceIsFree () {
        Parking p = new Parking(4);
        assertFalse(p.depart(1));
    }

    @Test
    public void shouldNotDepartFromEmptyPlace () {
        PrintStream old = System.out;
        Parking p = new Parking(4);
        p.arrive(1);
        p.arrive(2);
        p.depart(3);
        System.setOut(new PrintStream(output));
        p.print();
        String expected = "0110";
        assertEquals(output.toString().replaceAll(System.lineSeparator(),""), expected);
        System.setOut(old);
    }

    @Test
    public void shouldReturnFalseWhenAllPlacesAreOccupied () {
        Parking p = new Parking(3);
        p.arrive(2);
        p.arrive(2);
        p.arrive(2);
        assertFalse(p.arrive(2));
    }

    @Test
    public void shouldNotArriveWhenAllPlacesAreOccupied () {
        PrintStream old = System.out;
        Parking p = new Parking(3);
        p.arrive(2);
        p.arrive(2);
        p.arrive(2);
        p.arrive(2);
        System.setOut(new PrintStream(output));
        p.print();
        String expected = "111";
        assertEquals(output.toString().replaceAll(System.lineSeparator(),""), expected);
        System.setOut(old);
    }
}
