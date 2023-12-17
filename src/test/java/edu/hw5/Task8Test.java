package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task8Test {
    @Test
    void testPattern1() {
        assertTrue(Task8.checkPattern1("011"));
        assertFalse(Task8.checkPattern1("01"));
        assertTrue(Task8.checkPattern1("010"));
    }

    @Test
    void testPattern2() {
        assertTrue(Task8.checkPattern2("00"));
        assertFalse(Task8.checkPattern2("111"));
    }

    @Test
    void testPattern3() {
        assertTrue(Task8.checkPattern3("000"));
        assertFalse(Task8.checkPattern3("1001"));
        assertFalse(Task8.checkPattern3("111"));
        assertFalse(Task8.checkPattern3("101"));
    }

    @Test
    void testPattern4() {
        assertTrue(Task8.checkPattern4("001"));
        assertTrue(Task8.checkPattern4("110"));
        assertFalse(Task8.checkPattern4("11"));
        assertFalse(Task8.checkPattern4("111"));
    }

    @Test
    void testPattern5() {
        assertTrue(Task8.checkPattern5("101"));
        assertTrue(Task8.checkPattern5("0101"));
    }
}
