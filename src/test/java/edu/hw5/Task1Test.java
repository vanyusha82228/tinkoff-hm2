package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    public void testTimeCounter(){
        String input1 = "2022-04-01, 21:30";
        String input2 = "2022-04-02, 01:20";
        String expected = "3ч 50м";
        String actual = Task1.timeCounter(input1,input2);
        assertEquals(expected,actual);
    }

}
