package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task7Test {
    @Test
    void testRotateRight(){
        int number = 8;
        int shift = 1;

        int expected = 4;
        int actual = Task7.rotateRight(number,shift);
        assertEquals(expected,actual);
    }

    @Test
    void testRotateLeft(){
        int number = 16;
        int shift = 1;

        int expected = 1;
        int actual = Task7.rotateLeft(number,shift);
        assertEquals(expected,actual);
    }

}
