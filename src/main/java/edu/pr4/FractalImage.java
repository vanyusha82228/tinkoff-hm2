package edu.pr4;

public record FractalImage(Pixel[][] data, int width, int height) {
    public static FractalImage create(int width, int height) {
        Pixel[][] pixels = new Pixel[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixels[i][j] = new Pixel(0, 0, 0);
            }
        }
        return new FractalImage(pixels, width, height);
    }

    public boolean contains(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public Pixel pixel(int x, int y) {
        return data[x][y];
    }

    public void setPixel(int x, int y, Pixel pixel) {
        data[x][y] = pixel;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
}
