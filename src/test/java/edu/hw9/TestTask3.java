package edu.hw9;

import edu.hw9.task3.ParallelBreadthFirstSolver;
import edu.project2.render.Cell;
import edu.project2.render.Coordinate;
import edu.project2.render.Maze;
import edu.project2.solver.Solver;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask3 {
    @Test
    void testSolve() {
        Cell[][] grid = {
            {new Cell(0, 0, Cell.Type.PASSAGE), new Cell(0, 1, Cell.Type.PASSAGE), new Cell(0, 2, Cell.Type.PASSAGE)},
            {new Cell(1, 0, Cell.Type.PASSAGE), new Cell(1, 1, Cell.Type.PASSAGE), new Cell(1, 2, Cell.Type.PASSAGE)},
            {new Cell(2, 0, Cell.Type.PASSAGE), new Cell(2, 1, Cell.Type.WALL), new Cell(2, 2, Cell.Type.PASSAGE)}
        };

        Maze maze = new Maze(3, 3, grid);
        Solver solver = new ParallelBreadthFirstSolver(2);

        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(2, 2);

        List<Coordinate> path = solver.solve(maze, start, end);

        assertEquals(end, path.get(path.size() - 1));
    }
}
