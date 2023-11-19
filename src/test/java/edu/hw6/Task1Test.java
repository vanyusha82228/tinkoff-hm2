package edu.hw6;

import edu.hm6.Task1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1Test {
    private Task1 task1;

    @BeforeEach
    public void setUp() {
        task1 = new Task1("F:\\Tinkoff2\\src\\main\\java\\edu\\hm6\\txtFile\\test.txt");
    }

    @Test
    public void testSize() {

        task1.put("key1", "value1");
        assertEquals(2, task1.size());
    }

    @Test
    public void testContainsKey() {

        task1.put("key1", "value1");
        assertTrue(task1.containsKey("key1"));
    }

    @Test
    public void testContainsValue() {
        task1.put("key1", "value1");
        assertTrue(task1.containsValue("value1"));
    }

    @Test
    public void testRemove() {

        task1.put("key1", "value1");
        assertEquals("value1", task1.remove("key1"));
        assertNull(task1.get("key1"));
    }

    @Test
    public void testGet() {

        task1.put("key1", "value1");
        assertEquals("value1", task1.get("key1"));
    }
}
