package java_8_13;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // leetcode 12.整数转罗马数字
    public String intToRoman(int num) {
        int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] s = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            int value = nums[i];
            String ch = s[i];
            while (num >= value) {
                num -= value;
                stringBuilder.append(ch);
            }
            if (num == 0) {
                break;
            }
        }
        return stringBuilder.toString();
    }
}