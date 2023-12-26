package edu.pr4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestPr4 {
    @Test
    public void render_ReturnsNonNullFractalImage() {
        int n = 1000;
        int eqCount = 5;
        int it = 100;
        int xRes = 800;
        int yRes = 600;
        int symmetries = 4;
        double gamma = 2.2;

        FractalImage fractalImage = FractalRenderer.render(n, eqCount, it, xRes, yRes, symmetries, gamma);

        assertNotNull(fractalImage);
    }

    @Test
    public void renderParallel_ReturnsNonNullFractalImage() {
        int n = 1000;
        int eqCount = 5;
        int it = 100;
        int xRes = 800;
        int yRes = 600;
        int symmetries = 4;
        double gamma = 2.2;

        FractalImage fractalImage =
            new ParallelFractalGenerator(n, eqCount, it, xRes, yRes, symmetries, gamma).renderParallel();

        assertNotNull(fractalImage);
    }
}
