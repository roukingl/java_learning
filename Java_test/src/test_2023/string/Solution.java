package test_2023.string;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // leetcode 125. 验证回文串
    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if ((tmp <= 'z' && tmp >= 'a') || (tmp <= 'Z' && tmp >= 'A') || (tmp <= '9' && tmp >= '0')) {
                sb.append(tmp);
            }
        }
        s = sb.toString().toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            char tmpI = s.charAt(i);
            char tmpJ = s.charAt(j);
            if (tmpI != tmpJ) {
                return false;
            }
        }
        return true;
    }

    // leetcode 392. 判断子序列
    public boolean isSubsequence(String s, String t) {
        int leftS = 0;
        int leftT = 0;
        while (leftS < s.length() && leftT < t.length()) {
            if (s.charAt(leftS) == t.charAt(leftT)) {
                leftS++;
                leftT++;
            } else {
                leftT++;
            }
        }
        return leftS == s.length();
    }

    // leetcode 167. 两数之和 II - 输入有序数组 map
//    public int[] twoSum(int[] numbers, int target) {
//        int[] result = new int[2];
//        int left = 0;
//        // 值，下标
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] <= Math.abs(target)) {
//                if (map.containsKey(numbers[i])) {
//                    result[1] = i + 1;
//                    result[0] = map.get(numbers[i]) + 1;
//                    break;
//                } else {
//                    map.put(target - numbers[i], i);
//                }
//            }
//        }
//        return result;
//    }

    // leetcode 167. 两数之和 II - 输入有序数组 二分查找
//    public int[] twoSum(int[] numbers, int target) {
//        for (int i = 0; i < numbers.length; i++) {
//            int left = i + 1;
//            int right = numbers.length - 1;
//            while (left <= right) {
//                int mid = left + (right - left) / 2;
//                if (numbers[mid] == target - numbers[i]) {
//                    return new int[] {i + 1, mid + 1};
//                } else if (numbers[mid] > target - numbers[i]) {
//                    right = mid - 1;
//                } else if (numbers[mid] < target - numbers[i]) {
//                    left = mid + 1;
//                }
//            }
//        }
//        return null;
//    }

    // leetcode 167. 两数之和 II - 输入有序数组 双指针
    // 左指针指着最左边，右指针指着最右边，当指针指向元素之和大于target时，就要减小，所以右指针左移以一位，小于target时，增大，左指针右移一位
    // 为什么不会错过解呢，因为有唯一解时，当右指针指向一个解，两个指针相加就必定小于target，因为左指针没到那么大的地步
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }
        return null;
    }


    // leetcode 11. 盛最多水的容器
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            int tmp = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, tmp);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}