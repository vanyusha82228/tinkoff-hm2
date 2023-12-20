package edu.hw9.task3;

import edu.project2.render.Cell;
import edu.project2.render.Coordinate;
import edu.project2.render.Maze;
import edu.project2.solver.Solver;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ParallelBreadthFirstSolver implements Solver {
    private ExecutorService executorService;

    public ParallelBreadthFirstSolver(int numThreads) {
        this.executorService = Executors.newFixedThreadPool(numThreads);
    }

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        List<Coordinate> path = new CopyOnWriteArrayList<>();  // Используем потокобезопасный список
        boolean[][] visited = new boolean[maze.getHeight()][maze.getWidth()];
        ConcurrentLinkedQueue<Coordinate> queue = new ConcurrentLinkedQueue<>();  // Используем потокобезопасную очередь
        queue.add(start);

        Coordinate[][] predecessors = new Coordinate[maze.getHeight()][maze.getWidth()];

        while (!queue.isEmpty()) {
            List<Future<Void>> futures = new CopyOnWriteArrayList<>();

            while (!queue.isEmpty()) {
                Coordinate current = queue.poll();

                futures.add(executorService.submit(() -> {
                    visited[current.row()][current.col()] = true;

                    List<Coordinate> neighbors = getNeighbors(maze, current);

                    for (Coordinate neighbor : neighbors) {
                        if (!visited[neighbor.row()][neighbor.col()]) {
                            queue.add(neighbor);
                            predecessors[neighbor.row()][neighbor.col()] = current;
                        }
                    }
                    return null;
                }));
            }

            // Дождемся завершения всех потоков перед продолжением
            for (Future<Void> future : futures) {
                try {
                    future.get();
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            }
        }

        // Восстанавливаем путь, как и ранее
        Coordinate traceBack = end;
        while (traceBack != null) {
            path.add(traceBack);
            traceBack = predecessors[traceBack.row()][traceBack.col()];
        }
        Collections.reverse(path);

        return path;
    }

    private List<Coordinate> getNeighbors(Maze maze, Coordinate current) {
        List<Coordinate> neighbors = new CopyOnWriteArrayList<>();  // Используем потокобезопасный список
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
