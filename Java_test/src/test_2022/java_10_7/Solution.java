package test_2022.java_10_7;

import java.util.HashMap;

class Solution {

    // leetcode 1.两数之和
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0;i < nums.length;i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    // leetcode 88. 合并两个有序数组
    public void merge(int[] nums1, int length1, int[] nums2, int length2) {
        int index1 = length1 - 1;
        int index2 = length2 - 1;
        int index3 = length1 + length2 - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[index3--] = nums1[index1--];
            } else {
                nums1[index3--] = nums2[index2--];
            }
        }
        while (index2 >= 0) {
            nums1[index3--] = nums2[index2--];
        }
    }
}