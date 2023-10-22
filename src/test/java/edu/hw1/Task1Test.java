package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    @DisplayName("Тест на корректное время")
    void testGetVideoLength() {
        String line = "2:30";
        int expectedSecond = 150;
        int actualSecond = Task1.getVideoLength(line);
        assertEquals(expectedSecond,actualSecond);
    }

    @Test
    @DisplayName("Тест если ввдены отрицательные минуты")
    void negativeMin(){
        String line = "-2:30";
        int actual = Task1.getVideoLength(line);
        assertEquals(-1,actual);
    }
    @Test
    @DisplayName("Тест если ввдены отрицательные секунды")
    void negativeSec(){
        String line = "2:-30";
        int actual = Task1.getVideoLength(line);
        assertEquals(-1,actual);
    }
    @Test
    @DisplayName("Тест если ввдены секунды больше 60")
    void testSecondsGreaterThan60(){
        String line = "2:60";
        int actual = Task1.getVideoLength(line);
        assertEquals(-1,actual);
    }
}
