package edu.hm2.task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DefaultConnectionManagerTest {
    private ConnectionManager connectionManager;
    private static final double COEFFICIENT = 0.2;
    @BeforeEach
    void setUp() {
        connectionManager = new DefaultConnectionManager();
    }
    @Test
    void testStableConnectionProbability() {
        int stableConnectionCount = 0;
        int totalConnections = 10000; // Количество попыток

        for (int i = 0; i < totalConnections; i++) {
            Connection connection = connectionManager.getConnection();
            if (connection instanceof StableConnection) {
                stableConnectionCount++;
            }
        }

        double stableConnectionProbability = (double) stableConnectionCount / totalConnections;
        double expectedProbability = 1.0 - COEFFICIENT;
        assertEquals(expectedProbability, stableConnectionProbability, 0.01); // Проверяем вероятность стабильного соединения
    }

}
