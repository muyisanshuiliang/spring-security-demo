package com.example.dss.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        final MessageDigest instance = MessageDigest.getInstance("md5");
        final byte[] digest1 = instance.digest("admin".getBytes());
        final byte[] digest2 = instance.digest("guest".getBytes());
        final byte[] digest3 = instance.digest("anonymous".getBytes());
        System.out.println("admin ---> " + toString(digest1));
        System.out.println("guest ---> " + toString(digest2));
        System.out.println("anonymous ---> " + toString(digest3));
    }

    private static String toString(byte[] digest) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (byte item : digest) {
            final String s = Integer.toHexString(item & 0xFF);
            if (s.length() == 1) {
                stringBuilder.append("0");
            }
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
