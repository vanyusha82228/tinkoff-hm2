package edu.hm2.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {
    @Test
    public void testMultiplication(){
        Expr multiplication = new Multiplication(new Constant(5),new Constant(2));
        double expected = 10;
        double result = multiplication.evaluate();
        assertEquals(expected,result,0.001);
    }

}
