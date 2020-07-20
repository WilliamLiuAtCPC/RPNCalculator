package org.airwallex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OneWordProcessorTest {
    public Operator expected_result;
    public String word;
    public OneWordProcessor owp = new OneWordProcessor();

    @Before
    public void initialize(){
        owp = new OneWordProcessor();
    }

    public OneWordProcessorTest(String s, Operator op){
        this.expected_result =op;
        this.word= s;
    }

    @Parameterized.Parameters
    public static Collection stack_nums(){
        return Arrays.asList(new Object[][]{
                {"9",new Push(9)},
                {"0.12345678901234567",new Push(0.12345678901234567)},
                {"+",new Plus()},
                {"-",new Minus()},
                {"*",new Multiply()},
                {"/",new Divide()},
                {"sqrt",new Sqrt()},
                {"undo",new Undo()},
                {"clear",new Clear()},
                {"fake",new Waiting()}
        });
    }

    @Test
    public void testOneWordProcessor(){
        Operator p = owp.preprocessOneWord(word);
        assertTrue(isSame(expected_result,p));
    }

    public boolean isSame(Operator op1, Operator op2){
        if(op1.getClass() == op2.getClass()){
            if(op1 instanceof Push){
                if(((Push) op1).getNum()!=((Push) op2).getNum()) return false;
            }
            return true;
        }else{
            return false;
        }
    }
}
