package test_2022.java_8_7;

class Solution {

    // leetcode 125.验证回文字符串
    public boolean isPalindrome1(String s) {
        char[] ch = s.toLowerCase().toCharArray();
        int left = 0;
        int right = ch.length - 1;
        while (left < right) {
            while (left < right && (ch[left] < '0' || (ch[left] > '9' && ch[left] < 'a') || ch[left] > 'z')) {
                left++;
            }
            while (left < right && (ch[right] < '0' || (ch[right] > '9' && ch[right] < 'a') || ch[right] > 'z')) {
                right--;
            }
            if (ch[left] == ch[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    // leetcode 5.最长回文子串
    public String longestPalindrome2(String s) {
        int len = s.length();
        int maxStringLength = 0;
        int leftSub = 0;
        int rightSub = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int tmpStringLength = 0;
                if (isPalindrome(s, i, j)) {
                    tmpStringLength = j - i + 1;
                } else {
                    continue;
                }
                if (tmpStringLength > maxStringLength) {
                    maxStringLength = tmpStringLength;
                    leftSub = i;
                    rightSub = j;
                }
            }
        }
        return s.substring(leftSub, rightSub + 1);
    }

    private boolean isPalindrome(String s, int left, int right) {
        char[] ch = s.toCharArray();
        while (left < right) {
            if (ch[left] == ch[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    // leetcode 5.最长回文子串
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLength = 0;
        int point = 0;
        for (int i = 0; i < len; i++) {
            int length1 = judgeString(s, i, i);
            int length2 = judgeString(s, i, i + 1);
            int tmpLength = Math.max(length1, length2);
            if (tmpLength > maxLength) {
                maxLength = tmpLength;
                point = i;
            }
        }
        int length = maxLength / 2;
        return s.substring(maxLength % 2 == 1 ? point - length : point - length + 1, point + length + 1);
    }

    private int judgeString(String str, int left, int right) {
        int len = str.length();
        while (left >= 0 && right < len && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}