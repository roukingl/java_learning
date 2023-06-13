package test_2022.java_7_15;

import java.util.LinkedList;
import java.util.Queue;

// leetcode 225.用队列实现栈
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // 入栈
    public void push(int x) {
        q1.offer(x);
    }

    // 出栈
    public int pop() {
        if (empty()) {
            return -1;
        }
        if (!q1.isEmpty()) {
            int len = q1.size() - 1;
            for (int i = 0; i < len; i++) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        } else {
            int len = q2.size() - 1;
            for (int i = 0; i < len; i++) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        }
    }

    // 得到栈顶的元素
    public int top() {
        if (empty()) {
            return -1;
        }
        int tmp = -1;
        if (!q1.isEmpty()) {
            int len = q1.size();
            for (int i = 0; i < len; i++) {
                tmp = q1.peek();
                q2.offer(q1.poll());
            }
            return tmp;
        } else {
            int len = q2.size();
            for (int i = 0; i < len; i++) {
                tmp = q2.peek();
                q1.offer(q2.poll());
            }
            return tmp;
        }
    }

    // 判空
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}