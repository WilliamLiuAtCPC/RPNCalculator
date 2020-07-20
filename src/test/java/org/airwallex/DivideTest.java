package org.airwallex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DivideTest {
    MyStack myStack;
    String result;
    String ToF;
    double[] nums;

    @Before
    public void initialize(){
        myStack = new MyStack(nums);
    }

    public DivideTest(double[] nums,String s,String tof){
        this.nums = nums;
        this.result = s;
        this.ToF = tof;
    }

    @Parameterized.Parameters
    public static Collection stack_nums(){
        double[] stack_nums1 = {3.1,9,17,22,5};
        double[] stack_nums2 = {0.12345678901234567, 3.141592653285734};
        double[] stack_nums3 = {5, 0};
        double[] stack_nums4 = {9};
        return Arrays.asList(new Object[][]{
                {stack_nums1,"stack: 3.1 9 17 4.4 ","S001"},
                {stack_nums2,"stack: 0.0392975165 ","S001"},
                {stack_nums3,"stack: 5 0 ","E003"},
                {stack_nums4,"stack: 9 ","E001"},
        });
    }

    @Test
    public void testDivideTest(){
        Divide p = new Divide();
        String tof = p.operation(myStack);
        assertEquals(result,myStack.printStack());
        assertEquals(ToF,tof);
    }
}
