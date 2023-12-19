package edu.hm8.task2;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FibonacciTask implements Runnable {
    private final int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    private int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    @Override
    public void run() {
        int result = fib(n);
        log.info("Fibonacci(" + n + ") = " + result + " calculated by thread " + Thread.currentThread().getName());
    }
}
