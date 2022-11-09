package java_test;

import java.util.*;

public class Main21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        int[] index = fun(n, str);
        for (int i = index[0]; i <= index[1]; i++) {
            System.out.print(i + " ");
        }
        System.out.printf("\n %d", index[2]);
    }

    private static int[] fun(int n, String str) {
        // 一共三个数，第一个和第二个是该页上歌的序号，第三个数是当前悬停歌的序号
        int[] index = null;
        if (n <= 4) {
            index = new int[] {1, n, 1};
            for (char ch : str.toCharArray()) {
                fun1(n, ch, index);
            }
        } else {
            index = new int[] {1, 4, 1};
            for (char ch : str.toCharArray()) {
                fun1(n, ch, index);
            }
        }
        return index;
    }

    private static void fun1(int n, char ch, int[] index) {
        if (ch == 'U') {
            if (n <= 4) {
                if (index[2] == 1) {
                    index[2] = n;
                } else {
                    index[2]--;
                }
            } else {
                if (index[0] == 1 && index[2] == 1) {
                    index[0] = n - 3;
                    index[1] = n;
                    index[2] = n;
                } else if (index[0] == index[2]) {
                    index[0]--;
                    index[1]--;
                    index[2]--;
                } else {
                    index[2]--;
                }
            }
        } else {
            if (n <= 4) {
                if (index[2] == n) {
                    index[2] = 1;
                } else {
                    index[2]++;
                }
            } else {
                if (index[1] == n && index[2] == n) {
                    index[0] = 1;
                    index[1] = 4;
                    index[2] = 1;
                } else if (index[1] == index[2]) {
                    index[0]++;
                    index[1]++;
                    index[2]++;
                } else {
                    index[2]++;
                }
            }
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[2 * n];
            for (int j = 0; j < 2 * n; j++) {
                arr[j] = scanner.nextInt();
            }
            int[] tmp = fun(arr, n, k);
            for (int ret : tmp) {
                System.out.print(ret + " ");
            }
            System.out.println();
        }
    }

    private static int[] fun(int[] arr, int n, int k) {
        if (k == 0) {
            return arr;
        }
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (i < n) {
                arr1[index1++] = arr[i];
            } else {
                arr2[index2++] = arr[i];
            }
        }
        index1 = n - 1;
        index2 = n - 1;
        int end =  2 * n - 1;
        while (index2 >= 0) {
            arr[end] = arr2[index2--];
            end -= 2;
        }
        end = 2 * n - 2;
        while (index1 >= 0) {
            arr[end] = arr1[index1--];
            end -= 2;
        }
        return fun(arr, n, k - 1);
    }
}
