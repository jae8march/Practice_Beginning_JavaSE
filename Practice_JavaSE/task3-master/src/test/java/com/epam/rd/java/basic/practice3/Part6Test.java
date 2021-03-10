package com.epam.rd.java.basic.practice3;

import static org.junit.Assert.*;

public class Part6Test {
    @org.junit.Test
    public void convertTest() {
        Part6 p6 = new Part6();
        String actual = p6.convert("And miles to go before I sleep, and miles to go before I sleep.\n" +
                "О, рассмейтесь, смехачи!\n" +
                "О, засмейтесь, смехачи!\n" +
                "Что смеются, что смеянствуют…");
        String expected = "And _miles _to _go _before _I _sleep, and _miles _to _go _before _I _sleep.\n" +
                "_О, рассмейтесь, _смехачи!\n" +
                "_О, засмейтесь, _смехачи!\n" +
                "Что смеются, что смеянствуют…";
        assertEquals(expected, actual);
    }
}
