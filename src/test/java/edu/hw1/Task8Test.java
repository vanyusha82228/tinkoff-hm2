package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task8Test {
    @Test
    void testKnightBoardCaptureWithValidBoard() {
        int[][] board = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };
        assertTrue(Task8.knightBoardCapture(board));
    }

    @Test
    void testKnightBoardCaptureWithEmptyBoard() {
        int[][] board = new int[8][8];
        assertTrue(Task8.knightBoardCapture(board));
    }

    @Test
    void testKnightBoardCaptureWithSingleKnight() {
        int[][] board = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };
        assertTrue(Task8.knightBoardCapture(board));
    }

    @Test
    void testKnightBoardCaptureWithNoKnights() {
        int[][] board = new int[8][8];
        assertTrue(Task8.knightBoardCapture(board));
    }

}
