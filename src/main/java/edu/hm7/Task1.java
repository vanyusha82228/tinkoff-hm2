package edu.hm7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 implements Runnable {
    private static AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void run() {
        counter.incrementAndGet();
    }

    public static int getCounter() {
        return counter.get();
    }
}
