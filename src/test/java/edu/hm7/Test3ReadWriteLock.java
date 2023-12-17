package edu.hm7;

import edu.hm7.task3.Person;
import edu.hm7.task3.SynchronizedPersonDatabase;
import edu.hm7.task3ReadWriteLock.SynchronizedPersonDatabaseReadWriteLock;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Test3ReadWriteLock {
    @Test
    public void testConcurrentAdd() throws InterruptedException {
        SynchronizedPersonDatabaseReadWriteLock database = new SynchronizedPersonDatabaseReadWriteLock();

        int numThreads = 10;
        int personsPerThread = 100;


        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < personsPerThread; j++) {
                    Person person = new Person(j, "Name" + j, "Address" + j, "Phone" + j);
                    database.add(person);
                }
            });
        }


        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (int i = 0; i < personsPerThread; i++) {
            assertNotNull(database.findByName("Name" + i));
        }
    }
}
