package edu.hm3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    public static List<String> clusterize(String input) {
        List<String> clusters = new ArrayList<>();
        int openBracketCount = 0;
        int closeBracketCount = 0;
        int clusterStart = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '(') {
                openBracketCount++;
            } else if (currentChar == ')') {
                closeBracketCount++;
            }

            if (openBracketCount == closeBracketCount) {
                String cluster = input.substring(clusterStart, i + 1);
                clusters.add(cluster);

                clusterStart = i + 1;

                openBracketCount = 0;
                closeBracketCount = 0;
            }
        }
        return clusters;
    }
}
