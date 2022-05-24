package com.company;

import java.util.Scanner;

public class Main {

    public Main() {
    }

    public static int factorial(int i) {

            int sum = 1;
            for (int j = 1; j <= i; j++) {
                sum *= j;
            }
            return sum;
        }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {

            int n = scanner.nextInt();

            System.out.println(n + "的阶乘为" + factorial(n));
        }
    }
}

/*public class Main {

    public static int max(int a, int b) {
        if(a < b) {
            return b;
        } else {
            return a;
        }
    }

    public static double max(double a, double b) {
        if(a < b) {
            return b;
        } else {
            return a;
        }
    }
    public static double max(int a, double b) {
        if(a < b) {
            return b;
        } else {
            return a;
        }
    }

    public static void main(String[] args) {

    System.out.println("最大值为: " + max(3, 1.2));

    }
}*/

/*public class Main {

    public static int sift(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7 , 1, 2, 3, 4, 6, 5};
        int ret = sift(arr);

        System.out.println("ret = " + ret);
    }
}*/

/*public class Main {
    public static int factorial(int i) {

        int sum = 1;
        for (int j = 1; j <= i; j++) {
            sum *= j;
        }
        return sum;
    }

    public static int factorialN(int n) {

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += factorial(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        // 求1！+2！+3！+4！+........+n!的和
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            int n = scanner.nextInt();

            int ret = factorialN(n);

            System.out.println("1——" + n + "的阶乘为 = " + ret);
        }
    }
}*/
