package java_8_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // nowcoder BM6 判断链表中是否有环
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    // nowcoder BM8 链表中倒数最后k个结点
    public ListNode FindKthToTail (ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (k != 0) {
            if (cur == null) {
                return null;
            }
            cur = cur.next;
            k--;
        }
        ListNode curHead = head;
        while (cur != null) {
            cur = cur.next;
            curHead = curHead.next;
        }
        return curHead;
    }

    // nowcoder BM10 两个链表的第一个公共结点
    public ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int len1 = getLinkedListSize(head1);
        int len2 = getLinkedListSize(head2);
        int len = Math.abs(len1 - len2);
        ListNode longList;
        ListNode shortList;
        if (len1 > len2) {
            longList = head1;
            shortList = head2;
        } else {
            longList = head2;
            shortList = head1;
        }
        while (len != 0) {
            len--;
            longList = longList.next;
        }
        while (longList != shortList) {
            longList = longList.next;
            shortList = shortList.next;
        }
        if (longList == null) {
            return null;
        }
        return longList;
    }

    private int getLinkedListSize(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    // leetcode 9. 回文数

    /**
     * 方法一,烂中烂, 大概就是通过两个数,每次除于它的次数,然后取模,比较,(这两个数和x的位数有关)
     * @param x 要求的数
     * @return .
     */
    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        int left = getNumber(x) - 1;
        int right = 0;

        while (right < left) {
            int leftN = left;
            int rightN = right;
            int numL = x;
            int numR = x;
            while (rightN != 0) {
                numR = numR / 10;
                rightN--;
            }
            while (leftN != 0) {
                numL = numL / 10;
                leftN--;
            }
            int retL = numL % 10;
            int retR = numR % 10;
            if (retL != retR) {
                break;
            }
            left--;
            right++;
        }
        if (right < left) {
            return false;
        } else {
            return true;
        }
    }

    private int getNumber(int x) {
        int count = 0;
        while (x != 0) {
            x /= 10;
            count++;
        }
        return count;
    }

    // 方法二 反转一半的数字
    public boolean isPalindrome(int x) {
        // 小于0的数,个位数为0的数都不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 反转
        int ret = 0;
        while (x > ret) {
            ret = ret * 10 + x % 10;
            x /= 10;
        }

        return x == ret || x == ret / 10;
    }

    // leetcode 13.罗马数字转整数
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int num = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char left = s.charAt(i);
            char right = s.charAt(i + 1);
            int values = map.get(left);
            if (values >= map.get(right)) {
                num += values;
            } else {
                num -= values;
            }
        }
        num += map.get(s.charAt(s.length() - 1));
        return num;
    }







}








