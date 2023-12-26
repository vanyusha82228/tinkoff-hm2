package edu.pr4;

import java.awt.Color;
import java.util.Random;

public class FractalRenderer {
    private static final double XMIN = -1.777;
    private static final double XMAX = 1.777;
    private static final double YMIN = -1;
    private static final double YMAX = 1;

    private static final int MAX_ITERATIONS = 20; // Максимальное количество итераций
    private static final double COLOR_SCALE = 255.0; // Масштаб для цветов (0-255)
    private static final int NUM_TRANSFORMATIONS = 10; // Количество цветовых преобразований
    private static final int COLOR_COMPONENT_MAX = 256; // Максимальное значение компонента цвета
    private static final int NUM_6 = 6;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;


    private FractalRenderer() {
    }

    public static FractalImage render(int n, int eqCount, int it, int xRes, int yRes, int symmetries, double gamma) {
        FractalImage fractalImage = FractalImage.create(xRes, yRes);
        Transformation[] transformations = generateTransformations(eqCount, symmetries);

        for (int num = 0; num < n; num++) {
            double newX = getRandom(XMIN, XMAX);
            double newY = getRandom(YMIN, YMAX);

            for (int step = -MAX_ITERATIONS; step < it; step++) {
                int i = (int) getRandom(0, eqCount);
                Point transformedPoint = transformations[i].transform(new Point(newX, newY));

                if (step >= 0 && fractalImage.contains((int) transformedPoint.x(), (int) transformedPoint.y())) {
                    int x1 = (int) ((XMAX - transformedPoint.x()) / (XMAX - XMIN) * xRes);
                    int y1 = (int) ((YMAX - transformedPoint.y()) / (YMAX - YMIN) * yRes);

                    if (fractalImage.contains(x1, y1)) {
                        // Логика обновления цвета пикселя
                        Pixel currentPixel = fractalImage.pixel(x1, y1);
                        Pixel updatedPixel = calculateUpdatedPixel(currentPixel, i, gamma);
                        fractalImage.setPixel(x1, y1, updatedPixel);
                    }
                }
            }
        }

        return fractalImage;
    }

    private static Pixel calculateUpdatedPixel(Pixel currentPixel, int i, double gamma) {
        Color[] colors = generateColors();

        double newR = currentPixel.r() + colors[i].getRed() / COLOR_SCALE;
        double newG = currentPixel.g() + colors[i].getGreen() / COLOR_SCALE;
        double newB = currentPixel.b() + colors[i].getBlue() / COLOR_SCALE;

        Pixel updatedPixel = currentPixel.updateColor(newR, newG, newB);
        return applyGammaCorrection(updatedPixel, gamma);
    }

    private static Pixel applyGammaCorrection(Pixel pixel, double gamma) {
        double correctedR = Math.pow(pixel.r(), 1.0 / gamma);
        double correctedG = Math.pow(pixel.g(), 1.0 / gamma);
        double correctedB = Math.pow(pixel.b(), 1.0 / gamma);

        return new Pixel(correctedR, correctedG, correctedB);
    }

    private static Color[] generateColors() {
        Color[] colors = new Color[NUM_TRANSFORMATIONS];

        Random random = new Random();
        for (int i = 0; i < NUM_TRANSFORMATIONS; i++) {
            int red = random.nextInt(COLOR_COMPONENT_MAX);
            int green = random.nextInt(COLOR_COMPONENT_MAX);
            int blue = random.nextInt(COLOR_COMPONENT_MAX);
            colors[i] = new Color(red, green, blue);
        }

        return colors;
    }

    private static Transformation[] generateTransformations(int eqCount, int symmetries) {
        Transformation[] transformations = new Transformation[eqCount * symmetries];
        Random random = new Random();

        for (int i = 0; i < eqCount; i++) {
            double[] coeff = generateCoefficients(random);

            for (int sym = 0; sym < symmetries; sym++) {
                double angle = 2 * Math.PI * sym / symmetries;
                transformations[i * symmetries + sym] = createSymmetricTransformation(coeff, angle);
            }
        }

        return transformations;
    }

    private static double[] generateCoefficients(Random random) {
        double[] coeff = new double[NUM_6];

        for (int j = 0; j < NUM_6; j++) {
            coeff[j] = random.nextDouble();
        }

        return coeff;
    }

    private static Transformation createSymmetricTransformation(double[] coeff, double angle) {
        return point -> {
            double resultX = coeff[0] * point.x() + coeff[1] * point.y() + coeff[2];
            double resultY = coeff[NUM_3] * point.x() + coeff[NUM_4] * point.y() + coeff[NUM_5];

            double cos = Math.cos(angle);
            double sin = Math.sin(angle);
            double x = resultX * cos - resultY * sin;
            double y = resultX * sin + resultY * cos;

            return new Point(x, y);
        };
    }

    private static double getRandom(double min, double max) {
        return min + (max - min) * Math.random();
    }
}
