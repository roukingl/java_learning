package java_7_31;

import java.util.List;

public class Solution {

    // BM2 链表内指定区间反转
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode prev = node;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode leftNode = prev.next;
        ListNode rightNode = prev.next;
        for (int i = 0; i < right - left; i++) {
            rightNode = rightNode.next;
        }
        ListNode next = rightNode.next;
        prev.next = null;
        rightNode.next = null;
        reverse(leftNode);
        prev.next = rightNode;
        leftNode.next = next;
        return node.next;
    }

    public void reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
    }

    // nowcoder BM3 链表中的节点每k个一组翻转
    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
    }
}







