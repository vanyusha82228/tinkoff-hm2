package edu.project2.solver;

import edu.project2.render.Cell;
import edu.project2.render.Coordinate;
import edu.project2.render.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSolver implements Solver {
    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        boolean[][] visited = new boolean[maze.getHeight()][maze.getWidth()];
        Stack<Coordinate> stack = new Stack<>();
        Coordinate current = start;

        while (true) {
            visited[current.row()][current.col()] = true;
            path.add(current);

            if (current.equals(end)) {
                break;
            }

            List<Coordinate> neighbors = getNeighbors(maze, current);
            boolean foundUnvisitedNeighbor = false;

            for (Coordinate neighbor : neighbors) {
                if (!visited[neighbor.row()][neighbor.col()]) {
                    stack.push(current);
                    current = neighbor;
                    foundUnvisitedNeighbor = true;
                    break;
                }
            }

            if (!foundUnvisitedNeighbor) {
                if (stack.isEmpty()) {
                    break; // Нет пути
                }
                current = stack.pop();
            }
        }

        return path;
    }

    private List<Coordinate> getNeighbors(Maze maze, Coordinate current) {
        List<Coordinate> neighbors = new ArrayList<>();
        int row = current.row();
        int col = current.col();
        Cell[][] grid = maze.getGrid();
        int height = maze.getHeight();
        int width = maze.getWidth();

        // Проверяем соседей вверх, вниз, влево и вправо.
        // Учитываем наличие стен и не позволяем выходить за пределы лабиринта.
        if (row > 0 && grid[row - 1][col].type() != Cell.Type.WALL) {
            neighbors.add(new Coordinate(row - 1, col));
        }
        if (row < height - 1 && grid[row + 1][col].type() != Cell.Type.WALL) {
            neighbors.add(new Coordinate(row + 1, col));
        }
        if (col > 0 && grid[row][col - 1].type() != Cell.Type.WALL) {
            neighbors.add(new Coordinate(row, col - 1));
        }
        if (col < width - 1 && grid[row][col + 1].type() != Cell.Type.WALL) {
            neighbors.add(new Coordinate(row, col + 1));
        }

        return neighbors;
    }
}
