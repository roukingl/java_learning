package java_7_29;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// leetcode 225.用两个队列实现栈
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.offer(x);
    }
    
    public int pop() {
        if (empty()) {
            return -1;
        }
        if (!queue1.isEmpty()) {
            int len = queue1.size() - 1;
            for (int i = 0; i < len; i++) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else {
            int len = queue2.size() - 1;
            for (int i = 0; i < len; i++) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }
    
    public int top() {
        if (empty()) {
            return -1;
        }
        if (!queue1.isEmpty()) {
            int len = queue1.size();
            int tmp = 0;
            for (int i = 0; i < len; i++) {
                tmp = queue1.peek();
                queue2.offer(queue1.poll());
            }
            return tmp;
        } else {
            int len = queue2.size();
            int tmp = 0;
            for (int i = 0; i < len; i++) {
                tmp = queue2.peek();
                queue1.offer(queue2.poll());
            }
            return tmp;
        }
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}