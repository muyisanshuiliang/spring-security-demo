package com.example.dss.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SimplePasswordEncoder implements PasswordEncoder {
    private static final Logger logger = LoggerFactory.getLogger(SimplePasswordEncoder.class);

    @Override
    public String encode(CharSequence rawPassword) {
        if (logger.isDebugEnabled()) {
            logger.debug("执行明文密码加密过程");
        }
        try {
            final byte[] md5s = MessageDigest.getInstance("MD5").digest(rawPassword.toString().getBytes());
            return toString(md5s);
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        }
        return "";
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (logger.isDebugEnabled()) {
            logger.debug("执行密码匹配过程");
        }
        return encodedPassword.equals(encode(rawPassword));
    }


    private String toString(byte[] digest) {
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
