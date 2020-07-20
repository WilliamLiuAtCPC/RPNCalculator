package org.airwallex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PushTest {
    MyStack myStack;
    String result;
    double[] nums;

    @Before
    public void initialize(){
        myStack = new MyStack();
    }

    public PushTest(double[] nums,String s){
        this.nums = nums;
        this.result = s;
    }

    @Parameterized.Parameters
    public static Collection stack_nums(){
        double[] stack_nums1 = {3.1,9,17,22,5};
        double[] stack_nums2 = {0.12345678901234567, 3.141592653285734, 0, 9999999};
        double[] stack_nums3 = {5, 2};
        return Arrays.asList(new Object[][]{
                {stack_nums1,"stack: 3.1 9 17 22 5 "},
                {stack_nums2,"stack: 0.123456789 3.1415926533 0 9999999 "},
                {stack_nums3,"stack: 5 2 "}
        });
    }

    @Test
    public void testPushTest(){
        for(double num:nums){
            Push p = new Push(num);
            p.operation(myStack);
        }
        assertEquals(result,myStack.printStack());
    }

}
