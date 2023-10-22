package com.example.project1;

import com.example.project1.game.Defeat;
import com.example.project1.game.GuessResult;
import com.example.project1.game.Win;
import java.util.Scanner;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;

@Log4j2
public class ConsoleHangman {
    private final int maxAttempts;
    private Session session;
    private final Dictionary dictionary;

    public ConsoleHangman(Dictionary dictionary, int maxAttempts) {
        this.dictionary = dictionary;
        this.maxAttempts = maxAttempts;
    }

    public void run() {
        String wordToGuess = dictionary.randomWord();
        session = new Session(wordToGuess, maxAttempts);
        log.info("Welcome ");
        log.info("You have " + maxAttempts + " attempts.");
        log.info("Lets start");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            log.info("Guess a letter: ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                GuessResult giveUpResult = session.giveUp();
                printState(giveUpResult);
                break;
            } else if (input.length() != 1) {
                log.info("Please enter a single letter.");
            } else {
                char guess = input.charAt(0);
                GuessResult result = session.guess(guess);
                printState(result);

                if (result instanceof Win || result instanceof Defeat) {
                    break;
                }
            }
        }

    }

    private void printState(@NotNull GuessResult guess) {
        char[] state = guess.state();
        int attempts = guess.attempt();
        int maxAttempt = guess.maxAttempts();
        String message = guess.message();

        log.info(message);
        log.info("The word: " + String.valueOf(state));
        log.info("Mistakes: " + attempts + " out of " + maxAttempt);
        if (guess instanceof Win || guess instanceof Defeat) {
            session = new Session(dictionary.randomWord(), maxAttempt);
            log.info("New game started.");
        }
    }
}
