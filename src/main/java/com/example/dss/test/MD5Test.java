package com.example.dss.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        final MessageDigest instance = MessageDigest.getInstance("md5");
        final byte[] digest1 = instance.digest("00001".getBytes());
        final byte[] digest2 = instance.digest("00002".getBytes());
        final byte[] digest3 = instance.digest("00003".getBytes());
        final byte[] digest4 = instance.digest("00004".getBytes());
        final byte[] digest5 = instance.digest("00005".getBytes());
        System.out.println("00001 ---> " + toString(digest1));
        System.out.println("00002 ---> " + toString(digest2));
        System.out.println("00003 ---> " + toString(digest3));
        System.out.println("00004 ---> " + toString(digest4));
        System.out.println("00005 ---> " + toString(digest5));
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
