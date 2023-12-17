package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {
    @Test
    public void testValidPassword(){
        String input = "fgd~fgd";
        assertTrue(Task4.passwordCheck(input));
    }

    @Test
    public void testValidPasswordNoSpecialChar(){
        String input = "fgdfgd";
        assertFalse(Task4.passwordCheck(input));
    }


    @Test
    public void testValidPasswordSeveralSpecialChar(){
        String input = "f*gd~fgd%";
        assertTrue(Task4.passwordCheck(input));
    }
}
