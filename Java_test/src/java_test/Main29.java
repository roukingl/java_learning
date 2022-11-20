package java_test;

import java.util.*;

public class Main29 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

    public static int getFirstUnFormedNum(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int j : arr) {
            min = Math.min(min, j);
            max += j;
        }
        return fun(arr, min, max, 0);
    }

    private static int fun(int[] arr, int min, int max, int index) {
        return 0;
    }


    public static int getFirstUnFormedNum1(int[] arr) {
        int min = arr[0];
        int max = 0;
        for (int j : arr) {
            if (min > j) {
                min = j;
            }
            max += j;
        }
        return fun1(arr, min, max);
    }

    private static int fun1(int[] arr, int min, int max){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            set.add(sum);
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                set.add(sum);
                sum -= arr[j];
            }
        }
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return max + 1;
    }
}
