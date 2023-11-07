package edu.hm3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    @Test
    public void testFreqDict() {
        List<String> input = List.of("a", "bb", "a", "bb");
        Map<String, Integer> expected = Map.of("bb", 2, "a", 2);
        Map<String, Integer> actual = Task3.freqDict(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testFreqDictWithMixedTypes() {
        List<Object> input = Arrays.asList("a", "bb", 1, "bb", 1);
        Map<Object, Integer> expected = Map.of("bb", 2, "a", 1, 1, 2);
        Map<Object, Integer> result = Task3.freqDict(input);
        assertEquals(expected, result);
    }

}
