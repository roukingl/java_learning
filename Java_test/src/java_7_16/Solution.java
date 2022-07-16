package java_7_16;
//
public class Solution {

    // newcoder 141判断是否为回文字符串
    public boolean judge (String str) {
        // write code here
        int len = str.length() - 1;
        for (int i = 0;i <= len;i++, len--) {
            if (str.charAt(i) == str.charAt(len)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    // newcoder 求平方根
    public int sqrt (int x) {
        // write code here
        if (x == 1 ) {
            return 1;
        }
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid ) {
                right = mid - 1;
            } else if (mid <= x/mid && (mid + 1) > x/(mid + 1)) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    // newcoder 截断句子
    public String truncateSentence(String s, int k) {
        int count = 0;
        int end = 0;
        int len = s.length();
        for (int i = 0;i <= len;i++) {
            if (i == len || s.charAt(i) == ' ') {
                count++;
                if (count == k) {
                    end = i;
                    break;
                }
            }
        }
        return s.substring(0, end);
    }

}

//    public String truncateSentence(String s, int k) {
//        String ret = null;
//        for (int i = 0;i < k;i++) {
//            ret = s.;
//        }
//        return ret;
//    }