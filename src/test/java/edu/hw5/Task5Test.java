package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    public void testValidCarNumber(){
        String input = "А123ВЕ777";
        assertTrue(Task5.validCarNumber(input));
    }

    @Test
    public void testNoValidCarNumber(){
        String input = "123АВЕ777";
        assertFalse(Task5.validCarNumber(input));
    }

}
