package test_2022.java_7_15;

// leetcode 155 最小栈

/*
class ListNode {

    // 存放的值
    public int value;

    // 下一个节点的引用
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int value) {

        this.value = value;
    }

}
class MinStack {

    ListNode head;

    public MinStack() {

    }
    
    public void push(int val) {
        ListNode cur = new ListNode(val);
        if (head == null) {
            head = cur;
        } else {
            cur.next = head;
            head = cur;
        }
    }
    
    public void pop() {
        if (head == null) {
            return;
        } else {
            head = head.next;
        }
    }
    
    public int top() {
        if (head == null) {
            return -1;
        } else {
            return head.value;
        }
    }
    
    public int getMin() {
        ListNode cur = head.next;
        int min = head.value;
        while (cur != null) {
            if (cur.value < min) {
                min = cur.value;
            }
            cur = cur.next;
        }
        return min;
    }
}
*/

import java.util.Stack;


class MinStack {

    Stack<Integer> mStack;
    Stack<Integer> aStack;

    public MinStack() {
        mStack = new Stack<>();
        aStack = new Stack<>();
    }

    public void push(int x) {
        mStack.push(x);
        if (aStack.empty()) {
            aStack.push(x);
        } else {
            aStack.push(Math.min(aStack.peek(), x));
        }
    }

    public void pop() {
        mStack.pop();
        aStack.pop();
    }

    public int top() {
        return mStack.peek();
    }

    public int getMin() {
        return aStack.peek();
    }
}