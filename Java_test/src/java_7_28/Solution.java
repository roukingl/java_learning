package java_7_28;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    // leetcode 217 存在重复的元素1
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer x : nums) {
            if (!set.contains(x)) {
                set.add(x);
            } else {
                return true;
            }
        }
        return false;
    }

    // leetcode 219 存在重复的元素2
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int ret = nums[i];
            if (map.containsKey(ret) && i - (int)map.get(ret) <= k) {
                return true;
            }
            map.put(ret, i);
        }
        return false;
    }
}