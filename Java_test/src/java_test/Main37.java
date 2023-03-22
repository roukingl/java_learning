package java_test;

import java.util.Scanner;

public class Main37 {

    public static void main(String[] args) {
    }

    // 递归
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            char[][] cizhuan = new char[m][n];
            for (int i = 0; i < m; i++) {
                cizhuan[i] = scanner.next().toCharArray();
            }
            int x = 0;
            int y = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (cizhuan[i][j] == '@') {
                        x = j;
                        y = i;
                    }
                }
            }
            boolean[][] flg = new boolean[m][n];
            System.out.println(getBlackCizhuan(cizhuan, x, y, flg));
        }
    }

    private static int getBlackCizhuan(char[][] cizhuan, int x, int y, boolean[][] flg) {
        if (x < 0 || x >= cizhuan[0].length || y < 0 || y >= cizhuan.length) {
            return 0;
        }
        if (cizhuan[y][x] == '#') {
            return 0;
        }
        if (!flg[y][x]) {
            flg[y][x] = true;
            return getBlackCizhuan(cizhuan, x - 1, y, flg) + getBlackCizhuan(cizhuan, x, y - 1, flg) + getBlackCizhuan(cizhuan, x, y + 1, flg) + getBlackCizhuan(cizhuan, x + 1, y, flg) + 1;
        }
        return 0;
    }
}
