package edu.hm7;

import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    public void testAtomicCounter() throws InterruptedException {

        for (int i = 0; i<5; i++){
            Thread thread = new Thread(new Task1());
            thread.start();
        }

        Thread.sleep(1000);
        assertEquals(5,Task1.getCounter());
    }
}
