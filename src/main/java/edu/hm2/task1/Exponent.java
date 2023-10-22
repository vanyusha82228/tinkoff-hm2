package edu.hm2.task1;

public record Exponent(Expr value1, int value2) implements Expr {
    @Override
    public double evaluate() {

        return Math.pow(value1.evaluate(), value2);
    }
}
