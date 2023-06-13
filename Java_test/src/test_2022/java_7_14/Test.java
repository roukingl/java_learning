package test_2022.java_7_14;

import java.util.Stack;

// leetcood 和 牛客网
public class Test {

    // 20.有效的括号
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
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (!stack.empty()) {
            return false;
        } else {
            return true;
        }
    }


    // leetcode 150 逆波兰表达式求值
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String x : tokens) {
            if (isOperator(x)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (x) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(x));
            }
        }
        return stack.pop();
    }

    public boolean isOperator(String x) {
        if (x.equals("+")  || x.equals("-") || x.equals("*")  || x.equals("/") ) {
            return true;
        }
        return false;
    }
}
