package edu.hw9.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatsCollector {
    private Map<String, List<Double>> data;

    public StatsCollector() {
        this.data = new HashMap<>();
    }

    public synchronized void push(String metricName, double[] values) {
        if (!data.containsKey(metricName)) {
            data.put(metricName, new ArrayList<>());
        }

        for (double value : values) {
            data.get(metricName).add(value);
        }
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
