package com.pavesid.helper;

import java.security.SecureRandom;
import java.util.Random;

public class GenerateSecurePassword {
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!:.#%";
    private static final String NUMBER = "0123456789";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String SPECIAL = "!:.#%";

    public static String generatePassword(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        returnValue.append(NUMBER.charAt(RANDOM.nextInt(NUMBER.length())));
        returnValue.append(UPPERCASE.charAt(RANDOM.nextInt(UPPERCASE.length())));
        returnValue.append(LOWERCASE.charAt(RANDOM.nextInt(LOWERCASE.length())));
        returnValue.append(SPECIAL.charAt(RANDOM.nextInt(SPECIAL.length())));
        for (int i = 0; i < length - 4; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
}