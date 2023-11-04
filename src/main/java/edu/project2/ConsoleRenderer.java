package edu.project2;

import edu.project2.inteface.Cell;
import edu.project2.inteface.Coordinate;
import edu.project2.inteface.Maze;
import edu.project2.inteface.Renderer;
import java.util.List;

public class ConsoleRenderer implements Renderer {
    @Override
    public String render(Maze maze) {
        int height = maze.getHeight();
        int width = maze.getWidth();
        Cell[][] grid = maze.getGrid();

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Cell cell = grid[row][col];
                if (cell.type() == Cell.Type.WALL) {
                    sb.append("█"); // Символ стены
                } else {
                    sb.append(" "); // Проход
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        int height = maze.getHeight();
        int width = maze.getWidth();
        Cell[][] grid = maze.getGrid();

        boolean[][] isPath = new boolean[height][width];
        for (Coordinate coordinate : path) {
            isPath[coordinate.row()][coordinate.col()] = true;
        }

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (isPath[row][col]) {
                    sb.append("X"); // Путь
                } else if (grid[row][col].type() == Cell.Type.WALL) {
                    sb.append("█"); // Символ стены
                } else {
                    sb.append(" "); // Проход
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}


