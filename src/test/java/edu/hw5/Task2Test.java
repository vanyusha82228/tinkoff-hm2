package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    public void findFriday13(){
        int year = 2024;
        List<LocalDate> fridays13 = Task2.findFriday13(year);
        List<LocalDate> expected = List.of(
            LocalDate.of(2024, Month.SEPTEMBER, 13),
            LocalDate.of(2024, Month.DECEMBER, 13)
        );

        assertEquals(expected,fridays13);
    }

    @Test
    public void testFindNextFridayThe13th() {
        LocalDate date = LocalDate.of(2024, Month.OCTOBER, 25);
        LocalDate nextFridayThe13th = Task2.findNextFridayThe13th(date);

        assertEquals(LocalDate.of(2024, Month.DECEMBER, 13), nextFridayThe13th);
    }
}
