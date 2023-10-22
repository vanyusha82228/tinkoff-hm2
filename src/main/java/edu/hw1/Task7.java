package edu.hw1;

public class Task7 {
    @SuppressWarnings("unused")
    private Task7() {
    }

    public static int rotateRight(int n, int shift) {
        String binaryString = Integer.toBinaryString(n);
        char[] binaryCharArray = binaryString.toCharArray();
        for (int i = 0; i < shift; i++) {
            char temp = binaryCharArray[binaryCharArray.length - 1];
            for (int j = binaryCharArray.length - 1; j > 0; j--) {
                binaryCharArray[j] = binaryCharArray[j - 1];
            }
            binaryCharArray[0] = temp;
        }
        return Integer.parseInt(new String(binaryCharArray), 2);
    }

    public static int rotateLeft(int n, int shift) {
        String binaryString = Integer.toBinaryString(n);
        char[] binaryCharArray = binaryString.toCharArray();
        for (int i = 0; i < shift; i++) {
            char temp = binaryCharArray[0];
            for (int j = 0; j < binaryCharArray.length - 1; j++) {
                binaryCharArray[j] = binaryCharArray[j + 1];
            }
            binaryCharArray[binaryCharArray.length - 1] = temp;
        }
        return Integer.parseInt(new String(binaryCharArray), 2);
    }


}

