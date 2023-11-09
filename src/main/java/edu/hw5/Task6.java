package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {
    private Task6() {
    }

    public static boolean isSubstring(String inputSubstring, String inputString){
        return Pattern.compile(Pattern.quote(inputSubstring)).matcher(inputString).find();
    }
}
