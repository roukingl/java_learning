package test_2023.二分查找;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(takeAttendance(new int[]{0, 1, 2, 3, 5}));
    }
    public static int takeAttendance(int[] records) {
        int left = 0;
        int right = 0;
        int len = records.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (records[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 判断 left 是不是在数组末尾
        if (left == len - 1) {
            return records[len - 1] + 1;
        } else {
            return left;
        }
    }

    public static int takeAttendance1(int[] records) {
        int result = 0;
        int len = records.length;
        int max = records[len - 1];
        for (int record : records) {
            result ^= max--;
            result ^= record;
        }
        if (max == -1) {
            return records[len - 1] + 1;
        } else {
            return result;
        }

    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left != nums.length - 1) {
            return left;
        } else {
            return nums.length;
        }

    }

    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];
        Arrays.fill(result, -1);
        if (len == 0) {
            return new int[] {-1, -1};
        }
        int left = 0;
        int right = len - 1;
        // 求左端点
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 当左指针和右指针相遇判断
        if (nums[left] == target) {
            result[0] = left;
        } else {
            return new int[] {-1, -1};
        }

        left = 0;
        right = len - 1;
        // 求右端点
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            result[1] = left;
        }
        return result;
    }
}