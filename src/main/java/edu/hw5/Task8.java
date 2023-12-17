package edu.hw5;

import java.util.regex.Pattern;

public class Task8 {
    // Нечетной длины
    private static final Pattern PATTERN1 = Pattern.compile("^[01]*1[01]$");

    //  нет последовательных 1
    private static final Pattern PATTERN2 = Pattern.compile("^[01]*0[01]*$");

    // Количество 0 кратно 3
    private static final Pattern PATTERN3 = Pattern.compile("^(?!.*111)[01]*0{3}[01]*$");

    // Любая строка, кроме 11 или 111
    private static final Pattern PATTERN4 = Pattern.compile("^(?!1{2,3}$)[01]+$");

    // Каждый нечетный символ равен 1
    private static final Pattern PATTERN5 = Pattern.compile("^(([01][01])*1)?[01]*$");

    private Task8() {
    }

    public static boolean checkPattern1(String input) {
        return PATTERN1.matcher(input).matches();
    }

    public static boolean checkPattern2(String input) {
        return PATTERN2.matcher(input).matches();
    }

    public static boolean checkPattern3(String input) {
        return PATTERN3.matcher(input).matches();
    }

    public static boolean checkPattern4(String input) {
        return PATTERN4.matcher(input).matches();
    }

    public static boolean checkPattern5(String input) {
        return PATTERN5.matcher(input).matches();
    }
}
