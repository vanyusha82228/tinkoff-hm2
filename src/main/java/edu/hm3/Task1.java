package edu.hm3;

public class Task1 {
    private Task1() {
    }

    public static String atbash(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char mirroredChar = (char) (Character.isUpperCase(c) ? 'Z' - c + 'A' : 'z' - c + 'a');
                result.append(mirroredChar);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
