package edu.hm6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Log4j2
public class Task1 implements Map<String, String> {

    private static final String FILE_ENTRY_SEPARATOR = ":";
    private String filePath;
    private Map<String, String> inMemoryMap;

    public Task1(String filePath) {
        this.filePath = filePath;
        this.inMemoryMap = new HashMap<>();
        loadFromDisk();
    }

    private void loadFromDisk() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            if (inMemoryMap.isEmpty()) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(FILE_ENTRY_SEPARATOR);
                    if (parts.length == 2) {
                        inMemoryMap.put(parts[0], parts[1]);
                    }
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void saveToDisk() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : inMemoryMap.entrySet()) {
                writer.write(entry.getKey() + FILE_ENTRY_SEPARATOR + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public int size() {
        return inMemoryMap.size();
    }

    @Override
    public boolean isEmpty() {
        return inMemoryMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return inMemoryMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return inMemoryMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return inMemoryMap.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        String oldValue = inMemoryMap.put(key, value);
        saveToDisk();
        return oldValue;
    }

    @Override
    public String remove(Object key) {
        String removedValue = inMemoryMap.remove(key);
        saveToDisk();
        return removedValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        inMemoryMap.putAll(m);
        saveToDisk();
    }

    @Override
    public void clear() {
        inMemoryMap.clear();
        saveToDisk();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return inMemoryMap.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return inMemoryMap.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return inMemoryMap.entrySet();
    }
}
