package edu.hw10;

import edu.hw10.task2.CacheProxy;
import edu.hw10.task2.FibCalculator;
import edu.hw10.task2.FibCalculatorImpl;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask2 {
    @Test
    void testCaching() {
        FibCalculator fibCalculator = new FibCalculatorImpl();
        FibCalculator proxy = CacheProxy.create(fibCalculator, FibCalculator.class,
            "F:\\Tinkoff2\\src\\main\\java\\edu\\hw10\\task2\\cache");

        // Первый вызов - результат должен быть вычислен
        long result1 = proxy.fib(5);
        assertEquals(5, result1);
    }
}
