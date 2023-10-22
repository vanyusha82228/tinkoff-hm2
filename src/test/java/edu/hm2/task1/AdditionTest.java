package edu.hm2.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {
    @Test
    public void testAddition(){
        Expr addition = new Addition(new Constant(3),new Constant(4));
        double expected = 7;
        double result = addition.evaluate();
        assertEquals(expected,result,0.001);
    }

}
