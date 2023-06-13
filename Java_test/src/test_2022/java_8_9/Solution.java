package test_2022.java_8_9;

class Solution {

    // leetcode 24.两两交换链表中的节点
    //迭代
    public ListNode swapPairs1(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode leftNode = cur.next;
            ListNode rightNode = cur.next.next;
            cur.next = rightNode;
            leftNode.next = rightNode.next;
            rightNode.next = leftNode;
            cur = leftNode;
        }
        return newHead.next;
    }

    //递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // leetcode 415.字符串相加
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;
        char[] ch = new char[Math.max(index1, index2) + 2];
        int i = 0;
        for (; index1 >= 0 || index2 >= 0; i++) {
            int n1 = 0;
            int n2  = 0;
            if (index1 >= 0) {
                n1 = num1.charAt(index1) - '0';
                index1--;
            }
            if (index2 >= 0) {
                n2 = num2.charAt(index2) - '0';
                index2--;
            }
            int result = n1 + n2 + carry;
            ch[i] = (char)(result % 10 + '0');
            carry = result / 10;
        }
        if (carry > 0) {
            ch[i] = (char)(carry + '0');
            i++;
        }
        i--;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0) {
            stringBuilder.append(ch[i]);
            i--;
        }
        return stringBuilder.toString();
    }

    // leetcode 43.字符串相乘
    public String multiply(String str1, String str2) {
        if (str1.equals("0") || str2.equals("0")) {
            return "0";
        }
        int len1 = str1.length();
        int len2 = str2.length();
        String ans = "0";
        for (int i = len2 - 1; i >= 0 ; i--) {
            StringBuilder s = new StringBuilder();
            int ele2 = str2.charAt(i) - '0';
            for (int j = len2 - 1 ; j > i ; j--) {
                s.append(0);
            }
            int result = 0;
            int carry = 0;
            for (int j = len1 - 1; j >= 0 ; j--) {
                int ele1 = str1.charAt(j) - '0';
                result = carry + ele1 * ele2 ;
                carry = result /10;
                s.append(result % 10);
            }
            if (carry > 0) {
                s.append(carry);
            }
            ans = addStrings(ans, s.reverse().toString());
        }
        return ans;
    }
}





