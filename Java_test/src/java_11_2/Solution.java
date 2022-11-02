package java_11_2;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public static int coinChange1(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        return process1(coins, 0, amount);
    }

    // 暴力递归
    // index -数组下标
    // amount - 所期望的金额，当amount == 0 时返回硬币数量
    private static int process1(int[] arr, int index, int amount) {
        if (index == arr.length) {
            return amount == 0 ? 0 : -1; 
        }
        int sum = -1;
        for (int zhang = 0; arr[index] * zhang <= amount; zhang++) {
            int next = process1(arr, index + 1, amount - zhang * arr[index]);
            // 找到解决办法，看和现有的硬币数比较那个小，如果当前没有硬币数直接赋值，无须比较
            if (next != -1) {
                sum = (sum == -1 ? next + zhang : Math.min(next + zhang, sum));
            }
        }
        return sum;
    }

    public static int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp[len][i] = -1;
        }
        return process2(coins, 0, amount, dp);
    }

    private static int process2(int[] arr, int index, int amount, int[][] dp) {
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int sum = -1;
        for (int zhang = 0; arr[index] * zhang <= amount; zhang++) {
            int next = process2(arr, index + 1, amount - zhang * arr[index], dp);
            dp[index + 1][amount - zhang * arr[index]] = (sum == -1 ? next + zhang : Math.min(next + zhang, sum));
            if (next != -1) {
                sum = dp[index + 1][amount - zhang * arr[index]];
            }
        }
        return sum;
    }


    public static int[] generateRandomArray(int len, int max) {
        int[] arr = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int len = 10;
        int max = 10;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(len, max);
            int aim = (int) (Math.random() * 3 * max) + max;
            if (coinChange1(arr, aim) != coinChange2(arr, aim)) {
                System.out.println("ooops!");
                break;
            }
        }
    }
}