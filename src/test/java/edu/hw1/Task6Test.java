package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    @Test
    @DisplayName("Введено специальное число")
    void testCountKWithSpecialNumber() {
        int specialNumber = 6174;
        int expectedSteps = 0;
        int actualSteps = Task6.countK(specialNumber);
        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    @DisplayName("Введено отрицательное число")
    void testCountKNegativeNUmber(){
        int specialNumber = -4567;
        int expectedSteps = -1;
        int actualSteps = Task6.countK(specialNumber);
        assertEquals(expectedSteps, actualSteps);
    }

    @Test
    @DisplayName("Введенно обычное число")
    void testCountK(){
        int number = 6621;
        int expected = 5;
        int actual = Task6.countK(number);
        assertEquals(expected,actual);
    }

}
