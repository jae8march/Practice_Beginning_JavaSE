package com.epam.rd.java.basic.practice3;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Task 4.
 */
public class Part4 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.print("\tTest method hash #1:\n" + hash("asdf", "MD5"));
        System.out.print("\n\tTest method hash #2:\n" + hash("asdf", "SHA-256"));
    }

    /**
     * @param input data, the hash of which we obtain
     * @param algorithm the name of the hashing algorithm
     * @return string consisting of hexadecimal digits: each byte corresponds to two hexadecimal digits
     * @throws NoSuchAlgorithmException issued when a specific cryptographic algorithm is required
     * but not available in the environment
     */
    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        StringBuilder str = new StringBuilder();

        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes(StandardCharsets.UTF_8));
        byte[] hash = digest.digest();
        for (int i = 0; i < hash.length; i++) {
            String x;
            if (hash[i] < 0) {
                x = String.format("%02x", hash[i]);
                String y = x.substring(x.length() - 2);
                str.append(y);
                continue;
            }
            str.append(String.format("%02x", hash[i]));
        }
        return str.toString().toUpperCase();
    }
}
