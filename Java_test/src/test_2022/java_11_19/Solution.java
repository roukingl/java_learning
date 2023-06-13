package test_2022.java_11_19;

class Solution {

    // leetcode 240. 搜索二维矩阵 II
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

//    public boolean searchMatrix(int[][] matrix, int target) {
//        for (int i = matrix.length - 1; i >= 0; i--) {
//            int index = 0;
//            while (index < matrix[0].length && matrix[i][index] < target) {
//                index++;
//            }
//            if (index < matrix[0].length && matrix[i][index] == target) {
//                return true;
//            }
//        }
//        return false;
//    }

    // leetcode 74. 搜索二维矩阵
    /*public boolean searchMatrix(int[][] matrix, int target) {
        int index = 0;
        while (index < matrix.length && matrix[index][matrix[0].length - 1] < target) {
            index++;
        }
        if (index == matrix.length) {
            return false;
        }
        for (int i = 0;i < matrix[index].length; i++) {
            if (matrix[index][i] == target) {
                return true;
            }
        }
        return false;
    }*/
    
}