package day151;

import java.util.Stack;
//1190. 反转每对括号间的子串
public class day151exercise_1 {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '('){
                stack.push(sb.toString());
            }
            else if(s.charAt(i) == ')'){
                sb.reverse();
                sb.insert(0,stack.pop());
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
