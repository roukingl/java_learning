package test_2023.双指针;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

class Solution {

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        if (sLength < pLength) {
            return new ArrayList<>();
        }
        // 维护字符串 p 的map
        int[] defaultMap = new int[26];
        for (char tmp : p.toCharArray()) {
            defaultMap[tmp - 'a']++;
        }
        // 维护字符串 s 的map
        int[] map = new int[26];
        // 维护当前 map 中的有效字符数量
        int count = 0;
        int left = 0;
        int right = 0;
        char[] sCharArray = s.toCharArray();
        List<Integer> result = new ArrayList<>();

        while (right < sLength) {
            map[sCharArray[right] - 'a']++;
            if (map[sCharArray[right] - 'a'] <= defaultMap[sCharArray[right] - 'a']) {
                // 说明当前添加进map中的字符是有效字符
                count++;
            }
            if (right - left + 1 == pLength) {
                if (count == pLength) {
                    // 添加结果
                    result.add(left);
                }
                // 需要移动窗口,更新count
                map[sCharArray[left] - 'a']--;
                if(map[sCharArray[left] - 'a'] < defaultMap[sCharArray[left] - 'a']) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return result;
    }

    public static List<Integer> findAnagrams1(String s, String p) {
        int left = 0;
        int right = p.length() - 1;
        int n = s.length();
        Map<Character, Integer> defaultMap = getMap(p);
        List<Integer> result = new ArrayList<>();
        while (right < n) {
            Map<Character, Integer> tmpMap = getMap(s.substring(left, right + 1));
            if (compareMap(tmpMap, defaultMap)) {
                result.add(left);
            }
            left++;
            right++;
        }
        return result;
    }

    private static Map<Character, Integer> getMap(String s) {
        // 给一个字符串得到一个Map
        Map<Character, Integer> map = new HashMap<>();
        for (char tmp : s.toCharArray()) {
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        return map;
    }

    private static boolean compareMap(Map<Character, Integer> map, Map<Character, Integer> defaultMap) {
        for(Map.Entry<Character, Integer> entry : defaultMap.entrySet()) {
            char c = entry.getKey();
            int i = entry.getValue();
            if (map.getOrDefault(c, 0) != i) {
                return false;
            }
        }
        return true;
    }

    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = fruits.length;
        int result = 0;
        while (right < n) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

    public static int lengthOfLongestSubstring(String s) {
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