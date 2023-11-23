package edu.hm7;

import edu.hm7.task4.Task4;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {

    @Test
    void calculatePiMonteCarloWithPositiveIterations() {
        long iterations = 1_000_000L;
        double result = Task4.calculatePiMonteCarlo(iterations);
        assertTrue(result >= 0.0 && result <= 4.0);
    }

}
