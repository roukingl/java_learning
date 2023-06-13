package test_2022.java_11_18;

import java.util.*;

class Solution {



    // leetcode 48. 旋转图像
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < (len + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len -j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = tmp;
            }
        }
    }

    // leetcode 119. 杨辉三角 II
    public List<Integer> getRow(int rowIndex) {
        List<Integer> first = new ArrayList<>();
        first.add(1);
        List<Integer> prevCur = first;
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(prevCur.get(j) + prevCur.get(j - 1));
            }
            cur.add(1);
            prevCur = cur;
        }
        return prevCur;
    }

    // leetcode 119. 杨辉三角 II
    /* public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        list.add(first);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            List<Integer> prevCur = list.get(i - 1);
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(prevCur.get(j) + prevCur.get(j - 1));
            }
            cur.add(1);
            list.add(cur);
        }
        return list.get(rowIndex);
    }*/
}