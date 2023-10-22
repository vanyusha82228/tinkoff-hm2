package edu.hm2.task4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CallerInfoTest {
    @Test
    public void testCallingInfo(){
        CallingInfo info = CallerInfo.callingInfo();

        assertEquals("edu.hm2.task4.CallerInfoTest",info.className());
        assertEquals("testCallingInfo",info.methodName());
    }

}
