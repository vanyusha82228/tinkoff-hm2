package edu.project2;

import edu.project2.generator.Generator;
import edu.project2.generator.RecursiveBacktrackerGenerator;
import edu.project2.render.Cell;
import edu.project2.render.Coordinate;
import edu.project2.render.Maze;
import edu.project2.solver.BreadthFirstSolver;
import edu.project2.solver.DepthFirstSolver;
import edu.project2.solver.Solver;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MazeSolverTests {
    private final BreadthFirstSolver solver = new BreadthFirstSolver();

    private Generator generator;

    @BeforeEach
    public void setUp() {
        generator = new RecursiveBacktrackerGenerator();
    }

    @Test
    public void testMazeGeneratorAndSolver() {
        Generator generator = new RecursiveBacktrackerGenerator();
        Solver solver = new DepthFirstSolver();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(9, 9);

        for (int i = 0; i < 100; i++) {
            Maze maze = generator.generate(10, 10);
            List<Coordinate> path = solver.solve(maze, start, end);
            assertFalse(path.isEmpty(), "Solver should find a path.");
        }
    }

    @Test
    public void testMazeGeneratorAndSolverBreadth() {
        Generator generator = new RecursiveBacktrackerGenerator();
        Solver solver = new BreadthFirstSolver();
        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(9, 9);

        for (int i = 0; i < 100; i++) {
            Maze maze = generator.generate(10, 10);
            List<Coordinate> path = solver.solve(maze, start, end);
            assertFalse(!path.isEmpty(), "Solver should find a path.");
        }
    }

    @Test
    public void testInvalidMazeSize() {
        assertThrows(IllegalArgumentException.class, () -> generator.generate(0, 0), "Maze size should be positive.");
    }

    @Test
    public void testValidMazeSolver() {

        Cell[][] cells = {
            {new Cell(0, 0, Cell.Type.PASSAGE), new Cell(0, 1, Cell.Type.WALL), new Cell(0, 2, Cell.Type.PASSAGE)},
            {new Cell(1, 0, Cell.Type.PASSAGE), new Cell(1, 1, Cell.Type.PASSAGE), new Cell(1, 2, Cell.Type.PASSAGE)},
            {new Cell(2, 0, Cell.Type.WALL), new Cell(2, 1, Cell.Type.WALL), new Cell(2, 2, Cell.Type.PASSAGE)}
        };
        Maze maze = new Maze(3, 3, cells);

        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(2, 2);

        List<Coordinate> path = solver.solve(maze, start, end);
        assertFalse(path.isEmpty(), "Solver should find a path in a valid maze.");
    }

    @Test
    public void testInvalidMazeSolver() {

        Cell[][] cells = {
            {new Cell(0, 0, Cell.Type.WALL), new Cell(0, 1, Cell.Type.WALL), new Cell(0, 2, Cell.Type.WALL)},
            {new Cell(1, 0, Cell.Type.WALL), new Cell(1, 1, Cell.Type.WALL), new Cell(1, 2, Cell.Type.WALL)},
            {new Cell(2, 0, Cell.Type.WALL), new Cell(2, 1, Cell.Type.WALL), new Cell(2, 2, Cell.Type.WALL)}
        };
        Maze maze = new Maze(3, 3, cells);

        Coordinate start = new Coordinate(0, 0);
        Coordinate end = new Coordinate(2, 2);

        List<Coordinate> path = solver.solve(maze, start, end);
        assertTrue(path.isEmpty(), "Solver should not find a path in an invalid maze.");
    }
}
