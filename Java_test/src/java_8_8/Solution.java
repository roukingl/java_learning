package java_8_8;

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
}