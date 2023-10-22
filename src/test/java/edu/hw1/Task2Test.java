package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    @DisplayName("Тест на коректность рассчетов")
    void testCountDigits() {
        int number = 3666;
        int expectedNumber = 4;
        int actualNUmber = Task2.countDigits(number);
        assertEquals(expectedNumber,actualNUmber);
    }

    @Test
    @DisplayName("Тест на коректность рассчетов если 0")
    void testZeroInput(){
        int number = 0;
        int expectedNumber = 1;
        int actualNUmber = Task2.countDigits(number);
        assertEquals(expectedNumber,actualNUmber);
    }

    @Test
    @DisplayName("Тест на коректность рассчетов если отрицательное число")
    void testNegativeInput(){
        int number = -3666;
        int expectedNumber = 4;
        int actualNUmber = Task2.countDigits(number);
        assertEquals(expectedNumber,actualNUmber);
    }

}
