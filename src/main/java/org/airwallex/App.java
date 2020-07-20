package org.airwallex;

import java.util.Scanner;

public class App
{
    public String run(){
        Scanner sc = new Scanner(System.in);
        String line = "";
        MyStack myStack = new MyStack();
        while(true){
            line = sc.nextLine();
            if(line.isEmpty()) break;
            OneLineProcessor pp = new OneLineProcessor();
            pp.processOneLine(myStack,line,' ');
        }
        return myStack.printStack();
    }


    //    this function is only for AppTest
    public String run(String[] lines){
        MyStack myStack = new MyStack();
        for(String line: lines){
            if(line.isEmpty()) break;
            OneLineProcessor pp = new OneLineProcessor();
            pp.processOneLine(myStack,line,' ');
        }
        return myStack.printStack();
    }

    public static void main( String[] args )
    {
        App calculator = new App();
        calculator.run();
    }
}
