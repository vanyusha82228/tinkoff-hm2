package edu.hw10.task2;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Main {
    private final static int NUMBER = 10;

    private Main() {
    }

    public static void main(String[] args) {
        FibCalculator fibCalculator = new FibCalculatorImpl();
        FibCalculator proxy = CacheProxy.create(fibCalculator, FibCalculator.class,
            "F:\\Tinkoff2\\src\\main\\java\\edu\\hw10\\task2\\cache");

        long result = proxy.fib(NUMBER);
        log.info("Result: " + result);

        result = proxy.fib(NUMBER); // из кеша
        log.info("Result from cache: " + result);
    }
}
