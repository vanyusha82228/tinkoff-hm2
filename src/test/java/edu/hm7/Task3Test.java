package edu.hm7;

import edu.hm7.task3.Person;
import edu.hm7.task3.PersonDatabase;
import edu.hm7.task3.SynchronizedPersonDatabase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task3Test {
    @Test
    public void testAddAndFind() {
        PersonDatabase database = new SynchronizedPersonDatabase();

        Person person = new Person(1, "John Doe", "123 Main St", "555-1234");
        database.add(person);

        Person foundByName = database.findByName("John Doe");
        assertNotNull(foundByName);
        assertEquals(person, foundByName);

        Person foundByAddress = database.findByAddress("123 Main St");
        assertNotNull(foundByAddress);
        assertEquals(person, foundByAddress);

        Person foundByPhone = database.findByPhone("555-1234");
        assertNotNull(foundByPhone);
        assertEquals(person, foundByPhone);
    }

    @Test
    public void testDelete() {
        PersonDatabase database = new SynchronizedPersonDatabase();

        Person person = new Person(1, "Jane Doe", "456 Oak St", "555-5678");
        database.add(person);

        database.delete(1);

        assertNull(database.findByName("Jane Doe"));
        assertNull(database.findByAddress("456 Oak St"));
        assertNull(database.findByPhone("555-5678"));
    }

    @Test
    public void testFindNonExistent() {
        PersonDatabase database = new SynchronizedPersonDatabase();

        assertNull(database.findByName("Nonexistent"));
        assertNull(database.findByAddress("Nowhere St"));
        assertNull(database.findByPhone("123-4567"));
    }

    @Test
    public void testConcurrentAdd() throws InterruptedException {
        SynchronizedPersonDatabase database = new SynchronizedPersonDatabase();

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
