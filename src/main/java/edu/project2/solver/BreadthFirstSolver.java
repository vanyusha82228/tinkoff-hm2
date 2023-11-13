package edu.project2.solver;

import edu.project2.render.Cell;
import edu.project2.render.Coordinate;
import edu.project2.render.Maze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSolver implements Solver {
    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        // Создайте новый список координат, который будет представлять путь
        List<Coordinate> path = new ArrayList<>();

        // Создайте новую матрицу для хранения информации о посещенных клетках
        boolean[][] visited = new boolean[maze.getHeight()][maze.getWidth()];

        // Создайте очередь для выполнения поиска в ширину
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(start);

        // Создайте матрицу предшественников
        Coordinate[][] predecessors = new Coordinate[maze.getHeight()][maze.getWidth()];

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            // Если достигли конечной точки, восстанавливаем путь и выходим из цикла
            if (current.equals(end)) {
                Coordinate traceBack = end;
                while (traceBack != null) {
                    path.add(traceBack);
                    traceBack = predecessors[traceBack.row()][traceBack.col()];
                }
                Collections.reverse(path);
                break;
            }

            visited[current.row()][current.col()] = true;

            // Получаем соседей текущей клетки
            List<Coordinate> neighbors = getNeighbors(maze, current);

            for (Coordinate neighbor : neighbors) {
                if (!visited[neighbor.row()][neighbor.col()]) {
                    queue.add(neighbor);
                    predecessors[neighbor.row()][neighbor.col()] = current;
                }
            }
        }

        return path;
}

    private List<Coordinate> getNeighbors(Maze maze, Coordinate current) {
        List<Coordinate> neighbors = new ArrayList<>();
        int row = current.row();
        int col = current.col();
        int height = maze.getHeight();
        int width = maze.getWidth();
        Cell[][] grid = maze.getGrid();

        // Проверяем соседей сверху, снизу, слева и справа
        // только если они не являются стенами
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
