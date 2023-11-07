package edu.project2;

import static org.junit.jupiter.api.Assertions.*;

import edu.project2.inteface.Coordinate;
import edu.project2.inteface.Generator;
import edu.project2.inteface.Maze;
import edu.project2.inteface.Renderer;
import edu.project2.inteface.Solver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MazeSolverTests {

    private Generator generator;

    @BeforeEach
    public void setUp() {
        generator = new RecursiveBacktrackerGenerator();
    }

    @Test
    public void testMazeGeneratorAndSolver() {
        Generator generator = new RecursiveBacktrackerGenerator();
        Solver solver = new DepthFirstSolver(); // или другой ваш солвер
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
        Solver solver = new BreadthFirstSolver(); // или другой ваш солвер
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
}
