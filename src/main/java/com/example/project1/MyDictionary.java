package com.example.project1;

import org.jetbrains.annotations.NotNull;

public class MyDictionary implements Dictionary {
    private final String[] words = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew"};

    @Override
    public @NotNull String randomWord() {
        int randomIndex = (int) (Math.random() * words.length);
        return words[randomIndex];
    }
}
