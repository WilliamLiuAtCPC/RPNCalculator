package org.airwallex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MyStackTest {
    MyStack myStack;
    String result;
    double[] nums;

    @Before
    public void initialize(){
        myStack = new MyStack(nums);
    }

    public MyStackTest(double[] nums,String s){
        this.nums = nums;
        this.result = s;
//        System.out.println(myStack.printStack());
    }

    @Parameterized.Parameters
    public static Collection stack_nums(){
        double[] stack_nums1 = {3.1,9,17,22,5};
        double[] stack_nums2 = {0.12345678901234567, 3.141592653285734, 0, 9999999};
        return Arrays.asList(new Object[][]{
                {stack_nums1,"stack: 3.1 9 17 22 5 "},
                {stack_nums2,"stack: 0.123456789 3.1415926533 0 9999999 "},
        });
    }

    @Test
    public void testMyStackTest(){
        assertEquals(result,myStack.printStack());
    }
}
