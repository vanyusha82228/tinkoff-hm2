package edu.hw1;

public class Task8 {
    private static final int KNIGHT_MOVEMENTS = 8;
    private static final int[] KNIGHT_DX = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] KNIGHT_DY = {1, 2, 2, 1, -1, -2, -2, -1};

    @SuppressWarnings("unused")
    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 1) {
                    for (int k = 0; k < KNIGHT_MOVEMENTS; k++) {
                        int x = i + KNIGHT_DX[k];
                        int y = j + KNIGHT_DY[k];


                        if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}


