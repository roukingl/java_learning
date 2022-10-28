package java_test;

import java.util.*;

public class Main18 {

    public static int findMinimum(int n, int[] left, int[] right) {
        int leftSum = 0;
        int rightSum = 0;
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] == 0 || right[i] == 0) {
                sum += left[i] + right[i];
            } else {
                leftSum += left[i];
                rightSum += right[i];
                if (leftMin > left[i]) {
                    leftMin = left[i];
                }
                if (rightMin > right[i]) {
                    rightMin = right[i];
                }
            }
        }
        return Math.min(leftSum - leftMin + 1, rightSum - rightMin + 1) + sum + 1;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{0, 7, 1, 6};
        int[] a2 = new int[]{1, 5, 0, 6};
        System.out.println(findMinimum(4, a1, a2));
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            long bigTuZi = 0;
            long tuzi_1 = 1;
            long tuzi_2 = 0;
            long tmp = 0; // 生的兔子数量
            for (int i = 2; i <= n; i++) {
                bigTuZi += tuzi_2;
                tmp = bigTuZi;
                tuzi_2 = tuzi_1;
                tuzi_1 = tmp;

            }
            System.out.println(bigTuZi + tuzi_1 + tuzi_2);
        }
    }
}
