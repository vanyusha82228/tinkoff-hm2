package edu.hm8.task2;

public class Main {

    private static final int THREAD_POOL_SIZE = 4;
    private static final int TASK_COUNT = 10;

    private Main() {
    }

    public static void main(String[] args) {
        try (ThreadPool threadPool = FixedThreadPool.create(THREAD_POOL_SIZE)) {
            threadPool.start();

            for (int i = 0; i < TASK_COUNT; i++) {
                FibonacciTask task = new FibonacciTask(i);
                threadPool.execute(task);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
