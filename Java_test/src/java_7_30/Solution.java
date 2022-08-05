package java_7_30;

import java.util.*;

// 剑指offer
class Solution {

    // 03 找到数组任意一个重复的数
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ret = 0;
        for (Integer x : nums) {
            if (!set.add((x))) {
                ret = x;
                break;
            }
        }
        return ret;
    }

    // 05 替换空格
    public String replaceSpace(String s) {
        int len = s.length();
        char[] ch = new char[len * 3];
        int k = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                ch[k++] = '%';
                ch[k++] = '2';
                ch[k++] = '0';
            } else {
                ch[k++] = c;
            }
        }
        return new String(ch, 0, k);
    }

    // 06 从尾到头打印链表
    // 方法一，逆序数组
    public int[] reversePrint1(ListNode head) {
        int[] array = new int[10000];
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            array[size++] = cur.val;
            cur = cur.next;
        }
        int[] array2 = new int[size];
        int k = 0;
        for (int i = size - 1; i >= 0; i--, k++) {
            array2[k] = array[i];
        }
        return array2;
    }

    // 方法二，栈
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    // newcoder BM1 反转链表
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }

    // leetcode 1441用栈操作构建数组
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new LinkedList<>();
        // 最大的数就是target数组最后一个数
        int len = target.length - 1;
        int k = 0; // target数组下标
        // 循环最多执行target数组中最大的数次，因为小于等于最大值的数都要Push一下
        // 如果数组的数和n相等时就Push后都++，不相同就不断PushPop到i重新和数组数
        //                                  字相等
        for (int i = 1; i <= target[len]; i++) {
            if (target[k] == i) {
                list.add("Push");
                k++;
            } else {
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }

    // leetcode 496 下一个更大元素
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] array = new int[len1];
        int size = 0;
        for (int i = 0; i < len1; i++) {
            int j = 0;// 用于查找对应的nums2的数组
            while (j < len2 && nums2[j] != nums1[i]) {
                j++;
            }
            int k = j + 1;
            while (k < len2 && nums2[k] < nums1[i]) {
                k++;
            }
            array[size++] = k < len2 ? nums2[k] : -1;
        }
        return array;
    }

    /*public int[] nextGreaterElement(int[] nums1, int[] nums2) {

    }*/
}




