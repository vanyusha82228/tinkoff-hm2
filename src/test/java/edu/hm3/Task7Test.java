package edu.hm3;

import org.junit.jupiter.api.Test;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {
    @Test
    public void testNullComparator() {
        TreeMap<String, String> treeMap = new TreeMap<>(new Task7<>());
        treeMap.put(null, "test");

        assertTrue(treeMap.containsKey(null));
    }

    @Test
    public void testNoNullComparator() {
        TreeMap<String, String> treeMap = new TreeMap<>(new Task7<>());
        treeMap.put("key", "test");

        assertTrue(treeMap.containsKey("key"));
    }
}
