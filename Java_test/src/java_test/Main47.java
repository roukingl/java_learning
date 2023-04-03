package java_test;

import java.util.Scanner;

public class Main47 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();
            int d = scanner.nextInt();
            System.out.println(getMax(arr, k, d, 0, -1));
        }
    }

    // index 是当前的下标 preIndex 是上一个乘进去的数， 用来比较
    private static int getMax(int[] arr, int k, int d, int index, int preIndex) {
        if (index >= arr.length) {
            return 1;
        }
        if (k <= 0) {
            return 1;
        }
        if (Math.abs((arr[index] - arr[preIndex])) <= d) {

        } else {

        }
        return 0;
    }
}
