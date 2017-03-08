package esay;

import java.util.Stack;

/**
 * Created by yixinxin on 17/3/7.
 *
 * 20. Valid Parentheses
 *
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 1. isPair
 2. stack is not empty, then peek
 3. length is odd, return false
 *
 */
public class ValidParentheses {
    public boolean isPair(char c, char prec){
        if((c == '(' && prec == ')') || (c == ')' && prec == '('))
            return true;

        if((c == '[' && prec == ']') || (c == ']' && prec == '['))
            return true;

        if((c == '{' && prec == '}') || (c == '}' && prec == '{'))
            return true;

        return false;
    }

    public boolean isValid(String s) {
        if(s == "" || s.length() == 0)
            return true;

        // the length is odd
        if(s.length() % 2 == 1)
            return false;

        Stack stack = new Stack();
        char character = s.charAt(0);
        stack.push(character);

        char preCharacter = 0;
        for(int i = 1; i < s.length(); i++){
            character = s.charAt(i);
            // stack is not empty, then peek. Otherwise push
            if(!stack.empty())
                preCharacter = (char)stack.peek();

            if (isPair(character,preCharacter))
                stack.pop();
            else
                stack.push(character);
        }

        return stack.empty();
    }


    // otherway
    public boolean isValid2(String s) {
        if(s == "" || s.length() == 0)
            return true;

        // the length is odd
        if(s.length() % 2 == 1)
            return false;

        Stack<Character> stack = new Stack<>();
        for (char cha : s.toCharArray()){
            switch (cha){
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != cha){ // isPair
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        ValidParentheses validParentheses = new ValidParentheses();

        System.out.println(validParentheses.isValid("(){}[]"));
    }

}
