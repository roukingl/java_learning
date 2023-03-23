package java_test;

import java.util.Scanner;

public class Main39 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] s1 = scanner.next().toCharArray();
            char[] s2 = scanner.next().toCharArray();
            System.out.println(get(s1, s2, 0, 0));
            System.out.println(get(s1, s2));
        }
    }

    // 递归
    private static int get(char[] s1, char[] s2, int i, int j) {
        if (i >= s1.length || j >= s2.length) {
            return 0;
        }
        if (s1[i] != s2[j]) {
            int len1 = get(s1, s2, i + 1, j);
            int len2 = get(s1, s2, i, j + 1);
            return Math.max(len1, len2);
        }
        return get(s1, s2, i + 1, j + 1) + 1;
    }

    // 动态规划
    private static int get(char[] s1, char[] s2) {
        int len1 = s1.length;
        int len2 = s2.length;
        int sub = 0;
        int[][] ch = new int[len1][len2];
        if (s1[len1 - 1] == s2[len2 - 1]) {
            ch[len1 - 1][len2 - 1] = 1;
            if (ch[len1 - 1][len2 - 1] > sub) {
                sub = ch[len1 - 1][len2 - 1];
            }
        } else {
            ch[len1 - 1][len2 - 1] = 0;
        }
        for (int i = len1 - 2; i >= 0; i--) {
            if (s1[i] == s2[len2 - 1]) {
                ch[i][len2 - 1] = 1;
                if (ch[len1 - 1][len2 - 1] > sub) {
                    sub = ch[len1 - 1][len2 - 1];
                }
            } else {
                ch[i][len2 - 1] = ch[i + 1][len2 - 1];
            }
        }
        for (int i = len2 - 2; i >= 0; i--) {
            if (s1[len1 - 1] == s2[i]) {
                ch[len1 - 1][i] = 1;
                if (ch[len1 - 1][len2 - 1] > sub) {
                    sub = ch[len1 - 1][len2 - 1];
                }
            } else {
                ch[len1 - 1][i] = ch[len1 - 1][i + 1];
            }
        }
        for (int i = 0; i < Math.min(len1 - 1, len2 - 1); i++) {
            for (int x = len1 - 2 - i; x >= 0; x--) {
                if (s1[x] == s2[len2 - 2 - i]) {
                    ch[x][len2 - 2 - i] = ch[x + 1][len2 - 1 - i] + 1;
                } else {
                    ch[x][len2 - 2 - i] = Math.max(ch[x][len2 - 1 - i], ch[x + 1][len2 - 2 - i]);
                }
                if (ch[x][len2 - 2 - i] > sub) {
                    sub = ch[x][len2 - 2 - i];
                }
            }
            for (int y = len2 - 3 - i; y >= 0; y--) {
                if (s1[len1 - 2 - i] == s2[y]) {
                    ch[len1 - 2 - i][y] = ch[len1 - 1 - i][y + 1] + 1;
                } else {
                    ch[len1 - 2 - i][y] = Math.max(ch[len1 - 2 - i][y + 1], ch[len1 - 1 - i][y]);
                }
                if (ch[len1 - 2 - i][y] > sub) {
                    sub = ch[len1 - 2 - i][y];
                }
            }
        }
        return sub;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] s1 = scanner.next().toCharArray();
            char[] s2 = scanner.next().toCharArray();
            int len1 = scanner.nextInt();
            int len2 = scanner.nextInt();
            int sub = 0;
            while (true) {
                sub++;
                s1[1] += 1;
                if (s1[1] > 'z') {
                    s1[1] = 'a';
                    s1[0] += 1;
                }
                if (s1[0] == s2[0] && s1[1] == s2[1]) {
                    break;
                }
            }
            System.out.println(sub);
        }
    }
}
