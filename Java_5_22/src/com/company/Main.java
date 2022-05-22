package com.company;

import java.util.Scanner;
import java.math.*;

public class Main {

    //求出0～999之间的所有“水仙花数”并输出。
    // (“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本 身，
    // 如；153＝1＋5＋3?，则153是一个“水仙花数“。）

    public static int getBit(int n) {
        if(n > 9) {
            return 1 + getBit(n / 10);
        }
        return 1;
    }

    public static void main(String[] args) {

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
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineCount = scanner.nextInt();

        for (int i = 1; i <= lineCount; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d * %d = %d\t", i, j, i * j);
            }
            System.out.println();
        }

    }
    */

