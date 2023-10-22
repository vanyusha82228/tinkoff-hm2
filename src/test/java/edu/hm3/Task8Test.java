package edu.hm3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task8Test {
    @Test
    public void testNext() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        Task8<Integer> iterator = new Task8<>(numbers);

        assertEquals(Integer.valueOf(3), iterator.next());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertEquals(Integer.valueOf(1), iterator.next());
    }
}
