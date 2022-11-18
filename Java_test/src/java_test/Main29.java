package java_test;

import java.util.*;

public class Main29 {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        System.out.println(getFirstUnFormedNum(arr));

    }



    public static int getFirstUnFormedNum(int[] arr) {
        int min = arr[0];
        int max = 0;
        for (int j : arr) {
            if (min > j) {
                min = j;
            }
            max += j;
        }
        return fun(arr, min, max);
    }

    private static int fun(int[] arr, int min, int max){
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
