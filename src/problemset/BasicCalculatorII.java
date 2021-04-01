import java.util.Stack;

public class BasicCalculatorII {

    public static void main(String[] args){
        System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));
    }


    public static int calculate(String s) {

        int output = 0;
        Stack<Integer> NumStack = new Stack();
        Stack<Character> CharStack = new Stack();
        int digitCount = 0;

        String temp ="";

        for(int i =0; i<s.length();i++){

            if(s.charAt(i)==' '){
                continue;
            }

            if(Character.isDigit(s.charAt(i))){
                temp+=s.charAt(i);
            }

            else{
                NumStack.push(Integer.parseInt(temp));
                temp = "";
                if(CharStack.size()!= 0 && CharStack.peek()=='*'){
                    int first = NumStack.pop();
                    int second = NumStack.pop();
                    NumStack.push(first*second);
                    CharStack.pop();
                }
                else if(CharStack.size()!= 0 && CharStack.peek()=='/'){
                    int first = NumStack.pop();
                    int second = NumStack.pop();
                    NumStack.push(second/first);
                    CharStack.pop();
                }

                else{
                    if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                        if(CharStack.size()!= 0 && CharStack.peek()=='-'){
                            CharStack.pop();
                            int first = NumStack.pop();
                            int second = NumStack.pop();
                            NumStack.push(second-first);
                        }
                    }
                }

                CharStack.push(s.charAt(i));
            }
        }

        if(temp!=""){
            NumStack.push(Integer.parseInt(temp));
        }

        while(CharStack.size()!=0){
            char tempChar = CharStack.pop();
            int first = NumStack.pop();
            int second = NumStack.pop();
            if(tempChar=='*'){
                NumStack.push(first*second);
            }
            else if(tempChar =='/'){

                NumStack.push(second/first);
            }
            else if(tempChar == '+'){

                NumStack.push(second+first);
            }
            else{
                NumStack.push(second-first);
            }
        }

        return NumStack.peek();

    }
}
