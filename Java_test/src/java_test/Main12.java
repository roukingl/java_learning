package java_test;

import java.util.Scanner;

public class Main12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int mid = number / 2;
        int begin = mid;
        int end = mid;
        while (begin > 1 && end < number) {
            boolean isBegin = isSuShu(begin);
            boolean isEnd = isSuShu(end);
            if (isBegin && isEnd) {
                if (begin + end == number) {
                    System.out.println(Math.min(begin, end));
                    System.out.println(Math.max(begin, end));
                    break;
                } else if (begin + end < number) {
                    end++;
                } else {
                    begin--;
                }
            } else if (isBegin == true && isEnd == false) {
                end++;
            } else if (isBegin == false && isEnd == true) {
                begin--;
            } else {
                begin--;
                end++;
            }
        }
    }

    private static boolean isSuShu(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int binInsert(int n, int m, int j, int i) {
        return n | (m << j);
    }
}
