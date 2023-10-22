package edu.hm2.task2;

public class Square implements Shape {
    private final Rectangle rectangle;

    public Square(int side) {
        this.rectangle = new Rectangle(side, side);
    }

    @Override
    public int getWidth() {
        return rectangle.getWidth();
    }

    @Override
    public int getHeight() {
        return rectangle.getWidth();
    }

    @Override
    public double area() {
        return rectangle.area();
    }
}
