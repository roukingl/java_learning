package java_test;

import java.util.*;

public class Main22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int ret = 0;
            for (int i = 0; i < n; i++) {
                ret = scanner.nextInt();
                if (a > ret) {
                    a += ret;
                } else {
                    a += fun(ret, a);
                }
            }
            System.out.println(a);
        }
    }

    // a大，b小
    private static int fun(int a, int b) {
        int max = 1;
        for (int i = 2; i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                if (i > max) {
                    max = i;
                }
            }
        }
        return max;
    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int[] count = new int[1000];
            for (char ch : s.toCharArray()) {
                count[ch]++;

            }
            for (char ch : s.toCharArray()) {
                if (count[ch] == 1) {
                    System.out.println(ch);
                    return;
                }
            }
            System.out.println(-1);
        }
    }
}
