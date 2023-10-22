package com.example.project1;

public class Main {
    private static final int MAX_ATTEMPTS = 5;

    private Main() {
    }

    public static void main(String[] args) {
        Dictionary dictionary = new MyDictionary();


        ConsoleHangman hangman = new ConsoleHangman(dictionary, MAX_ATTEMPTS);
        hangman.run();
    }
}
