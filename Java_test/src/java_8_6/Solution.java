package java_8_6;

import java.util.HashSet;
import java.util.Set;

class Solution {

    // leetcode 2.两数相加
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode head = null;
        ListNode tail = null;
        int num = 0;
        while (head1 != null || head2 != null) {
            int n1 = 0;
            int n2 = 0;
            if (head1 != null) {
                n1 = head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                n2 = head2.val;
                head2 = head2.next;
            }
            int sum = n1 + n2 + num;
            if (head == null) {
                head = new ListNode(sum % 10);
                tail = head;
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            num = sum / 10;
        }
        if (num > 0) {
            tail.next = new ListNode(num);
        }
        return head;
    }

    // leetcode 3.无重复字符的最长子串
    public int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        int len = s.length();
        int[] arr = new int[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                count++;
            } else {
                arr[index] = count;
                index++;
                count = 0;
                set.clear();
            }
        }
        return max(arr);
    }

    private int max(int[] array) {
        int maxNum = array[0];
        for (int j : array) {
            if (j > maxNum) {
                maxNum = j;
            }
        }
        return maxNum;
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            int count = 0;
            Set<Character> set = new HashSet<>();
            for (int j = i; j < len; j++) {
                char ch = s.charAt(j);
                if (!set.contains(ch)) {
                    set.add(ch);
                    count++;
                } else {
                    break;
                }
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}










