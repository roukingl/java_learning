package test_2023.others;

import java.util.HashSet;
import java.util.Set;

class Solution {

    // leetcode 209. 长度最小的子数组
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0; 
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(right - left + 1, minLength);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }

    // leetcode 3. 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (right < len) {
            char tmp = s.charAt(right);
            if (set.add(tmp)) {
                right++;
                maxLength = Math.max(right - left + 1, maxLength);
            } else {
                while (set.contains(tmp)) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return maxLength;
    }


}