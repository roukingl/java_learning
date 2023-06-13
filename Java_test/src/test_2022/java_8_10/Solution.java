package test_2022.java_8_10;

class Solution {

    // leetcode 19.删除链表的倒数第n个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode removeNode = getRemoveListNode(newHead, n);
        removeNode.next = removeNode.next.next;
        return newHead.next;
    }


    private ListNode getRemoveListNode(ListNode head, int n) {
        ListNode cur = head.next;
        while (n > 0) {
            cur = cur.next;
            n--;
        }
        ListNode prev = head;
        while (cur != null) {
            cur = cur.next;
            prev = prev.next;
        }
        return prev;
    }
}