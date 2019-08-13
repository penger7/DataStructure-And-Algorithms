package wp.org.stack;

import java.util.LinkedList;

public class BracketsMatch {

    public static void main(String[] args){
        System.out.println(isValid("(])"));
    }
    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        if(s.isEmpty()){
            return true;
        }
        char[] cArray = s.toCharArray();
        for (char c:cArray) {
            char tmp = 'n';
            switch (c){
                case ')':
                    tmp = '(';
                    break;
                case ']':
                    tmp = '[';
                    break;
                case '}':
                    tmp = '{';
                    break;
            }
            if(stack.isEmpty()){
                stack.push(c);
            }else {
                if('n' != tmp){
                    if(stack.peek() == tmp){
                        stack.pop();
                    }else {
                        stack.push(c);
                    }
                }else {
                    stack.push(c);
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
