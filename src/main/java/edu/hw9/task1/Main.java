package edu.hw9.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {

    private final static int NUM_THREADS = 5;
    private static final int NUM_TASKS = 10;

    private Main() {
    }

    public static void main(String[] args) {
        StatsCollector collector = new StatsCollector();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_TASKS; i++) {
            final int index = i;
            executorService.submit(() -> {
                double[] values = {Math.random(), Math.random(), Math.random()};
                collector.push("metric_" + index, values);
            });
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        for (MetricStats metricStats : collector.stats()) {
            log.info("Metric: " + metricStats.getMetricName());
            log.info("Sum: " + metricStats.getSum());
            log.info("Average: " + metricStats.getAverage());
            log.info("Max: " + metricStats.getMax());
            log.info("Min: " + metricStats.getMin());
            log.info(" ");
        }
    }
}
