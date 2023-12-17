package edu.hm7.task4;

import java.util.Random;

public class Task4 {
    private static final double PI_APPROXIMATION_CONSTANT = 4.0;

    private Task4() {
    }

    public static double calculatePiMonteCarlo(long iterations) {
        long totalCount = 0;
        long circleCount = 0;

        Random random = new Random();

        for (int i = 0; i < iterations; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();

            double distance = Math.sqrt(x * x + y * y);

            totalCount++;

            if (distance <= 1.0) {
                circleCount++;
            }
        }

        return PI_APPROXIMATION_CONSTANT * (double) circleCount / totalCount;
    }
}
