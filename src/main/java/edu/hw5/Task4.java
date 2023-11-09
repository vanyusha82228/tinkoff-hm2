package edu.hw5;

public class Task4 {

    private static final String PASSWORD_PATTERN = ".*[~!@#$%^&*|].*";

    private Task4() {
    }

    public static boolean passwordCheck(String intutString) {
        return intutString.matches(PASSWORD_PATTERN);
    }
}
