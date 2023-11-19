package edu.hw6;

import edu.hm6.Task6;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {
    @Test
    public void testIsPortAvailable() {
        assertTrue(Task6.isPortAvailable(12345));

    }
}
