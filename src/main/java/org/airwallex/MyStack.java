package org.airwallex;

import java.util.Stack;

public class MyStack {
    private Stack<Double> stack;                  //  the stack that can be shown to user
    private Stack<Double> backup_value;           //  this stack stores the value changed in the former manipulations
    private Stack<Integer> backup_num_changes;    //  this stack stores the number of values changed in each former manipulations
                                                  //  backup_value and backup_num_changes are both incremental backup


    public MyStack(){
        this.stack = new Stack<Double>();
        this.backup_value = new Stack<Double>();
        this.backup_num_changes = new Stack<Integer>();
    }


//    this function is only for JUnit test
    public  MyStack(double[] nums){
        this.stack = new Stack<Double>();
        this.backup_value = new Stack<Double>();
        this.backup_num_changes = new Stack<Integer>();
        for(double num: nums){
            this.stack.push(num);
        }
    }


//    this function is only for JUnit test
    public MyStack(double[] nums, double[] nums_changed,int[] num_changes){
        this.stack = new Stack<Double>();
        this.backup_value = new Stack<Double>();
        this.backup_num_changes = new Stack<Integer>();
        for(double num: nums){
            this.stack.push(num);
        }
        for(double num: nums_changed){
            this.backup_value.push(num);
        }
        for(int num: num_changes){
            this.backup_num_changes.push(num);
        }
    }


//    printStack() can return the String that shows the contents of the stack in the following form:
//    "stack: num1 num2 num3 ......"
    public String printStack(){
        String ans = "stack: ";
        for(double num:this.stack){
            String s = String.format("%.10f",num);
            s = s.replaceAll("0+$", "");
            s = s.replaceAll("\\.+$","");
            ans = ans + s+" ";
        }
        return ans;
    }

    public double pop_stack(){
        return stack.pop();
    }

    public void push_stack(double num){
        stack.push(num);
    }

    public double peek_stack(){
        return stack.peek();
    }

    public int sizeOfStack(){
        return stack.size();
    }

    public double pop_backup_value(){
        return backup_value.pop();
    }

    public void push_backup_value(double num){
        backup_value.push(num);
    }

    public int pop_num_changes(){
        return backup_num_changes.pop();
    }

    public void push_num_changes(int num){
        backup_num_changes.push(num);
    }

    public boolean stackIsEmpty(){
        return stack.isEmpty();
    }

    public boolean backupValueIsEmpty(){
        return backup_value.isEmpty();
    }

    public boolean numChangesIsEmpty(){
        return backup_num_changes.isEmpty();
    }

}
