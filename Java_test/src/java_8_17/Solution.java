package java_8_17;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int ret = nums2[i];
            while (!stack.empty() && ret > stack.peek()) {
                stack.pop();
            }
            map.put(ret, stack.empty() ? -1 : stack.peek());
            stack.push(ret);
        }



        int[] rus = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            rus[i] = map.get(nums1[i]);
        }
        
        return rus;
    }
}