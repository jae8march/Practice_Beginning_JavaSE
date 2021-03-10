package com.epam.rd.java.basic.practice8;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import org.junit.Assert;
import org.junit.Test;

public class Part2StudentTest {

    @Test
    public void testEquals_Team() {
        Team x = new Team();
        x.createTeam("w");
        Team y = new Team();
        y.createTeam("w");
        Assert.assertTrue(x.equals(y) && y.equals(x));
    }

    @Test
    public void testhashCode_Team() {
        Team x = new Team();
        x.createTeam("w");
        Team y = new Team();
        y.createTeam("w");
        Assert.assertTrue(x.hashCode() == y.hashCode());
    }
}
