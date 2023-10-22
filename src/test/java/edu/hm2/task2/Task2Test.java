package edu.hm2.task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    public void testRectangleArea(){
        Rectangle rectangle = new Rectangle(5,10);
        double expected = 5*10;
        assertEquals(expected,rectangle.area());
    }

    @Test
    public void testSquareArea(){
        Square square = new Square(6);
        double expected = 6*6;
        assertEquals(expected,square.area());
    }

    @Test
    public void testSquareSnape(){
        Square square = new Square(6);
        Shape shape = square;
        double expected = 6*6;
        assertEquals(expected,shape.area());
    }
}
