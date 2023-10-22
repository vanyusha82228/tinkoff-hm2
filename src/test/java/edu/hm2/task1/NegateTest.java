package edu.hm2.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NegateTest {
    @Test
    public void testNegate(){
        Expr negate = new Negate(new Constant(3));
        double result = negate.evaluate();
        assertEquals(-3,result);
    }

}
