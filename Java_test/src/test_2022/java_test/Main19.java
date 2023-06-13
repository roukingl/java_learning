package test_2022.java_test;

import java.util.*;

public class Main19 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        if (s2.length() > s1.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        // s1字符串是更长的, s2字符串是更短的，以s2字符串来比较
        String maxString = null;
        int maxLength = 0;
        for (int i = 0; i < s2.length(); i++) {
            for (int j = i + 1; j < s2.length(); j++) {
                String str = s2.substring(i, j);
                int length = KMP(s1, str);
                if (length > maxLength) {
                    maxLength = length;
                    maxString = str;
                }
            }
        }
    }

    private static int KMP(String s1, String str) {
        return 0;
    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            // 空瓶数
            int n = scanner.nextInt();
            if (n == 0) {
                continue;
            }
            int sum = 0; // 一共喝的饮料数量
            int prevSum = 0; // 这一次喝的饮料数量
            while (n >= 3) {
                prevSum = n / 3;
                n = n % 3 + prevSum;
                sum += prevSum;
                prevSum = 0;
            }
            if (n == 2) {
                sum = sum + 1;
                n = 0;
            }
            System.out.println(sum);
        }
    }
}
