package edu.hm2.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExponentTest {
    @Test
    public void testExponent(){
        Expr exponent = new Exponent(new Constant(2),2);
        double expected = 4;
        double result = exponent.evaluate();
        assertEquals(expected,result,0.001);
    }

}
