package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    @DisplayName("Тест с нечетной строкой")
    void testFixStringEvenStringLen() {
        String string = "123456";
        String expect = "214365";
        String actual = Task4.fixString(string);
        assertEquals(expect,actual);
    }
    @Test
    @DisplayName("Тест с четной строкой")
    void testFixStringOddStringLen() {
        String string = "badce";
        String expect = "abcde";
        String actual = Task4.fixString(string);
        assertEquals(expect,actual);
    }
    @Test
    @DisplayName("Тест с пустой строкой")
    public void testFixStringWithEmptyString() {
        String brokenString = "";
        String expectedFixedString = "";
        String actualFixedString = Task4.fixString(brokenString);
        assertEquals(expectedFixedString, actualFixedString);
    }

}
