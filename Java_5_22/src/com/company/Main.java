package com.company;

import java.util.Scanner;
import java.math.*;

public class Main {

    public static void main(String[] args) {
        int nineCount = 0;

        for (int i = 1; i <= 100; i++) {
            if(i / 10 == 9) {
                nineCount++;
            }
            if(i % 10 == 9) {
                nineCount++;
            }
        }

        System.out.println("nineCount = " + nineCount);
    }
}

/*    *//**
     * 该方法用来判断一个数是否为素数
     *
     * @param number 改int类型数字
     * @return 是素数返回该数字，不是素数返回0
     *//*
    public static int judgePrimeNumber(int number) {

        if(number == 2) {
            return 0;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return 0;
            }
        }

        return number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if(judgePrimeNumber(number) != 0) {
                System.out.println("该数字是素数");
            } else {
                System.out.println("该数字不是素数");
            }
        }
    }
}*/
/*    public static void main(String[] args) {

        for (int i = 1; i <= 100 ; i += 2) {
            if(judgePrimeNumber(i) != 0) {
                System.out.println("素数有" + i);
            }
        }
    }
}*/

 /*   *//**
     * 这个方法用来判断某一年是不是闰年
     * @param year 年份
     * @return 是闰年返回年份，不是闰年返回0
     *//*

    public static int JudgeLeapYear(int year) {
        if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            return year;
        }
        return 0;
    }

    public static void main4(String[] args) {

        for (int i = 1000; i <= 2000 ; i++) {
            if(JudgeLeapYear(i) != 0) {
                System.out.println("闰年是：" + i);
            }
        }

    }


    *//**
     * 这个函数用来求两个int类型参数的最大公约数
     * @param numberA 第一个int类型参数
     * @param numberB 第二个int类型参数
     * @return 返回最大的公约数
     *//*

    public static int JudgeCommonDivisor(int numberA, int numberB) {
        int retCount = Math.max(numberA, numberB);

        for (int i = retCount; i > 1; i--) {
            if((numberA % i == 0) && (numberB % i == 0)) {
                return i;
            } else {
                continue;
            }
        }
        return 0;
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextInt()) {
            int numberA = scanner.nextInt();
            int numberB = scanner.nextInt();

            int ret = JudgeCommonDivisor(numberA, numberB);
            if(ret == 0) {
                System.out.println("这两个数最大公约数为1");
            } else {
                System.out.println("这两个数最大公约数为" + ret);
            }
        }

    }


    //求出0～999之间的所有“水仙花数”并输出。
    // (“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本 身，
    // 如；153＝1＋5＋3?，则153是一个“水仙花数“。）

    public static int getBit(int n) {
        if(n > 9) {
            return 1 + getBit(n / 10);
        }
        return 1;
    }

    public static void main2(String[] args) {

        Scanner scanner = new Scanner(System.in);


        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int bitQuantity = getBit(n);
            int ret = n;
            int sum = 0;

            for (int i = 0; i < bitQuantity; i++) {
                sum += Math.pow((double)(ret % 10), (double)3);
                ret /= 10;
            }

            if(sum == n) {
                System.out.println("该数字是水仙花数");
            } else {
                System.out.println("该数字不是水仙花数");
            }
        }

    }


    public static void main1(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String password = "aisofdj";
        int forCount = 3;

        for (int i = 0; i < forCount; i++) {

            String inPassword = scanner.nextLine();
            if(password.equals(inPassword)) {
                System.out.println("登录成功");
                break;
            } else {
                System.out.println("密码错误");
            }
        }

    }
}
    //编写代码模拟三次密码输入的场景。 最多能输入三次密码，
    // 密码正确，提示“登录成功”,密码错误， 可以重新输 入，最多输入三次。
    // 三次均错，则提示退出程序
    *//*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineCount = scanner.nextInt();

        for (int i = 1; i <= lineCount; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d * %d = %d\t", i, j, i * j);
            }
            System.out.println();
        }

    }
    *//*
*/
