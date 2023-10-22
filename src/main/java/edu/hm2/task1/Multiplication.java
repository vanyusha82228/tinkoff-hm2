package edu.hm2.task1;

public record Multiplication(Expr value1, Expr value2) implements Expr {
    @Override
    public double evaluate() {
        return value1.evaluate() * value2.evaluate();
    }
}
