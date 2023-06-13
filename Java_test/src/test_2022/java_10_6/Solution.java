package test_2022.java_10_6;

class Solution {

    // leetcode 53. 最大子数组和
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        return result;
    }
}