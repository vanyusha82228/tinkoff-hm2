package edu.hw10.task2;

public class FibCalculatorImpl implements FibCalculator {
    @Override
    public long fib(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Input should be a positive integer.");
        }

        if (number == 1 || number == 2) {
            return 1;
        }

        return fib(number - 1) + fib(number - 2);
    }
}
