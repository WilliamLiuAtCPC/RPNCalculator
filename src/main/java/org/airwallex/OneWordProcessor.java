package org.airwallex;

public class OneWordProcessor {
//  preprocessOneWord() will recognize the contents of a word in an input command line, and return a corresponding operator
    public Operator preprocessOneWord( String word){
        if(word.matches("-?[0-9]+(\\.[0-9]+)?")){
            return new Push(Double.parseDouble(word));
        }

        switch (word){
            case "+":  return new Plus();
            case "-":  return new Minus();
            case "*":  return new Multiply();
            case "/":  return new Divide();
            case "sqrt":  return new Sqrt();
            case "undo": return new Undo();
            case "clear": return new Clear();
        }
        return new Waiting();
    }
}
