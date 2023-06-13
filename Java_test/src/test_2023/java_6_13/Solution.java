package test_2023.java_6_13;

class Solution {

    // leetcod 203. 移除链表元素
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode cur = head;
        ListNode prev = root;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                cur = cur.next;
                prev = prev.next;
            }
        }
        return root.next;
    }

    // leetcode 206.反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        prev.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // leetcode 207.合并两个有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        return head.next;
    }

    // leetcode 876. 链表的中间结点
    public ListNode middleNode(ListNode head) {
        // 快慢节点
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null) {
            quick = quick.next;
            if (quick == null) {
                break;
            }
            quick = quick.next;
            slow = slow.next;
        }
        return slow;
    }

    // leetcode 19. 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        ListNode tmp = head;
        ListNode tou = new ListNode(-1);
        ListNode prev = tou;
        prev.next = head;
        while (cur != null) {
            cur = cur.next;
            prev = tmp;
            tmp = tmp.next;
        }
        prev.next = tmp.next;
        return tou.next;
    }

    // leetcode 234. 回文链表 递归
    ListNode prevHead;
    public boolean digui(ListNode head) {
        if (head != null) {
            if (!digui(head.next)) {
                return false;
            }
            if (head.val != prevHead.val) {
                return false;
            }
            prevHead = prevHead.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        prevHead = head;
        return digui(head);
    }

    // leetcode 234. 回文链表 快慢指针中心反转
    // 找到中心节点，如果有两个就找到左边的那个，然后把后面的反转
    // 1 -> 2 -> 2 -> 1 变成 1-> 2  2 <- 1
    // 1 -> 0 -> 1 变成 1-> 0   1 ;
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 找到中间节点，偶数找中间两个节点左边的
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        // 反转后面的链表
        ListNode cur = slow.next;
        ListNode prev = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        while (prev != null) {
            if (prev.val != head.val) {
                return false;
            } else {
                prev = prev.next;
                head = head.next;
            }
        }
        return true;
    }
//    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//
//        // 找到中间节点，偶数找中间两个节点右边的
//        ListNode slow = head;
//        ListNode quick = head;
//        while (quick != null && quick.next != null) {
//            slow = slow.next;
//            quick = quick.next.next;
//        }
//        // 反转前面的链表 末尾节点条件是不等于slow
//        ListNode cur = head;
//        ListNode prev = null;
//        while (cur != slow && cur != null) {
//            ListNode curNext = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = curNext;
//        }
//        while (prev != null && slow != null) {
//            if (prev.val != slow.val) {
//                return false;
//            } else {
//                prev = prev.next;
//                slow = slow .next;
//            }
//        }
//        return true;
//    }
}