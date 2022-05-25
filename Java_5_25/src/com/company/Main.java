package com.company;

import java.util.Scanner;

public class Main {
    private static int fun(int n) {
        if(n > 1) {
            return n * fun ( n - 1);
        }
        return 1;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {

            System.out.println(fun(scanner.nextInt()));
        }
    }

/*public class Main {
    public static int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {

            System.out.println(sum(scanner.nextInt()));
        }
    }*/

/*public class Main {

    public static int fun(int n) {
        if(n > 10) {
            return n % 10 + fun(n / 10);
        }
        return n;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {

            System.out.println(fun(scanner.nextInt()));
        }
    }*/

/*    public static int fib(int n) {
        if(n <= 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextInt()) {

            System.out.println(fib(scanner.nextInt()));
        }
    }*/
}

/*public class Main {

    public static void dismantlingString(int newCount) {

        if(newCount > 10) {
            dismantlingString(newCount / 10);
        }
        System.out.print(newCount % 10 + " ");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextInt()) {
            int newCount = scanner.nextInt();

            dismantlingString(newCount);
        }
    }
}*/
/*

public class Main {

    public static int fib(int n) {
        int a = 1;
        int b = 1;
        int c = 0;
        if (n == 1 || n == 2) {
            return 1;
        } else {
            for (int i = 3; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextInt()) {
            System.out.println(fib(scanner.nextInt()));
        }
    }
}
*/

