package edu.hw5;

public class Task5 {
    private static final String NUMBER_OF_CAR_PATTERN = "^[АВЕКМНОРСТУХ]{1}\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$";

    private Task5() {
    }

    public static boolean validCarNumber(String inputNumber) {
        return inputNumber.matches(NUMBER_OF_CAR_PATTERN);
    }
}
