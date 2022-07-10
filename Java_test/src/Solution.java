import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // ArrayList<ArrayList<Integer>> ret = generate(5);
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
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
