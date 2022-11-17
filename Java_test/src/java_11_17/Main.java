package java_11_17;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[][] ret = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(ret));
    }



    // leetcode 56.合并区间
    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i < intervals.length;) {
            int[] ret = {intervals[i - 1][0], intervals[i - 1][1]};
            while (intervals[i][0] < intervals[i - 1][1]) {
                ret[1] = intervals[i][1];
                i++;
            }
            list.add(ret);
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] ret = list.get(i);
            result[i][0] = ret[0];
            result[i][1] = ret[1];
        }
        return result;
    }

}
