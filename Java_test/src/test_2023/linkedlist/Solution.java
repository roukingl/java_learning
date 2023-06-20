package test_2023.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    // leetcod 160. 相交链表 AB链表不断首尾，最多循环A + B 次就可以得出
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode pA = headA;
//        ListNode pB = headB;
//        while (pA != pB) {
//            if (pA == null) {
//                pA = headB;
//            } else {
//                pA = pA.next;
//            }
//            if (pB == null) {
//                pB = headA;
//            } else {
//                pB = pB.next;
//            }
//        }
//        return pA;
//    }

    // 通过计算长度求差值来截断较长链表同步循环找到相交点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while (tmpA != null) {
            tmpA = tmpA.next;
            lengthA++;
        }
        while(tmpB != null) {
            tmpB = tmpB.next;
            lengthB++;
        }
        int length = 0;
        if (lengthA > lengthB) {
            length = lengthA - lengthB;
            for (int i = 0; i < length && headA != null; i++) {
                headA = headA.next;
            }
        } else {
            length = lengthB - lengthA;
            for (int i = 0; i < length && headB != null; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            } else {
                return headA;
            }
        }
        return null;
    }

    // leetcod 141. 环形链表
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 快慢指针
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (quick == slow ) {
                return true;
            }
        }
        return false;
    }

    // leetcode 2. 两数相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int top = 0;
        ListNode prev = null;
        while (cur1 != null && cur2 != null) {
            cur1.val = (cur1.val + cur2.val + top);
            top = cur1.val / 10;
            cur1.val = cur1.val % 10;
            if (cur1.next == null) {
                prev = cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if (cur1 == null && cur2 != null) {
            // 本体链表为空就链接另一个链表计算
            prev.next = cur2;
            while (cur2 != null) {
                cur2.val = (cur2.val + top);
                top = cur2.val / 10;
                cur2.val = cur2.val % 10;
                if (cur2.next == null) {
                    prev = cur2;
                }
                cur2 = cur2.next;
            }
        } else if (cur1 != null) {
            // 相加链表为空就照常加上top
            while (cur1 != null) {
                cur1.val = (cur1.val + top);
                top = cur1.val / 10;
                cur1.val = cur1.val % 10;
                if (cur1.next == null) {
                    prev = cur1;
                }
                cur1 = cur1.next;
            }
        }
        if (top != 0) {
            prev.next = new ListNode(top);
        }
        return l1;
    }


    // leetcode 138. 复制带随机指针的链表 TODO 还有递归没写
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

//    public Node copyRandomList(Node head) {
//        Node cur = head;
//        Map<Integer, Integer> map = new HashMap<>();
//        List<Integer> list = new ArrayList<>();
//        while (cur != null) {
//            list.add(cur.val);
//            map.put(cur.val, cur.random.val);
//            cur = cur.next;
//        }
//        Node start = new Node(0);
//        Node node = start;
//        Map<Integer, Node> mapNode = new HashMap<>();
//        for (Integer tmp : list) {
//            node.next = new Node(tmp);
//            node = node.next;
//            mapNode.put(tmp, node);
//        }
//        node = start.next;
//        while (node != null) {
//            node.random = mapNode.get(map.get(node.val));
//            node = node.next;
//        }
//        return start.next;
//    }
}