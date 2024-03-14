package test_2024;

import java.util.Random;

public class Solution {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    private void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int key = nums[new Random().nextInt(r - l + 1) + l];
        int left = l - 1;
        int right = r + 1;
        for (int i = l; i < right;) {
            if (nums[i] < key) {
                swap(nums, ++left, i++);
            } else if (nums[i] == key) {
                i++;
            } else {
                swap(nums, --right, i);
            }
        }
        sort(nums, l, left);
        sort(nums, right, r);
    }
}
