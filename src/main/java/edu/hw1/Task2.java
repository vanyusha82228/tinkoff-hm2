package edu.hw1;

public class Task2 {
    private static final int DIGIT_BASE = 10;

    @SuppressWarnings("unused")
    private Task2() {
    }

    public static int countDigits(int number) {
        int count = 0;
        int tempNUmber = number;
        if (tempNUmber == 0) {
            return 1;
        }
        while (tempNUmber != 0) {
            tempNUmber = tempNUmber / DIGIT_BASE;
            count++;
        }

        return count;
    }
}
