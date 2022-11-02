package java_11_2.other;


// leetcode 322.零钱兑换，不会
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


    // 记忆化搜索
    public static int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                dp[i][j] = -2;
            }
        }
        return process2(coins, 0, amount, dp);
    }

    private static int process2(int[] arr, int index, int amount, int[][] dp) {
        if (dp[index][amount] != -2) {
            return dp[index][amount];
        }
        if (index == arr.length) {
            dp[index][amount] = amount == 0 ? 0 : -1;
            return dp[index][amount];
        }
        int sum = -1;
        for (int zhang = 0; arr[index] * zhang <= amount; zhang++) {
            int next = process2(arr, index + 1, amount - zhang * arr[index], dp);
            if (next != -1) {
                sum = sum == -1 ? next + zhang : Math.min(sum, next + zhang);
            }
        }
        dp[index][amount] = sum;
        return sum;
    }

    // 动态规划
    public static int coinChange3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        // data base
        for (int i = 1; i < aim + 1; i++) {
            dp[N][i] = -1;
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 0; rest < aim + 1; rest++) {
                dp[i][rest] = -1;
                if (dp[i + 1][rest] != -1) {
                    dp[i][rest] = dp[i + 1][rest];
                }
                if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
                    if (dp[i][rest] == -1) {
                        // 下方的值无效，要抵消-1所以要额外加一
                        dp[i][rest] = dp[i][rest - arr[i]] + 1;
                    } else {
                        dp[i][rest] = Math.min(dp[i][rest], dp[i][rest - arr[i]] + 1);
                    }
                }
            }
        }
        return dp[0][aim];
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
            if (coinChange1(arr, aim) != coinChange2(arr, aim) || coinChange3(arr, aim) != coinChange2(arr, aim)) {
                System.out.println("ooops!");
                break;
            }
        }
    }
}