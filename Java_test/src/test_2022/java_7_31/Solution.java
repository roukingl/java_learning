package test_2022.java_7_31;

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
    /*public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
    }*/

    //BM4 合并两个排序的链表
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                while (cur1.next != null && cur1.next.val <= cur2.val) {
                    cur1 = cur1.next;
                }
                ListNode cur1Next = cur1.next;
                cur1.next = cur2;
                cur1 = cur1Next;
            } else {
                while (cur2.next != null && cur2.next.val <= cur1.val) {
                    cur2 = cur2.next;
                }
                ListNode cur2Next = cur2.next;
                cur2.next = cur1;
                cur2 = cur2Next;
            }
        }
        if (list1.val < list2.val) {
            return list1;
        } else {
            return list2;
        }
    }
}







