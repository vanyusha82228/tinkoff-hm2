package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task7Test {
    @Test
    void testValidStrings() {
        String[] validStrings = {
            "001",
            "010",
            "111",
            "0"
        };

        for (String input : validStrings) {
            assertTrue(Task7.checkString(input), "Failed to validate valid string: " + input);
        }
    }

    @Test
    void testInvalidStrings() {
        String[] invalidStrings = {
            "0110",
            "10101"
        };

        for (String input : invalidStrings) {
            assertFalse(Task7.checkString(input), "Incorrectly validated invalid string: " + input);
        }
    }
}
