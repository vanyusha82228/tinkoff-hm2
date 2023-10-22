package edu.hm3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Task2Test {
    @Test
    public void testCluster() {
        String input = "()()()";
        assertArrayEquals(new String[] {"()", "()", "()"}, Task2.clusterize(input).toArray());
    }

    @Test
    public void testClusterEmpty() {
        String input = "";
        assertArrayEquals(new String[] {}, Task2.clusterize(input).toArray());
    }
}
