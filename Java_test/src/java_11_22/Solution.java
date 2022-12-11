package java_11_22;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString((productExceptSelf(nums))));
    }




    // leetcode 238. 除自身以外数组的乘积
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }
        return result;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        // left[i] 代表i下标左侧所有元素的积
        int[] left = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int[] right = new int[len];
        right[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static int[] productExceptSelf1(int[] nums) {
        int sum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (sum == 0) {
                break;
            }
            sum *= nums[i];
        }
        int[] result = new int[nums.length];
        result[0] = sum;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                int num = 1;
                for (int j = 0; j < nums.length; j++) {
                    if (!(j == i)) {
                        num *= nums[j];
                    }
                }
                result[i] = num;
            } else {
                result[i] = result[i - 1] * nums[i - 1] / nums[i];
            }
        }
        return result;
    }

    // leetcode 334. 递增的三元子序列
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            if (nums[i] > second) {
                return true;
            } else if (nums[i] > first) {
                second = nums[i];
            } else {
                first = nums[i];
            }
        }
        return false;
    }
}