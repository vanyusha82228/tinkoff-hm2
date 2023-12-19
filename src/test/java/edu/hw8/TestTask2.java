package edu.hw8;

import edu.hm8.task2.FibonacciTask;
import edu.hm8.task2.FixedThreadPool;
import edu.hm8.task2.ThreadPool;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask2 {
    private ThreadPool threadPool;

    @BeforeAll
    public void setUp() {
        threadPool = FixedThreadPool.create(2);
        threadPool.start();
    }

    @AfterAll
    public void tearDown() throws Exception {
        threadPool.close();
    }

    @Test
    public void testThreadPoolExecution() throws InterruptedException {
        final boolean[] executed = {false};

        Runnable task = () -> {
            executed[0] = true;
            System.out.println("Task executed by thread " + Thread.currentThread().getName());
        };

        threadPool.execute(task);
        Thread.sleep(100);

        assertTrue(executed[0]);
    }
    @Test
    public void testFibonacciCalculation() {
        FibonacciTask fibonacciTask = new FibonacciTask(5);
        fibonacciTask.run();


    }
}
