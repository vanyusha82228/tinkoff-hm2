package edu.hm7;

import edu.hm7.task4.Task4Theads;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4TheadsTest {
    @Test
    void calculateParallelPiMonteCarloWithPositiveIterations() {
        long iterations = 1_000_000L;
        int numThreads = 2;
        double result = Task4Theads.calculateParallelPiMonteCarlo(iterations, numThreads);
        assertTrue(result >= 0.0 && result <= 4.0);
    }


}
