package test_2022.java_test;

import java.util.*;

public class Main14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int count = 0;
        Arrays.sort(array);
        HashSet<Integer> set = new HashSet<>();
        if (isXingYun(array, set)) {
            count++;
        }
        for (int i = n - 1; i >= 0; i++) {

            for (int j = i - 1; j >= 0; j++) {

            }
        }
    }

    // set里装的是要去除球的下标，判断剩下的球是否幸运
    private static boolean isXingYun(int[] array, HashSet<Integer> set) {
        int addSum = 0;
        int divSum = 0;
        int index = 0;
        if (!set.isEmpty()) {
            while (index < array.length && !set.contains(index)) {
                addSum += array[index];
                divSum *= array[index];
                index++;
            }
        } else {
            while (index < array.length) {
                addSum += array[index];
                divSum *= array[index];
                index++;
            }
        }
        return addSum > divSum;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nian = scanner.nextInt();
        int mouth = scanner.nextInt();
        int ri = scanner.nextInt();
        int[] mouths = {0, 31, (isRunNian(nian) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;
        for (int i = 1; i < mouth; i++) {
            sum += mouths[i];
        }
        System.out.println(sum + ri);
    }

    private static boolean isRunNian(int n) {
        return (n % 400 == 0 || (n % 4 == 0 && n % 100 != 0));
    }
}
