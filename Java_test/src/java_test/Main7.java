package java_test;

import java.util.Stack;

public class Main7 {

    public boolean chkParenthesis(String str, int length) {
        if (str == null || length == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (ch != '(' && ch != ')') {
                return false;
            } else if (ch == '(') {
                stack.add(ch);
            } else {
                char ret = stack.pop()
            }
        }
    }
}
