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
    @Test
    void testPersisting() {
        FibCalculator fibCalculator = new FibCalculatorImpl();
        String cacheDirectory = "F:\\Tinkoff2\\src\\main\\java\\edu\\hw10\\task2\\cache";
        FibCalculator proxy = CacheProxy.create(fibCalculator, FibCalculator.class,
            cacheDirectory);

        long result1 = proxy.fib(5);
        assertEquals(5, result1);


        assertTrue(fileExists(cacheDirectory, "fib[5].cache"));

    }

    private boolean fileExists(String directory, String fileName) {
        File file = new File(directory, fileName);
        return file.exists() && file.isFile();
    }
}
