package edu.hm2.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private final Random random = new Random();
    private static final double COEFFICIENT = 0.2;

    @Override
    public Connection getConnection() {
        if (random.nextDouble() < COEFFICIENT) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
