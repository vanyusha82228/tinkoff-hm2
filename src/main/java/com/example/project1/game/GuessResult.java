package com.example.project1.game;

import org.jetbrains.annotations.NotNull;

public sealed interface GuessResult permits Defeat, Win, SuccessfulGuess, FailedGuess {
    char[] state();

    int attempt();

    int maxAttempts();

    @NotNull String message();
}
