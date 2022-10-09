package java_10_8;

import java.util.*;

class Solution {

    // leetcode 350. 两个数组的交集 II
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        // K为值, V是个数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ret : nums1) {
            map.put(ret, map.getOrDefault(ret, 0) + 1);
        }
        int index = 0;
        int[] result = new int[nums1.length];
        for (int ret : nums2) {
            int count = map.getOrDefault(ret, 0);
            if (count > 0) {
                result[index++] = ret;
                count--;
                if (count > 0) {
                    map.put(ret, count);
                } else {
                    map.remove(ret);
                }
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }


    // leetcode 121. 买卖股票的最佳时机
    public int maxProfit(int[] prices) {

    }
}