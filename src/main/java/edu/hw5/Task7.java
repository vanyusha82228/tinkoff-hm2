package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {
    private static final Pattern PATTERN = Pattern.compile("^(.{2}0|(0|1).*(\\1)|[01]{1,3})$");

    private Task7() {
    }

    public static boolean checkString(String input) {
        return PATTERN.matcher(input).matches();
    }
}
