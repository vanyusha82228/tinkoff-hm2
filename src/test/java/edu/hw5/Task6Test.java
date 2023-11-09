package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task6Test {
    @Test
    public void testIsSubstring() {
        String inputSubstring = "abc";
        String inputString = "achfdbaabgabcaabg";
        assertTrue(Task6.isSubstring(inputSubstring, inputString));
    }
}
