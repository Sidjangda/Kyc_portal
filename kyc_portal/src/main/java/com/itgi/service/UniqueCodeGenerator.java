package com.itgi.service;
import java.util.Random;
public class UniqueCodeGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Length of the code
    private static final int CODE_LENGTH = 14;

    // Random object to generate random values
    private static final Random RANDOM = new Random();
    public static String generateUniqueCode() {
        StringBuilder code = new StringBuilder(CODE_LENGTH);

        // Generate random characters to form the code
        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            code.append(CHARACTERS.charAt(index));
        }

        return code.toString();
    }
}

