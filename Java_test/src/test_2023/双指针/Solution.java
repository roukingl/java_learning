package test_2023.双指针;

import java.lang.reflect.Array;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] strArray = s.toCharArray();
        int left = 0;
        int right = 0;
        int result = 0;
        int[] hash = new int[128];
        while (right < strArray.length) {
            if (hash[strArray[right]] == 0) {
                // 当前字符在Set中没有重复的
                hash[strArray[right]] = 1;
                result = Math.max(result, right - left + 1);
                right++;
            } else {
                // Set中有重复的 left移动到当前重复字符的后面
                while (strArray[left] != strArray[right]) {
                    // 并从Set中删除移出滑动窗口
                    hash[strArray[left]] = 0;
                    left++;
                }
                hash[strArray[left]] = 0;
                left++;
            }
        }
        return result;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // a 不能超过最后三个数
        for (int a = 0; a < n - 3; a++) {
            if ((a > 0 && nums[a] == nums[a - 1])) {
                continue;
            }

            // b 不能超过最后两个数
            for (int b = a + 1; b < n - 2; b++) {
                int left = b + 1;
                int right = n - 1;
                if ((b > a + 1 && nums[b] == nums[b - 1]) || ((long) nums[n - 1] + nums[n - 2] + nums[b] + nums[a] < target) || ((long) nums[a] + nums[b] + nums[b + 1] + nums[b + 2] > target)) {
                    // 最大的两个和 a b 相加还小说明没有了
                    // 最小的两个 和 ab相加还打了说明跳过
                    continue;
                }
                while (left < right) {
                    long sum = (long)nums[left] + nums[right] + nums[a] + nums[b];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        // 添加
                        List<Integer> list = Arrays.asList(nums[a], nums[b], nums[left], nums[right]);
                        result.add(list);
                        // 添加一个后继续往后添加
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if ((i > 0 && nums[i] == nums[i - 1]) || (nums[i] > 0) || nums[len - 2] + nums[len - 1] < -nums[i]) {
                // i 下标的数和上一个相同，说明这个遍历的结果全是重复的，跳过循环
                continue;
            }
            // 定义双指针
            int left = i + 1;
            int right = len - 1;
            while (left < len - 1 && right > i && left < right) {
                if (nums[left] + nums[right] > -nums[i]) {
                    // 大了，right左移，减小和
                    right--;
                } else if (nums[left] + nums[right] < -nums[i]) {
                    // 小了，left 左移，增大和
                    left++;
                } else {
                    // 相等直接添加
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    // 将当前结果加入后，需要移动left和right
                    // 当left和right所指的数和上个数相同时继续移动
                    left++;
                    right--;
                    while (left < len - 1 && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right > i && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}