package edu.pr4;

public record Pixel(double r, double g, double b) {
    public Pixel updateColor(double newR, double newG, double newB) {
        return new Pixel(newR, newG, newB);
    }
}
