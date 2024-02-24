package test_2023.模拟;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public static void main(String[] args) {
        int[] tmp = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(tmp);
        System.out.println(Arrays.toString(tmp));
    }
    public static void sortColors(int[] nums) {
        // 三指针
        int n = nums.length;
        int left = -1;
        int index = 0;
        int right = n;
        /*
         [0, left] 0
         [left + 1, index - 1] 1
         [index, right - 1] 待扫描的元素
         [right, n] 2
         */
        while (index < right) {
            if (nums[index] == 0) {
                swap(nums, ++left, index++);
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, --right, index);
            }
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character, Integer> defaultMap = new HashMap<>();
        defaultMap.put('c', 0);
        defaultMap.put('r', 1);
        defaultMap.put('o', 2);
        defaultMap.put('a', 3);
        defaultMap.put('k', 4);
        int[] map = new int[5];
        for (char tmp : croakOfFrogs.toCharArray()) {
            if (tmp == 'c') {
                // 当查找到c的时候，看有没有青蛙叫完，有就搬过来
                if (map[defaultMap.get('k')] != 0) {
                    map[defaultMap.get('k')]--;
                }
                map[defaultMap.get(tmp)] = 1;
            } else {
                // 查找前一个字符的是否有没有叫过，没有就返回-1
                if (map[defaultMap.get(tmp) - 1] == 0) {
                    return -1;
                } else {
                    map[defaultMap.get(tmp) - 1]--;
                    map[defaultMap.get(tmp)]++;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            if (map[i] != 0) {
                return -1;
            }
        }
        return map[4];
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return String.valueOf(1);
        }

        String preString = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int left = 0;
            int right = 0;
            while (right < preString.length()) {
                while (right < preString.length() && preString.charAt(left) == preString.charAt(right)) {
                    right++;
                }
                sb.append(right - left);
                sb.append(preString.charAt(left));
            }
            preString = sb.toString();
        }
        return preString;
    }

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