package org.airwallex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AppTest
{
    public App app;
    public String[] lines;
    public String expected_stack;

    @Before
    public void initialize(){
        app = new App();
    }

    public AppTest(String[] lines,String expected_stack){
        this.expected_stack =expected_stack;
        this.lines = lines;
    }

    @Parameterized.Parameters
    public static Collection stack_nums(){
        String[] lines1 = {"  ","  5 ","2  "};
        String[] lines2 = {"2 sqrt ","clear 9 sqrt"};
        String[] lines3 = {"5 2 - ","3 - ","clear"};
        String[] lines4 = {"5 4 3 2 ","undo undo * ","5 * ","undo"};
        String[] lines5 = {"7 12 2 /"," * ","4 /"};
        String[] lines6 = {"1 2 3 4 5 ","* clear ","3 4 -"};
        String[] lines7 = {"1 2 3 4 5"," * * * *"};
        String[] lines8 = {"1 2 3 * 5 + * * 6 5",};
        String[] lines9 = {"2"};
        String[] lines10 = {"3 0 ","/"};
        String[] lines11 = {"3 ","+"};
        String[] lines12 = {"3 2 + ","clear sqrt"};
        String[] lines13 = {"2 4 -"," sqrt"};
        String[] lines14 = {"undo undo undo undo"};
        return Arrays.asList(new Object[][]{
                {lines1,"stack: 5 2 "},
                {lines2,"stack: 3 "},
                {lines3,"stack: "},
                {lines4,"stack: 20 5 "},
                {lines5,"stack: 10.5 "},
                {lines6,"stack: -1 "},
                {lines7,"stack: 120 "},
                {lines8,"stack: 11 "},
                {lines9,"stack: 2 "},
                {lines10,"stack: 3 0 "},
                {lines11,"stack: 3 "},
                {lines12,"stack: "},
                {lines13,"stack: -2 "},
                {lines14,"stack: "}
        });
    }

    @Test
    public void testApp(){

        assertEquals(expected_stack,app.run(lines));
    }
}
