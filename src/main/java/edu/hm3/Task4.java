package edu.hm3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Task4 {
    private Task4() {
    }

    private static final int M = 1000;
    private static final int CM = 900;
    private static final int D = 500;
    private static final int CD = 400;
    private static final int C = 100;
    private static final int XC = 90;
    private static final int L = 50;
    private static final int XL = 40;
    private static final int X = 10;
    private static final int IX = 9;
    private static final int V = 5;
    private static final int IV = 4;
    private static final int I = 1;

    private static final int MAX_VALUE_FOR_ROMAN = 3999;

    public static String convertToRoman(int number) {
        int remainingNumber = number;
        if (remainingNumber <= 0 || remainingNumber > MAX_VALUE_FOR_ROMAN) {
            return "";
        }
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(M, "M");
        map.put(CM, "CM");
        map.put(D, "D");
        map.put(CD, "CD");
        map.put(C, "C");
        map.put(XC, "XC");
        map.put(L, "L");
        map.put(XL, "XL");
        map.put(X, "X");
        map.put(IX, "IX");
        map.put(V, "V");
        map.put(IV, "IV");
        map.put(I, "I");

        StringBuilder romanNumber = new StringBuilder();
        for (Map.Entry<Integer,String> entry: map.entrySet()) {
            while (remainingNumber >= entry.getKey()) {
                romanNumber.append(entry.getValue());
                remainingNumber -= entry.getKey();
            }
        }
        return romanNumber.toString();
    }
}
