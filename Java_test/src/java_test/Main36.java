package java_test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main36 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[26];
            int max = 0;
            char ch = 0;
            for (int i = 0; i < 2 * n; i++) {
                String id = scanner.next();
                if (i % 2 == 0) {
                    ch = id.charAt(0);
                    arr[ch - 'A']++;
                    max = getMax(arr);
                } else {
                    if (id.equals("connect")) {
                        arr[ch - 'A']--;
                    } else {

                    }
                }
            }
            System.out.println(max);
        }
    }

    public static int getMax(int[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            n += arr[i];
        }
        return n;
    }
}
