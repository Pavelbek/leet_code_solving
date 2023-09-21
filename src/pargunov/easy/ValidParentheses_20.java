package pargunov.easy;

import java.util.*;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    private static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if(stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.size() == 0;
    }
}
