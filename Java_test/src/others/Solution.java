package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        // ArrayList<ArrayList<Integer>> ret = generate(5);
        //int[] nums = {3, 2, 2, 3};
        //System.out.println(removeElement(nums, 3));
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }



    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int right = m + n - 1;
            int left1 = m - 1;
            int left2 = n - 1;

            while(left1 >= 0 || left2 >= 0) {
                if (left1 == -1) {
                    nums1[right] = nums2[left2];
                    left2--;
                } else if(left2 == -1) {
                    nums1[right] = nums1[left1];
                    left1--;
                } else if (nums1[left1] > nums2[left2]) {
                    nums1[right] = nums1[left1];
                    left1--;
                } else {
                    nums1[right] = nums2[left2];
                    left2--;
                }
                right--;
            }
    }



    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = m;
        for (int i = 0;i < m + n;i++) {
            if (nums1[i] > nums2[left]) {
                nums1[right] = nums1[i];
                nums1[i] = nums2[left];
                right++;
                left++;
            }
            if (nums1[i] <= nums2[left] && nums1[i] == 0) {
                nums1[i] = nums2[left];
                left++;
            }
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int j = 0;
        int leftM = 0;
        int leftN = 0;
        while (leftM < m && leftN < n) {
            if (nums1[leftM] < nums2[leftN]) {
                arr[j] = nums1[leftM];
                leftM++;
            } else {
                arr[j] = nums2[leftN];
                leftN++;
            }
            j++;
        }
        if (leftM == m) {
            for (int i = leftN;i < n;i++) {
                arr[m + i] = nums2[i];
            }
        }
        if (leftN == n) {
            for (int i = leftM;i < m;i++) {
                arr[n + i] = nums1[i];
            }
        }
        //for (int i = 0;i < m + n;i++) {
        //}
    }

    public int removeDuplicates(int[] nums) {
        int left = 1;
        int ret = nums[0];
        int right = 0;
        while(right < nums.length) {
            if(nums[right] != ret) {
                nums[left] = nums[right];
                ret = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    public static int removeElement1(int[] nums, int val) {
        int left = 0;
        for (int right = 0;right < nums.length;right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }

        }
        return left;
    }

    public static int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if(nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    // 杨辉三角
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> row = new ArrayList<>();

        // 第一行
        List<Integer> list = new ArrayList<>();
        list.add(1);
        row.add(list);

        for (int i = 1; i < numRows; i++) {
            // 第i行
            List<Integer> col = new ArrayList<>();

            List<Integer> prevList = new ArrayList<>();
            col.add(1);
            // 前一行
            prevList = row.get(i - 1);
            for (int j = 1; j < i; j++) {
                col.add(prevList.get(j - 1) + prevList.get(j));
            }
            col.add(1);
            row.add(col);
        }
        return row;
    }
}
