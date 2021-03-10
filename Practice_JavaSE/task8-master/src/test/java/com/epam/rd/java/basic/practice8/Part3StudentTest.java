package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.entity.User;
import org.junit.Assert;
import org.junit.Test;

public class Part3StudentTest {

    @Test
    public void testEquals_Team() {
        User x = new User();
        x.createUser("w");
        User y = new User();
        y.createUser("w");
        Assert.assertTrue(x.equals(y) && y.equals(x));
    }

    @Test
    public void testhashCode_Team() {
        User x = new User();
        x.createUser("w");
        User y = new User();
        y.createUser("w");
        Assert.assertTrue(x.hashCode() == y.hashCode());
    }
}
