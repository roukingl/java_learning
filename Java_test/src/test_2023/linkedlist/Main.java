package test_2023.linkedlist;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        ListNode tmp = solution.reverseList(head);
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode tmp = solution.addTwoNumbers(l1, l2);
        System.out.println(tmp.toString());
    }
}
