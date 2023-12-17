package edu.hm7.task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class Task4Theads {
    private static final double PI_APPROXIMATION_CONSTANT = 4.0;
    private static final AtomicLong CIRCLE_COUNT = new AtomicLong(0);

    private Task4Theads() {
    }

    public static double calculateParallelPiMonteCarlo(long iterations, int numThreads) {
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        try {
            long totalCount = 0;
            long iterationsPerThread = iterations / numThreads;

            Future<Long>[] results = new Future[numThreads];

            for (int i = 0; i < numThreads; i++) {
                results[i] = executorService.submit(() -> simulateMonteCarlo(iterationsPerThread));
            }

            for (int i = 0; i < numThreads; i++) {
                try {
                    totalCount += results[i].get();
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            }

            return PI_APPROXIMATION_CONSTANT * (double) CIRCLE_COUNT.get() / totalCount;

        } finally {
            executorService.shutdown();
        }
    }

    private static long simulateMonteCarlo(long iterations) {

        for (long i = 0; i < iterations; i++) {
            double x = ThreadLocalRandom.current().nextDouble();
            double y = ThreadLocalRandom.current().nextDouble();

            double distance = Math.sqrt(x * x + y * y);

            if (distance <= 1.0) {
                CIRCLE_COUNT.incrementAndGet();
            }
        }

        return iterations;
    }
}
