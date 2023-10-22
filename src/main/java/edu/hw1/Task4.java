package edu.hw1;

public class Task4 {

    @SuppressWarnings("unused")
    private Task4() {
    }

    public static String fixString(String brokenString) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < brokenString.length() - 1; i += 2) {
            newString.append(brokenString.charAt(i + 1)).append(brokenString.charAt(i));
        }

        if (brokenString.length() % 2 != 0) {
            newString.append(brokenString.charAt(brokenString.length() - 1));
        }

        return newString.toString();
    }
}
