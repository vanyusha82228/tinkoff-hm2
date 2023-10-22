package com.example.project1;

import com.example.project1.game.Defeat;
import com.example.project1.game.FailedGuess;
import com.example.project1.game.GuessResult;
import com.example.project1.game.SuccessfulGuess;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsoleHangmanTest {

    @Test
    public void testExceedMaxAttempts() {
        Session session = new Session("banana", 3);
        session.guess('x');
        session.guess('y');
        session.guess('z');
        GuessResult result = session.guess('a'); // 4th attempt
        assertTrue(result instanceof Defeat);
    }

    @Test
    public void testCorrectGuess() {
        Session session = new Session("cherry", 5);
        GuessResult result = session.guess('c');
        assertTrue(result instanceof SuccessfulGuess);
    }

    @Test
    public void testIncorrectGuess() {
        Session session = new Session("date", 5);
        GuessResult result = session.guess('x');
        assertTrue(result instanceof FailedGuess);
    }
}
