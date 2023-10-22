package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    @Test
    @DisplayName("Проверка на палиндром")
    void testIsPalindrome() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int number = 121;
        Method method = Task5.class.getDeclaredMethod("isPalindrome", int.class);
        method.setAccessible(true); // Разрешаем вызов приватного метода
        boolean result = (boolean) method.invoke(null, number);
        assertTrue(result);
    }


    @Test
    void testIsPalindromeDescendant(){
        int number = 11211230;
        assertFalse(Task5.isPalindromeDescendant(number));
    }
    @Test
    void testIsPalindromeDescendantWithInvalidInput() {
        int invalidNumber = 1234567890;
        assertFalse(Task5.isPalindromeDescendant(invalidNumber));
    }

}
