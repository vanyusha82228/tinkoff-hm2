package edu.hm7.task4;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {

    private final static long ITERATIONS = 10_000_000L;

    private final static int NUM_THREADS = 6;

    private Main() {
    }

    public static void main(String[] args) {
//
//        long startTime = System.currentTimeMillis();
//
//        double piApproximation =Task4.calculatePiMonteCarlo(ITERATIONS);
//
//        long endTime = System.currentTimeMillis();
//        long executionTime = endTime - startTime;
//
//        log.info("Приближенное значение числа Пи: " + piApproximation);
//        log.info("Время выполнения: " + executionTime + " миллисекунд");




        long startTime = System.nanoTime();

        double piApproximation = Task4Theads.calculateParallelPiMonteCarlo(ITERATIONS, NUM_THREADS);

        long endTime = System.nanoTime();
        double executionTimeSeconds = endTime - startTime;

        log.info("Приближенное значение числа Пи: " + piApproximation);
        log.info("Время выполнения: " + executionTimeSeconds + " миллисекунд");
    }
}
