package edu.hw9.task1;

import java.util.List;

public class MetricStats {
    private final String metricName;
    private final List<Double> values;

    public MetricStats(String metricName, List<Double> values) {
        this.metricName = metricName;
        this.values = values;
    }

    public double getSum() {
        return values.stream().mapToDouble(Double::doubleValue).sum();
    }

    public double getAverage() {
        return values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public double getMax() {
        return values.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
    }

    public double getMin() {
        return values.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
    }

    public String getMetricName() {
        return metricName;
    }
}
