package edu.hm3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    public void testAtbash(){
        String input = "Hello world!";
        String result = Task1.atbash(input);
        String expected = "Svool dliow!";
        assertEquals(expected,result);
    }
    @Test
    public void testAtbashWithComplexInput() {
        String input = "Any fool can write code that a computer can understand. Good programmers write " +
            "code that humans can understand. ― Martin Fowler";
        String expectedOutput = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih" +
            " dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        String result = Task1.atbash(input);
        assertEquals(expectedOutput, result);
    }
    @Test
    public void testAtbashEmptyInput(){
        String input = "";
        String result = Task1.atbash(input);
        String expected = "";
        assertEquals(expected,result);
    }
    @Test
    public void testAtbashInputNoOnlyLetter(){
        String input = "123 #$%a";
        String result = Task1.atbash(input);
        String expected = "123 #$%z";
        assertEquals(expected,result);
    }
}
