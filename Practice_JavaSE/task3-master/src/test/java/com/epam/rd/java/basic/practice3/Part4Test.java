package com.epam.rd.java.basic.practice3;

import java.security.NoSuchAlgorithmException;
import static org.junit.Assert.*;

public class Part4Test {
    @org.junit.Test
    public void testConvertMethodForSecretInputDataMD5() throws NoSuchAlgorithmException {
        Part4 p4 = new Part4();
        String actual = p4.hash("asdf", "MD5");;
        String expected = "912EC803B2CE49E4A541068D495AB570";
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testConvertMethodForSecretInputDataSHA256() throws NoSuchAlgorithmException {
        Part4 p4 = new Part4();
        String actual = p4.hash("asdf", "SHA-256");;
        String expected = "F0E4C2F76C58916EC258F246851BEA091D14D4247A2FC3E18694461B1816E13B";
        assertEquals(expected, actual);
    }
}
