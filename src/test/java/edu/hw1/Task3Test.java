package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void testIsNestable() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {0, 1, 2, 3, 4};
        assertTrue(Task3.isNestable(array1,array2));
    }

}
