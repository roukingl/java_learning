package test_2022.java_test;

import java.util.*;

public class Main27 {

    // newcoder HJ75 公共子串计算
    private static int getSubstringMaxLength(String min, String max) {
        char[] minCharArray = min.toCharArray();
        char[] maxCharArray = max.toCharArray();
        int maxLength = maxCharArray.length;
        int minLength = minCharArray.length;
        int maxlen = 0;
        int[][] dp = new int[minLength + 1][maxLength + 1];
        for (int i = 1; i <= minLength; i++) {
            for (int j = 1; j <= maxLength; j++) {
                if (maxCharArray[j - 1] == minCharArray[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (maxlen < dp[i][j]) {
                    maxlen = dp[i][j];
                }
            }
        }
        return maxlen;
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        if (a.length() > b.length()) {
            System.out.println(getSubstringMaxLength(b, a));
        } else {
            System.out.println(getSubstringMaxLength(a, b));
        }
    }

    // newcoder HJ65 查找两个字符串a,b中的最长公共子串
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        if (a.length() > b.length()){
            System.out.println(getCharString(a, b));
        } else {
            System.out.println(getCharString(b, a));
        }
    }

    public static String getCharString(String max, String min) {
        char[] maxCharArray = max.toCharArray();
        char[] minCharArray = min.toCharArray();
        int maxLen = maxCharArray.length;
        int minLen = minCharArray.length;
        int start = 0;
        int length = 0;
        int[][] dp = new int[minLen + 1][maxLen + 1];
        for (int i = 1; i <= minLen; i++) {
            for (int j = 1; j <= maxLen; j++) {
                if (maxCharArray[j - 1] == minCharArray[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (length < dp[i][j]) {
                    length = dp[i][j];
                    start = i - length;
                }
            }
        }
        return min.substring(start, start + length);
    }

//    public int Add(int num1,int num2) {
//        int ret = num1 ^ num2;
//        int a = num1 & (num2 << 1);
//        for (int i = 0; i < 32; i++) {
//            if (((1 << i) & a) == 1) {
//
//            }
//        }
//    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double a = fun(scanner.next());
            double b = fun(scanner.next());
            double c = fun(scanner.next());
            if (a + b > c && a + c > b && b + c > a) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static double fun(String str) {
        double ret = 0.0;
        for (char ch : str.toCharArray()) {
            ret = ret * 10 + ch - '0';
        }
        return ret;
    }
}
