package org.airwallex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SqrtTest {
    MyStack myStack;
    String result;
    String ToF;
    double[] nums;

    @Before
    public void initialize(){
        myStack = new MyStack(nums);
    }

    public SqrtTest(double[] nums,String s,String tof){
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
        double[] stack_nums5 = {-1};
        double[] stack_nums6 = {};
        return Arrays.asList(new Object[][]{
                {stack_nums1,"stack: 3.1 9 17 22 2.2360679775 ","S001"},
                {stack_nums2,"stack: 0.123456789 1.7724538508 ","S001"},
                {stack_nums3,"stack: 5 0 ","S001"},
                {stack_nums4,"stack: 3 ","S001"},
                {stack_nums5,"stack: -1 ","E002"},
                {stack_nums6,"stack: ","E001"}
        });
    }

    @Test
    public void testSqrtTest(){
        Sqrt p = new Sqrt();
        String tof = p.operation(myStack);
        assertEquals(result,myStack.printStack());
        assertEquals(ToF,tof);
    }
}
