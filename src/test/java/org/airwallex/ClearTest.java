package org.airwallex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ClearTest {
    MyStack myStack;
    String expected_stack;
    String ToF;
    double[] nums;

    @Before
    public void initialize(){
        myStack = new MyStack(nums);
    }

    public ClearTest(double[] nums,String s,String tof){
        this.nums = nums;
        this.expected_stack = s;
        this.ToF = tof;
    }

    @Parameterized.Parameters
    public static Collection stack_nums(){
        double[] stack_nums1 = {3.1,9,17,22,5};
        double[] stack_nums2 = {0.12345678901234567, 3.141592653285734};
        double[] stack_nums3 = {5, 0};
        double[] stack_nums4 = {9};
        double[] stack_nums5 = {};
        return Arrays.asList(new Object[][]{
                {stack_nums1,"stack: ","S001"},
                {stack_nums2,"stack: ","S001"},
                {stack_nums3,"stack: ","S001"},
                {stack_nums4,"stack: ","S001"},
                {stack_nums5,"stack: ","S001"}
        });
    }

    @Test
    public void testClearTest(){
        Clear p = new Clear();
        String tof = p.operation(myStack);
        assertEquals(expected_stack,myStack.printStack());
        assertEquals(ToF,tof);
    }
}
