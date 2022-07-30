package java_7_29;

import java.util.Stack;

// leetcode 最小栈
class MinStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int val) {
        s1.push(val);
        if (s2.empty()) {
            s2.push(val);
        } else {
            if (s2.peek() > val) {
                s2.push(val);
            } else {
                s2.push(s2.peek());
            }
        }
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}