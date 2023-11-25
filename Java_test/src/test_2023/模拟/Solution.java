package test_2023.模拟;

class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 求公差
        int tolerance = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        char[] charArrays = s.toCharArray();
        int len = charArrays.length;
        for (int i = 0; i < numRows; i++) {
            int index = i;
            if (i == 0) {
                // 第一行
                while (index < len) {
                    sb.append(charArrays[index]);
                    index += tolerance;
                }
            } else if (i == numRows - 1) {
                // 最后一行
                while (index < len) {
                    sb.append(charArrays[index]);
                    index += tolerance;
                }
            } else {
                // 中间行
                int index2 = tolerance - index;
                while (index < len && index2 < len) {
                    sb.append(charArrays[index]);
                    sb.append(charArrays[index2]);
                    index += tolerance;
                    index2 += tolerance;
                }
                if (index < len) {
                    sb.append(charArrays[index]);
                }
            }
        }
        return sb.toString();
    }
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = sb.length();
        for (int i = 0; i < len; i++) {
            char left = 0;
            char right = 0;
            if (i != 0) {
                left = sb.charAt(i - 1);   
            }
            if (i != len - 1) {
                right = sb.charAt(i + 1);
            }
            if (sb.charAt(i) == '?') {
                // 是问号
                String tmp = "a";
                char oldChar = 'a';
                char newChar = 'b';
                for (int j = 0; j < 3; j++) {
                    // 最多循环三次
                    if (tmp.charAt(0) != left && tmp.charAt(0) != right) {
                        // 和左右两边不相等才替代
                        sb.replace(i, i+1, tmp);
                        break;
                    }
                    tmp.replace(oldChar++, newChar++);
                }
            }
        }
        return sb.toString();
    }
}