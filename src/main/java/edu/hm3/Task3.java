package edu.hm3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    private Task3() {
    }

    public static <T> Map<T, Integer> freqDict(List<T> input) {
        Map<T, Integer> freqDictMap = new HashMap<>();
        for (T item : input) {
            freqDictMap.put(item, freqDictMap.getOrDefault(item, 0) + 1);
        }
        return freqDictMap;
    }
}
