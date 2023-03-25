package java_test;

import java.util.Scanner;
import java.util.Stack;

public class Main41 {

    public static void main(String[] args) {
        System.out.println(0 / 3);
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            char[] ch = new char[n];
            for (int i = 0; i < n; i++) {
                ch[i] = scanner.next().toCharArray()[0];
            }
            Stack<Character> stack = new Stack<>();
            for (char c : ch) {
                if (c != '+' && c != '-' && c != '*' && c != '/') {
                    stack.push(c);
                } else {
                    int a = stack.pop() - '0';
                    int b = stack.pop() - '0';
                    stack.push(jisuan(a, b, c));
                }
            }
            System.out.println(stack.pop());
        }
    }

    private static char jisuan(int a, int b, char c) {
        if (c == '+') {
            return (char)(a + b + '0');
        } else if (c == '-') {
            return (char)(a - b + '0');
        } else if (c == '*') {
            return (char)(a * b + '0');
        } else if (c == '/') {
            return (char)(a / b + '0');
        } else {
            return 0;
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[][] ch = new char[20][20];
            for (int i = 0; i < 20; i++) {
                ch[i] = scanner.next().toCharArray();
            }
            boolean flg = false;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    if (ch[i][j] != '.') {
                        if (j > 3 && ch[i][j] == ch[i][j - 1] && ch[i][j - 1] == ch[i][j - 2] && ch[i][j - 2] == ch[i][j - 3] && ch[i][j - 3] == ch[i][j - 4]) {
                            System.out.println("Yes");
                            flg = true;
                            break;
                        }
                        if (j < 16 && ch[i][j] == ch[i][j + 1] && ch[i][j + 1] == ch[i][j + 2] && ch[i][j + 2] == ch[i][j + 3] && ch[i][j + 3] == ch[i][j + 4]) {
                            System.out.println("Yes");
                            flg = true;
                            break;
                        }
                        if (i < 16 && ch[i][j] == ch[i + 1][j] && ch[i + 1][j] == ch[i + 2][j] && ch[i + 2][j] == ch[i + 3][j] && ch[i + 3][j] == ch[i + 4][j]) {
                            System.out.println("Yes");
                            flg = true;
                            break;
                        }
                        if (i > 3 && ch[i][j] == ch[i - 1][j] && ch[i - 1][j] == ch[i - 2][j] && ch[i - 2][j] == ch[i - 3][j] && ch[i - 3][j] == ch[i - 4][j]) {
                            System.out.println("Yes");
                            flg = true;
                            break;
                        }
                        if (i > 3 && j > 3 && ch[i][j] == ch[i - 1][j - 1] && ch[i - 1][j - 1] == ch[i - 2][j - 2] && ch[i - 2][j - 2] == ch[i - 3][j - 3] && ch[i - 3][j - 3] == ch[i - 4][j - 4]) {
                            System.out.println("Yes");
                            flg = true;
                            break;
                        }
                        if (i < 16 && j < 16 && ch[i][j] == ch[i + 1][j + 1] && ch[i + 1][j + 1] == ch[i + 2][j + 2] && ch[i + 2][j + 2] == ch[i + 3][j + 3] && ch[i + 3][j + 3] == ch[i + 4][j + 4]) {
                            System.out.println("Yes");
                            flg = true;
                            break;
                        }
                        if (i < 16 && j > 3 && ch[i][j] == ch[i + 1][j - 1] && ch[i + 1][j - 1] == ch[i + 2][j - 2] && ch[i + 2][j - 2] == ch[i + 3][j - 3] && ch[i + 3][j - 3] == ch[i + 4][j - 4]) {
                            System.out.println("Yes");
                            flg = true;
                            break;
                        }
                        if (i > 3 && j < 16 && ch[i][j] == ch[i - 1][j + 1] && ch[i - 1][j + 1] == ch[i - 2][j + 2] && ch[i - 2][j + 2] == ch[i - 3][j + 3] && ch[i - 3][j + 3] == ch[i - 4][j + 4]) {
                            System.out.println("Yes");
                            flg = true;
                            break;
                        }
                    }
                }
                if (flg) {
                    break;
                }
            }
            if (!flg) {
                System.out.println("No");
            }
        }
    }
}
