package org.airwallex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UndoTest {
    MyStack myStack;
    double[] stack;
    double[] backup_value;
    int[] num_changes;
    String ToF;
    String expected_stack;

    @Before
    public void initialize(){
        myStack = new MyStack(stack,backup_value,num_changes);
    }

    public UndoTest(double[] nums,double[] backup_value,int[] num_changes,String s,String tof){
        this.stack = nums;
        this.expected_stack = s;
        this.ToF = tof;
        this.backup_value = backup_value;
        this.num_changes = num_changes;
    }

    @Parameterized.Parameters
    public static Collection stack_nums(){
        double[] stack1 = {1,2,3,4}; double[] backup_value1 = {1,3}; int[] num_changes1 = {2};
        double[] stack2 = {}; double[] backup_value2 = {}; int[] num_changes2 = {};
        double[] stack3 = {3}; double[] backup_value3 = {9}; int[] num_changes3 = {1};
        double[] stack4 = {}; double[] backup_value4 = {1,2,3,4}; int[] num_changes4 = {4};
        return Arrays.asList(new Object[][]{
                {stack1,backup_value1,num_changes1,"stack: 1 2 3 3 1 ","S001"},
                {stack2,backup_value2,num_changes2,"stack: ","S001"},
                {stack3,backup_value3,num_changes3,"stack: 9 ","S001"},
                {stack4,backup_value4,num_changes4,"stack: 4 3 2 1 ","S001"},
        });
    }

    @Test
    public void testUndoTest(){
        Undo p = new Undo();
        String tof = p.operation(myStack);
        assertEquals(expected_stack,myStack.printStack());
        assertEquals(ToF,tof);
    }


}
