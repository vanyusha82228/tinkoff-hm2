package edu.hw9;

import edu.hw9.task1.MetricStats;
import edu.hw9.task1.StatsCollector;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestTask1 {
    @Test
    void testStatsCollector() {
        StatsCollector collector = new StatsCollector();
        List<Double> values1 = List.of(1.0, 2.0, 3.0);
        List<Double> values2 = List.of(0.5, 1.5, 2.5);

        // Пушим данные в коллектор
        collector.push("metric1", values1);
        collector.push("metric2", values2);

        // Получаем статистику
        for (MetricStats metricStats : collector.stats()) {
            if (metricStats.getMetricName().equals("metric1")) {
                assertEquals(6.0, metricStats.getSum(), 0.0001);
                assertEquals(2.0, metricStats.getAverage(), 0.0001);
                assertEquals(3.0, metricStats.getMax(), 0.0001);
                assertEquals(1.0, metricStats.getMin(), 0.0001);
            } else if (metricStats.getMetricName().equals("metric2")) {
                assertEquals(4.5, metricStats.getSum(), 0.0001);
                assertEquals(1.5, metricStats.getAverage(), 0.0001);
                assertEquals(2.5, metricStats.getMax(), 0.0001);
                assertEquals(0.5, metricStats.getMin(), 0.0001);
            } else {
                fail("Unknown metric name");
            }
        }
    }
}
