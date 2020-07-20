package org.airwallex;


public class OneLineProcessor {

    private String warning = "";

//    processOneLine() can process one line that user input from console
    public void processOneLine(MyStack myStack, String line, char split_sign){
        int start = 0, end = 0;
        boolean is_continuous_whitespace = true;
        OneWordProcessor owp = new OneWordProcessor();
        for(int i = 0; i<line.length(); i++){
            if(is_continuous_whitespace){
                if(line.charAt(i)!=split_sign){
                    start = i;
                    is_continuous_whitespace = false;
                }
            }
            if(!is_continuous_whitespace){
                if(line.charAt(i)==split_sign||i+1 == line.length()){
                    if(line.charAt(i)==split_sign){
                        end = i;
                    }else{
                        end = i+1;
                    }
                    is_continuous_whitespace = true;
                    String word = line.substring(start,end);
                    Operator op = owp.preprocessOneWord(word);
                    if(!op.operation(myStack).equals("S001")) {// if the status code is not "S001", all further processing of the string will terminate
                        this.warning = "operator "+word+" (position: "+Integer.toString(start+1)+"): insufficient parameters";
                        System.out.println(this.warning);
                        break;
                    }

                }
            }
        }
        System.out.println(myStack.printStack());
    }

    public String getWarning(){
        return warning;
    }


}
