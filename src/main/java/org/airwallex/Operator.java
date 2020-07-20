package org.airwallex;

public abstract class Operator {//the abstract class for all operators
//    each operation will return a Status Code
//    "S001": success
//    "E001": insufficient parameters
//    "E002": square of real number can not be negative
//    "E003": divisor cannot be zero
    public abstract String operation(MyStack myStack);
}

class Push extends Operator {//the operator that can push values onto the stack
    private double num;

    public Push(double num){
        this.num = num;
    }

    @Override
    public String operation(MyStack myStack) {
        myStack.push_stack(this.num);
        myStack.push_num_changes(0);
        return "S001";// Success
    }

    public double getNum(){
        return num;
    }
}

//  +
class Plus extends Operator {
    @Override
    public String operation(MyStack myStack) {
        if(myStack.sizeOfStack()>=2){
            double a = myStack.pop_stack();
            double b = myStack.pop_stack();
            myStack.push_stack(a + b);
            myStack.push_backup_value(a);
            myStack.push_backup_value(b);
            myStack.push_num_changes(2);
            return "S001";// Success
        }else{
            return "E001"; // insufficient numbers
        }
    }
}

//  -
class Minus extends Operator {
    @Override
    public String operation(MyStack myStack) {
        if(myStack.sizeOfStack()>=2){
            double a = myStack.pop_stack();
            double b = myStack.pop_stack();
            myStack.push_stack(b - a);
            myStack.push_backup_value(a);
            myStack.push_backup_value(b);
            myStack.push_num_changes(2);
            return "S001";// Success
        }else{
            return "E001"; // insufficient numbers
        }

    }
}

//  *
class Multiply extends Operator {

    @Override
    public String operation(MyStack myStack) {
        if(myStack.sizeOfStack()>=2){
            double a = myStack.pop_stack();
            double b = myStack.pop_stack();
            myStack.push_stack(a * b);
            myStack.push_backup_value(a);
            myStack.push_backup_value(b);
            myStack.push_num_changes(2);
            return "S001"; // Success
        }else{
            return "E001"; // insufficient numbers
        }

    }
}

//  /
class Divide extends Operator {

    @Override
    public String operation(MyStack myStack) {
        if(myStack.sizeOfStack()<2){
            return "E001"; // insufficient numbers
        }
        if(myStack.peek_stack()==0) {
            return "E003"; // divisor cannot be 0
        }
        double a = myStack.pop_stack();
        double b = myStack.pop_stack();
        myStack.push_stack(b / a);
        myStack.push_backup_value(a);
        myStack.push_backup_value(b);
        myStack.push_num_changes(2);
        return "S001"; // Success
    }
}

//  sqrt
class Sqrt extends Operator {

    @Override
    public String operation(MyStack myStack) {
         if(myStack.sizeOfStack()<1){
             return "E001"; // insufficient numbers
         }
         if(myStack.peek_stack()<0){
             return "E002"; // squared real number can not be negative
         }
         double a = myStack.pop_stack();
         myStack.push_stack(Math.sqrt(a));
         myStack.push_backup_value(a);
         myStack.push_num_changes(1);
         return "S001"; // Success
    }
}

//  undo
class Undo extends Operator {

    @Override
    public String operation(MyStack myStack) {
        if(!myStack.numChangesIsEmpty()){
            int num_changes = myStack.pop_num_changes();
            if(!myStack.stackIsEmpty()) myStack.pop_stack();
            while(num_changes>0){
                num_changes--;
                myStack.push_stack(myStack.pop_backup_value());
            }
        }
        return "S001"; // Success
    }
}

//  clear
class Clear extends Operator {

    @Override
    public String operation(MyStack myStack) {
        int i = 0;
        while(!myStack.stackIsEmpty()){
            myStack.push_backup_value(myStack.pop_stack());
            i++;
        }
        if(i>0) myStack.push_num_changes(i);
        return "S001"; // Success
    }
}

//  used for undefined operator, if user input an unknown operator, the stack won't be changed
class Waiting extends Operator {

    @Override
    public String operation(MyStack myStack) {
//        System.out.println("warning: operator is not defined! ");
        return "S001"; // Success
//        I think we need to have a discussion on this condition, maybe it should be considered as an error:
//        then we should rewrite it as: return "E004";
    }
}

