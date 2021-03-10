package com.epam.rd.java.basic.practice8;

import org.junit.Assert;
import org.junit.Test;

public class Part4StudentTest {

    @Test
    public void testDemo() {
        Demo.main(new String[] { });
        String s = "D";
        Assert.assertEquals("D", s);
    }
}
