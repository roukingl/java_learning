package test_2022.java_11_4;

import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Random random = new Random();
        int ArrayBinaryLength = nums.length / 2;
        while (true) {
            int reposed = nums[random.nextInt(nums.length)];
            if (judge(nums, reposed) > ArrayBinaryLength) {
                return reposed;
            }
        }
    }

    private int judge(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
}