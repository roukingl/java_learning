package java_test;

import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringA = scanner.next();
        String stringB = scanner.next();
        int lenA = stringA.length();
        int count = 0;
        for (int i = 0; i <= lenA; i++) {
            String str = stringA.substring(0, i) + stringB + stringA.substring(i, lenA);
            if (isHuiweng(str)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isHuiweng(String str) {
        char[] ch = str.toCharArray();
        int begin = 0;
        int end = ch.length - 1;
        while (begin < end) {
            if (ch[begin] != ch[end]) {
                return false;
            } else {
                begin++;
                end--;
            }
        }
        return true;
    }
}

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        int[] dp = new int[length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = array[i];
            } else {
                dp[i] = dp[i - 1] + array[i];
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }*/
