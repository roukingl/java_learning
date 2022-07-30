package java_7_29;

import java.util.Stack;

class Solution {

    // leetcode 20.有效的括号
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    char tmp = stack.peek();
                    if ((ch == '}' && tmp == '{') || (ch == ']' && tmp == '[') || (ch == ')' && tmp == '(')) {
                        tmp = stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}