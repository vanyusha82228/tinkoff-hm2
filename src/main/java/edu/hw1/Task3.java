package edu.hw1;

import java.util.Arrays;

public class Task3 {
    @SuppressWarnings("unused")
    private Task3() {
    }

    public static boolean isNestable(int[] array1, int[] array2) {
        int maxArray1 = Arrays.stream(array1).max().getAsInt();
        int minArray1 = Arrays.stream(array1).min().getAsInt();

        int maxArray2 = Arrays.stream(array2).max().getAsInt();
        int minArray2 = Arrays.stream(array2).min().getAsInt();

        boolean isNestable = minArray1 > minArray2 && maxArray1 < maxArray2;

        return isNestable;
    }
}
