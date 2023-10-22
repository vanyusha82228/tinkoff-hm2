package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private static final int SPECIAL_NUMBER = 6174;
    private static final int DIGIT_BASE = 10;
    private static final int ARRAY_LEN = 4;

    @SuppressWarnings("unused")
    private Task6() {
    }

    public static int countK(int number) {
        int tempNumber = number;
        if (tempNumber == SPECIAL_NUMBER) {
            return 0;
        }
        if (tempNumber < 0) {
            return -1;
        }
        int[] digits = new int[ARRAY_LEN];
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = tempNumber % DIGIT_BASE;
            tempNumber /= DIGIT_BASE;
        }
        Arrays.sort(digits);
        int[] reversDigits = new int[ARRAY_LEN];
        for (int i = 0; i < reversDigits.length; i++) {
            reversDigits[i] = digits[reversDigits.length - 1 - i];
        }
        int asc = arrayToNumber(digits);
        int desc = arrayToNumber(reversDigits);

        int differences = desc - asc;
        int steps = countK(differences);
        if (steps == -1) {
            return -1;
        }
        return steps + 1;

    }

    public static int arrayToNumber(int[] array) {
        int number = 0;
        for (int digit : array) {
            number = number * DIGIT_BASE + digit;
        }
        return number;
    }
}
