//LeetCode #20 Valid Parentheses
// Facebook frequent

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args){
        String input = "()[]}";
        System.out.println(isValid(input));
    }
    public static boolean isValid(String s){

        if(s.length()==0){
            return true;
        }

        if((s.length()%2)!=0 ){
            return false;
        }


        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()){
            if (c=='{' || c=='(' || c=='['){
                stack.push(c);
            }

            else{

                if(stack.empty()){
                    return false;
                }

                if(c=='}' && stack.peek() == '{'){
                    stack.pop();
                }

                else if(c==')' && stack.peek() == '('){
                    stack.pop();
                }

                else if(c==']' && stack.peek() == '['){
                    stack.pop();
                }

                else{
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
