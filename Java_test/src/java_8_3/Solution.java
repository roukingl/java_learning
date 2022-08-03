package java_8_3;

class Solution {

    // leetcode 14.最长公共前缀
    // 方法一
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null) {
            return "";
        }
        String result = strs[0];
        for (int i = 0; i < strs.length - 1; i++) {
            String rightCh = strs[i + 1];
            result = getCommonString(result, rightCh);
            if (result.length() == 0) {
                break;
            }
        }
        return result;
    }

    private String getCommonString(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }


    // 方法二
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }
        // 先求出最短的字符串长度
        int len = strs[0].length();
        for (String x : strs) {
            int size = x.length();
            if (size < len) {
                len = size;
            }
        }

        int index = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return strs[0].substring(0, index);
                }
            }
            index++;
        }
        return strs[0].substring(0, len);
    }

    // leetcode 28. 实现strStr()
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        for (int i = 0; i < haystackLen - needleLen - 1; i++) {
            boolean flg = true;
            for (int j = 0; j < needleLen; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flg = false;
                    break;
                }
            }
            if (flg) {
                return i;
            }
        }
        return -1;
    }

    // leetcode 58.最后一个单词的长度
    public int lengthOfLastWord(String s) {
        int count = 0;
        int size = s.length();
        while (s.charAt(size - 1) == ' ') {
            s = s.substring(0, size - 1);
            size = s.length();
        }
        for (int i = s.length() - 1; i >= 0 && s.charAt(i) != ' '; i--) {
            count++;
        }
        return count;
    }

    // leetcode 66.加一
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean flg = true;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                flg = false;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (flg) {
            digits = new int[len + 1];
            digits[0] = 1;
        }
        return digits;
    }
}





