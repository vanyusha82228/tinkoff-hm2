package edu.hm2.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConstantTest {
    @Test
    public void testConstant() {
        Expr constant = new Constant(5);
        double result = constant.evaluate();
        assertEquals(5.0, result, 0.001);
    }

}
