package java_test;

import java.util.Scanner;

public class Main6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}

    /*public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char ch = str.charAt(0);
        boolean flg = false;
        int index = 0;
        if (ch == '-') {
            index++;
            flg = true;
        } else if (ch == '+') {
            index++;
        }

        int sum = 0;
        for (; index < str.length(); index++) {
            char number = str.charAt(index);
            if (number < '0' || number > '9') {
                return 0;
            }
            sum = sum * 10 + number - '0';
        }
        if (flg) {
            sum = -sum;
        }
        return sum;
    }*/
