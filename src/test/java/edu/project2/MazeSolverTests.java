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
    private Solver solver;
    private Renderer renderer;

    @BeforeEach
    public void setUp() {
        generator = new RecursiveBacktrackerGenerator();
        solver = new BreadthFirstSolver();
        renderer = new ConsoleRenderer();
    }

    @Test
    public void testMazeSolverFindsPath() {
        Maze maze = generator.generate(10, 10);
        Coordinate start = new Coordinate(1, 1);
        Coordinate end = new Coordinate(8, 8);
        List<Coordinate> path = solver.solve(maze, start, end);
        assertFalse(path.isEmpty(), "Solver should find a path.");
    }

//    @Test
//    public void testMazeSolverNoPath() {
//        Maze maze = generator.generate(10, 10);
//        Coordinate start = new Coordinate(1, 1);
//        Coordinate end = new Coordinate(8, 8);
//        List<Coordinate> path = solver.solve(maze, start, end);
//        assertTrue(path.isEmpty(), "Solver should not find a path.");
//    }
//
//    @Test
//    public void testRenderMaze() {
//        Maze maze = generator.generate(10, 10);
//        String expected = """
//            █ █ █ █ █ █ █ █ █ █
//            █       █       █ █
//            █ █ █ █ █ █ █   █ █
//            █   █       █ █ █ █
//            █ █ █ █ █ █   █   █
//            █   █   █ █ █ █ █ █
//            █ █ █ █ █ █ █   █ █
//            █       █       █ █
//            █ █ █ █ █ █ █ █ █ █
//            """;
//        String renderedMaze = renderer.render(maze);
//        assertEquals(expected.trim(), renderedMaze.trim(), "Rendered maze should match the expected output.");
//    }
//
//    @Test
//    public void testRenderPath() {
//        Maze maze = generator.generate(10, 10);
//        Coordinate start = new Coordinate(1, 1);
//        Coordinate end = new Coordinate(8, 8);
//        List<Coordinate> path = solver.solve(maze, start, end);
//        String expected = """
//            █ █ █ █ █ █ █ █ █ █
//            █ X X X X X X X X █
//            █ █ █ █ █ █ █   X █
//            █   X X X X   X X █
//            █ █ █ █ █ █ █   X █
//            █   X   X X X X X █
//            █ █ X X X X X X X █
//            █       █       X █
//            █ █ █ █ █ █ █ █ █ █
//            """;
//        String renderedMaze = renderer.render(maze, path);
//        assertEquals(expected.trim(), renderedMaze.trim(), "Rendered maze with path should match the expected output.");
//    }

    @Test
    public void testInvalidMazeSize() {
        assertThrows(IllegalArgumentException.class, () -> generator.generate(0, 0), "Maze size should be positive.");
    }
}
