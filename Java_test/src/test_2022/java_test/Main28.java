package test_2022.java_test;

import java.util.*;

public class Main28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        ListNode root = new ListNode();
        ListNode cur = root;
        for (int i = 0; i < len; i++) {
            cur.next = new ListNode(scanner.nextInt());
            cur = cur.next;
        }
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        ListNode left = root;
        ListNode right = root;
        ListNode prev = root;
        ListNode next = root;
        for (int i = 0; i < start; i++) {
            left = left.next;
            if (i < start - 1) {
                prev = prev.next;
            }
        }
        Stack<ListNode> stack = new Stack<>();
        for (int i = 0; i < end; i++) {
            right = right.next;
            next = next.next;
            if (i < end - 1) {
                stack.push(right);
            }
        }
        next = next.next;
        ListNode node = right;
        for (int i = start; i < end; i++) {
            ListNode ret = stack.pop();
            node.next = ret;
            node = node.next;
        }
        left.next = next;
        prev.next = right;


    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
