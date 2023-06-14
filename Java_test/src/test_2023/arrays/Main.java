package test_2023.arrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {1, 1, 1, 2, 2, 3};
//        int result = solution.removeDuplicates2(nums);
//        int[] n = new int[0];
//        System.out.println(result);
//        System.out.println(Arrays.toString(nums));
//        int[] strArray = {1, 2, 3};
//        List<Integer> list = Arrays.stream(strArray).boxed().collect(Collectors.toList());
//        System.out.println(list);
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
