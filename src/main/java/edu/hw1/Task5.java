package edu.hw1;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Task5 {
    private static final int DIGIT_BASE = 10;

    @SuppressWarnings("unused")
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int number) {
        if (isPalindrome(number)) {
            return true;
        } else {
            int descendant = createDescendant(number);
            return isPalindrome(descendant);
        }
    }

    private static int createDescendant(int number) {
        int descendant = number;
        while (!isPalindrome(descendant)) {
            String numberString = Integer.toString(descendant);
            StringBuilder resultNumber = new StringBuilder();
            if (numberString.length() % 2 != 0) {
                log.info("Введина не четная длинна числа ");
                break;
            } else {
                for (int i = 0; i < numberString.length(); i += 2) {
                    int digit1 = Character.getNumericValue(numberString.charAt(i));
                    int digit2 = Character.getNumericValue(numberString.charAt(i + 1));
                    int sumDigit = digit1 + digit2;
                    resultNumber.append(sumDigit);
                }
                descendant = Integer.parseInt(resultNumber.toString());
                if (!isPalindrome(descendant)) {
                    break;
                }
            }
        }
        return descendant;
    }

    private static boolean isPalindrome(int number) {
        int palindrome = number;
        int revers = 0;
        while (palindrome != 0) {
            int remainder = palindrome % DIGIT_BASE;
            revers = revers * DIGIT_BASE + remainder;
            palindrome /= DIGIT_BASE;
        }
        return number == revers;
    }
}

