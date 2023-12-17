package edu.hm7;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {
    @Test
    public void testFactorialCountWithPositiveNumber() {
        int number = 5;
        BigInteger expectedResult = BigInteger.valueOf(120);
        BigInteger result = Task2.factorialCount(number);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFactorialCountWithZero() {
        int number = 0;
        BigInteger expectedResult = BigInteger.ONE;
        BigInteger result = Task2.factorialCount(number);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFactorialCountWithNegativeNumber() {
        int number = -5;
        assertThrows(IllegalArgumentException.class, () -> {
            Task2.factorialCount(number);
        });
    }
}
