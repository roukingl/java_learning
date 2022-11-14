package java_test;

import java.util.*;

public class Main25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String n = scanner.next();
            long sum = 0;
            StringBuilder stringBuilder = new StringBuilder(n);

            for (char ch : stringBuilder.reverse().toString().toCharArray()) {
                sum += ch - '0';
            }
            while (sum >= 10) {
                long x = sum;
                sum = 0;
                while (x != 0) {
                    sum += x % 10;
                    x /= 10;
                }
            }
            System.out.println(sum);
        }
    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
    }
}
