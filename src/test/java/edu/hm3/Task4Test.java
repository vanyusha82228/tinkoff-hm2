package edu.hm3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    public void convertToRoman(){
        int number = 16;
        String expected = "XVI";
        assertEquals(expected,Task4.convertToRoman(number));
    }
}
