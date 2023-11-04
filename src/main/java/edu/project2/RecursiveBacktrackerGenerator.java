package edu.project2;

import edu.project2.inteface.Cell;
import edu.project2.inteface.Generator;
import edu.project2.inteface.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class RecursiveBacktrackerGenerator implements Generator {
    @Override
    public Maze generate(int height, int width) {
        Cell[][] grid = new Cell[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[row][col] = new Cell(row, col, Cell.Type.WALL);
            }
        }

        Random random = new Random();
        int startRow = random.nextInt(height);
        int startCol = random.nextInt(width);

        Stack<Cell> stack = new Stack<>();
        Cell startCell = grid[startRow][startCol];
        grid[startRow][startCol] = new Cell(startCell.row(), startCell.col(), Cell.Type.PASSAGE);
        stack.push(startCell);

        while (!stack.isEmpty()) {
            Cell currentCell = stack.peek();
            List<Cell> neighbors = getUnvisitedNeighbors(currentCell, grid);
            if (!neighbors.isEmpty()) {
                Cell neighbor = neighbors.get(random.nextInt(neighbors.size()));
                removeWallBetween(currentCell, neighbor, grid);
                grid[neighbor.row()][neighbor.col()] = new Cell(neighbor.row(), neighbor.col(), Cell.Type.PASSAGE);
                stack.push(neighbor);
            } else {
                stack.pop();
            }
        }

        return new Maze(height, width, grid);
    }

    private List<Cell> getUnvisitedNeighbors(Cell cell, Cell[][] grid) {
        List<Cell> neighbors = new ArrayList<>();
        int row = cell.row();
        int col = cell.col();
        int height = grid.length;
        int width = grid[0].length;

        if (row > 1 && grid[row - 2][col].type() == Cell.Type.WALL) {
            neighbors.add(grid[row - 2][col]);
        }
        if (row < height - 2 && grid[row + 2][col].type() == Cell.Type.WALL) {
            neighbors.add(grid[row + 2][col]);
        }
        if (col > 1 && grid[row][col - 2].type() == Cell.Type.WALL) {
            neighbors.add(grid[row][col - 2]);
        }
        if (col < width - 2 && grid[row][col + 2].type() == Cell.Type.WALL) {
            neighbors.add(grid[row][col + 2]);
        }

        return neighbors;
    }

    private void removeWallBetween(Cell current, Cell neighbor, Cell[][] grid) {
        int rowDiff = neighbor.row() - current.row();
        int colDiff = neighbor.col() - current.col();
        int wallRow = current.row() + rowDiff / 2;
        int wallCol = current.col() + colDiff / 2;
        grid[wallRow][wallCol] = new Cell(wallRow, wallCol, Cell.Type.PASSAGE);
    }
}
