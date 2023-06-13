package test_2022.java_8_8;

class Solution {

    // leetcode 7.整数反转
    public int reverse1(int x) {
        if (x < 10 && x >= 0) {
            return x;
        }
        int tmp = x;
        int result = 0;
        int count = getNumberBit(x);
        while (x != 0) {
            result = (int) (result + x % 10 * Math.pow(10, count - 1));
            count--;
            x /= 10;
        }
        return result < 2147483647 && result > -2147483648 ? result : 0;
    }

    private int getNumberBit(int x) {
        int count = 0;
        while (x != 0) {
            count++;
            x /= 10;
        }
        return count;
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }

    // leetcode 8.字符串转换整数
    public int myAtoi(String s) {
        int index = 0;
        int len = s.length();
        while (index < len && s.charAt(index) == ' ') {
            index++;
        }
        int start = index;
        int sign = 1;
        int result = 0;
        while (index < len) {
            char ch = s.charAt(index);
            if (index == start && ch == '-') {
                sign = -1;
            } else if (index == start && ch == '+') {
                sign = 1;
            } else if (Character.isDigit(ch)) {
                int num = ch - '0';
                if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num>Integer.MAX_VALUE % 10)){
                    return Integer.MAX_VALUE;
                }

                if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10)){
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + sign * num;
            } else {
                break;
            }
            index++;
        }
        return result;
    }
}