package org.airwallex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MultiplyTest {
    MyStack myStack;
    String result;
    String ToF;
    double[] nums;

    @Before
    public void initialize(){
        myStack = new MyStack(nums);
    }

    public MultiplyTest(double[] nums,String s,String tof){
        this.nums = nums;
        this.result = s;
        this.ToF = tof;
    }

    @Parameterized.Parameters
    public static Collection stack_nums(){
        double[] stack_nums1 = {3.1,9,17,22,5};
        double[] stack_nums2 = {0.12345678901234567, 3.141592653285734};
        double[] stack_nums3 = {5, 2};
        double[] stack_nums4 = {9};
        return Arrays.asList(new Object[][]{
                {stack_nums1,"stack: 3.1 9 17 110 ","S001"},
                {stack_nums2,"stack: 0.3878509414 ","S001"},
                {stack_nums3,"stack: 10 ","S001"},
                {stack_nums4,"stack: 9 ","E001"},
        });
    }

    @Test
    public void testMultiplyTest(){
        Multiply mm = new Multiply();
        String tof = mm.operation(myStack);
        assertEquals(result,myStack.printStack());
        assertEquals(ToF,tof);
    }
}
