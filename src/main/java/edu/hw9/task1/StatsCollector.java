package edu.hw9.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class StatsCollector {
    private ConcurrentMap<String, List<Double>> data;

    public StatsCollector() {
        this.data = new ConcurrentHashMap<>();
    }

    public void push(String metricName, List<Double> values) {
        data.compute(metricName, (key, existingValues) -> {
            if (existingValues == null) {
                return new CopyOnWriteArrayList<>(values);
            }
            existingValues.addAll(values);
            return existingValues;
        });
    }

    public synchronized List<MetricStats> stats() {
        List<MetricStats> result = new ArrayList<>();
        for (Map.Entry<String, List<Double>> entry : data.entrySet()) {
            String metricName = entry.getKey();
            List<Double> values = entry.getValue();
            result.add(new MetricStats(metricName, values));
        }
        return result;
    }
}
