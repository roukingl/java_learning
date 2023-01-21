package java_12_14;

import java.util.HashMap;
import java.util.Map;

class Solution {



    // leetcode 290. 单词规律
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if (str.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < str.length; i++) {
            char ch = pattern.charAt(i);
            if (map.put(ch, i) != map.put(str[i], i)) {
                return false;
            }
        }
        return true;
    }

    // leetcode 409. 最长回文串
    public int longestPalindrome(String s) {
        int[] arr = new int[127];
        for (char ret : s.toCharArray()) {
            arr[ret]++;
        }
        int length = 0;
        int flg = 0;
        for (int ret : arr) {
            if (ret % 2 == 0) {
                // 偶数, 直接把那个数加上就ok了
                length += ret;
            } else {
                // 奇数, 加上比奇数小最近的偶数,也就是减一
                length += (ret - 1);
                flg = 1;
            }
        }
        return length + flg;
    }



    // leetcode 560. 和为 K 的子数组
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int result = nums[i];
            if (result == k) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                
                result += nums[j];
                if (result == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int count = 0;
        for (int num : nums) {
            pre += num;
            map.put(pre, map.getOrDefault(pre, 0) + 1);
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
        }
        return count;
    }
}