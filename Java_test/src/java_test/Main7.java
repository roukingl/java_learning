package java_test;

import java.util.Scanner;
import java.util.*;

public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        System.out.println(h * (w / 2 + 1));
    }
}
class Solution {
    public int StrToInt(String str) {
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
    }
}