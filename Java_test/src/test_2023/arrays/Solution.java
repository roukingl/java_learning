package test_2023.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    // leetcode 88. 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0) {
            if (nums2[n - 1] >= nums1[m - 1]) {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            } else {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            }
        }
        while (n > 0) {
            nums1[n - 1] = nums2[n - 1];
            n--;
        }
    }

    // leetcode 27. 移除元素
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] == val) {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                len--;
            }
        }
        return len;
    }

    // 使用双指针，如果右指针不是val就把值赋值到left上，然后left++，right++，循环往复
    public int removeElement1(int[] nums, int val) {
        int len = nums.length;
        int left = 0;
        for (int right = 0; right < len; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    // 左右指针，一个从 0 开始， 一个从 nums。length开始，当left处等于val是，把right赋值到left，right--，然后循环还会再次检查一遍，直到不是val才left++
    public int removeElement2(int[] nums, int val) {
        int len = nums.length;
        int left = 0;
        for (int right = len - 1; right >= left; ) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    // leetcode 26. 删除有序数组中的重复项
    public int removeDuplicates1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        int left = 0;
        for (Integer tmp : nums) {
            if (set.add(tmp)) {
                result++;
                nums[left] = tmp;
                left++;
            }
        }
        return result;
    }

//    public int removeDuplicates2(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int left = 0;
//        int result = 0;
//        for (Integer tmp : nums) {
//            if (map.getOrDefault(tmp, 0) < 2) {
//                map.put(tmp, (map.getOrDefault(tmp, 0) + 1));
//                nums[left++] = tmp;
//                result++;
//            }
//        }
//        return left;
//    }

    public int removeDuplicates2(int[] nums) {
        // 双指针，有序数组
        if (nums == null || nums.length <= 2) {
            return nums.length;
        }
        // 有序数组，左右指针，当右指针的值与左指针-2的值相等时，说明有指针== 左指针-2  == 左指针 - 2，所以当相等时说明右指针的值不能保存下来，当相等时就保存在左指针的地方，左指针++， 不论相不相等有指针++
        int left = 2;
        int right = 2;
        while (right < nums.length) {
            if (nums[left - 2] != nums[right]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    // leetcode 169. 多数元素
    // 1. 哈希表，2. 排序  3. 众数
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer date = null;
        for (int tmp : nums) {
            if (count == 0) {
                date = tmp;
            }
            if (tmp == date) {
                count++;
            } else {
                count--;
            }
        }
        return date;
    }

    // leetcode 189. 轮转数组
    // 先反转所有数组，然后反转k - length - 1的 再反转0 - k - 1的
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    // leetcode 189. 轮转数组 失败
//    public void rotate1(int[] nums, int k) {
//        int len = nums.length;
//        fun(nums, len, k);
//    }
//
//    public void fun(int[] nums, int len, int k) {
//        List<Integer> a =  Arrays.stream(nums).boxed().collect(Collectors.toList());
//        LinkedList<Integer> list = new LinkedList(a);
//        for (int i = 0; i < k; i++) {
//            int tmp = list.remove(len - 1);
//            list.addFirst(tmp);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            nums[i] = list.get(i);
//        }
//    }

    // leetcode 买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            list.add(prices[i] - min);
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        Iterator<Integer> it = list.iterator();
        int max = it.next();
        while (it.hasNext()) {
            int tmp = it.next();
            if (tmp > max) {
                max = tmp;
            }
        }
        if (max < 0) {
            return 0;
        }
        return max;
    }
//    public int maxProfit(int[] prices) {
//        if (prices.length <= 1) {
//            return 0;
//        }
//        int max = 0;
//        int min = prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] - min > max) {
//                max = prices[i] - min;
//            }
//            if (prices[i] < min) {
//                min = prices[i];
//            }
//
//        }
//        return max;
//    }











}