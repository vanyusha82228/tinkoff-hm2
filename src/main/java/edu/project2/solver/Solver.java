package edu.project2.solver;

import edu.project2.render.Coordinate;
import edu.project2.render.Maze;
import java.util.List;

public interface Solver {
    List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);
}
