package org.airwallex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OneLineProcessorTest {
    public OneLineProcessor olp;
    public MyStack myStack;
    public String line;
    public String expected_stack;
    public String expected_warning;

    @Before
    public void initialize(){
        olp = new OneLineProcessor();
        myStack = new MyStack();
    }

    public OneLineProcessorTest(String line,String expected_stack,String expected_warning){
        this.expected_stack =expected_stack;
        this.expected_warning= expected_warning;
        this.line = line;
    }

    @Parameterized.Parameters
    public static Collection stack_nums(){
        return Arrays.asList(new Object[][]{
                {"    5 2  ","stack: 5 2 ",""},
                {"2 sqrt clear 9 sqrt","stack: 3 ",""},
                {"5 2 - 3 - clear","stack: ",""},
                {"5 4 3 2 undo undo * 5 * undo","stack: 20 5 ",""},
                {"7 12 2 / * 4 /","stack: 10.5 ",""},
                {"1 2 3 4 5 * clear 3 4 -","stack: -1 ",""},
                {"1 2 3 4 5 * * * *","stack: 120 ",""},
                {"1 2 3 * 5 + * * 6 5","stack: 11 ","operator * (position: 15): insufficient parameters"},
                {"2","stack: 2 ",""},
                {"3 0 /","stack: 3 0 ","operator / (position: 5): insufficient parameters"},
                {"3 +","stack: 3 ","operator + (position: 3): insufficient parameters"},
                {"3 2 + clear sqrt","stack: ","operator sqrt (position: 13): insufficient parameters"},
                {"2 4 - sqrt","stack: -2 ","operator sqrt (position: 7): insufficient parameters"}

        });
    }

    @Test
    public void testOneLineProcessor(){
        olp.processOneLine(myStack,line,' ');
        assertEquals(expected_stack,myStack.printStack());
        assertEquals(expected_warning,olp.getWarning());
    }

}
