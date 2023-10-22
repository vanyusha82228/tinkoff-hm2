package com.example.project1;

import com.example.project1.game.Defeat;
import com.example.project1.game.FailedGuess;
import com.example.project1.game.GuessResult;
import com.example.project1.game.SuccessfulGuess;
import com.example.project1.game.Win;
import org.jetbrains.annotations.NotNull;

public class Session {
    private final String answer;
    private final int maxAttempts;
    private char[] userAnswer;
    private int attempts;

    public Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.userAnswer = new char[answer.length()];
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }

    @NotNull
    public GuessResult guess(char guess) {
        if (attempts >= maxAttempts) {
            return new Defeat(userAnswer, attempts, maxAttempts, "You lost!");
        }

        char[] newAnswer = userAnswer.clone();
        boolean hit = false;

        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                newAnswer[i] = guess;
                hit = true;
            }
        }
        if (hit) {
            userAnswer = newAnswer; // Обновляем userAnswer

            if (String.valueOf(userAnswer).equals(answer)) {
                return new Win(userAnswer, attempts, maxAttempts, "WIN");
            }
            return new SuccessfulGuess(userAnswer, attempts, maxAttempts, "HIt");
        } else {
            attempts++;
            if (attempts == maxAttempts) {
                return new Defeat(userAnswer, attempts, maxAttempts, "You lost");
            }
            return new FailedGuess(userAnswer, attempts, maxAttempts, "Missed, mistake " + attempts
                + " out of " + maxAttempts + ".");
        }
    }

    @NotNull GuessResult giveUp() {
        return new Defeat(userAnswer, attempts, maxAttempts, "You gave up");
    }
}
