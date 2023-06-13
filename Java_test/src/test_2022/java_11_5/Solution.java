package test_2022.java_11_5;

import java.util.*;

class Solution {

    // leetcode 75. 颜色分类
    public void sortColors2(int[] nums) {
        // [0 - p0) 全0
        // [p0 - i) 全1
        // (p2 - len - 1] 全2
        int p0 = 0;
        int p2 = nums.length - 1;
        int i = 0;
        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                // nums[i] == 2
                swap(nums, p2, i);
                p2--;
            }
        }
    }

    // leetcode 75. 颜色分类
    public void sortColors1(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, p0, i);
                if (p0 < p1) {
                    swap(nums, p1, i);
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                swap(nums, p1, i);
                p1++;
            }

        }
    }

    // leetcode 75. 颜色分类
    public void sortColors(int[] nums) {
        int head = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, head);
                head++;
            }
        }
        for (int i = head; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, head);
                head++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    // newcoder HJ53 杨辉三角的变形
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = 2 * n - 1;
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = 0;
                }
            }
            a[0][0] = 1;
            for (int i = 1; i < n; i++) {
                a[i][0] = a[i][2 * i] = 1;
                for (int j = 1; j < 2 * i; j++) {
                    if (j == 1) {
                        a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
                    } else {
                        a[i][j] = a[i - 1][j] + a[i - 1][j - 1] + a[i - 1][j - 2];
                    }
                }
            }
            int k = 0;
            for (; k < m; k++) {
                if (a[n - 1][k] % 2 == 0) {
                    System.out.println(k + 1);
                    break;
                }
            }
            if (k == m) {
                System.out.println(-1);
            }
        }
    }

    // leetcode 15. 三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            function(nums, i, result);
        }
        return result;
    }

    private void function(int[] nums, int index, List<List<Integer>> result) {
        int target = -nums[index];
        int right = nums.length - 1;
        for (int left = index + 1; left < nums.length; left++) {
            if (left > index + 1 && nums[left] == nums[left - 1]) {
                continue;
            }
            while (left < right && nums[left] + nums[right] > target) {
                right--;
            }
            if (left == right) {
                break;
            }
            if (nums[left] + nums[right] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                list.add(nums[index]);
                result.add(list);
            }
        }
    }
}