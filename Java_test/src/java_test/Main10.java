package java_test;

import java.util.Scanner;

public class Main10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String password = scanner.next();
            int fengshu = 0;
            int mathCount = 0;
            int LowerCharCount = 0;
            int UpperCharCount = 0;
            int fuhaoCount = 0;
            int len = password.length();
            for (int i = 0; i < len; i++) {
                char ch = password.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    mathCount++;
                } else if (ch >= 'a' && ch <='z') {
                    LowerCharCount++;
                } else if (ch >= 'A' && ch <= 'Z') {
                    UpperCharCount++;
                } else {
                    fuhaoCount++;
                }
            }

            if (mathCount > 1) {
                fengshu += 20;
            } else if (mathCount == 1) {
                fengshu += 10;
            }
            if (LowerCharCount > 0 && UpperCharCount > 0) {
                fengshu += 20;
            } else if (LowerCharCount == 0 && UpperCharCount > 0){
                fengshu += 10;
            } else if (UpperCharCount == 0 && LowerCharCount > 0){
                fengshu += 10;
            }

            if (fuhaoCount > 1) {
                fengshu += 20;
            } else if (fuhaoCount == 1) {
                fengshu += 10;
            }

            if (len >= 8) {
                fengshu += 25;
            } else if (len >= 5) {
                fengshu += 10;
            } else {
                fengshu += 5;
            }

            if (LowerCharCount > 0 && UpperCharCount > 0 && mathCount > 0 && fuhaoCount > 0) {
                fengshu += 5;
            } else if ((LowerCharCount > 0 || UpperCharCount > 0) && mathCount > 0 && fuhaoCount > 0) {
                fengshu += 3;
            } else if ((LowerCharCount > 0 || UpperCharCount > 0) && mathCount > 0) {
                fengshu += 2;
            }

            if (fengshu >= 90) {
                System.out.println("VERY_SECURE");
            } else if (fengshu >= 80) {
                System.out.println("SECURE");
            } else if (fengshu >= 70) {
                System.out.println("VERY_STRONG");
            } else if (fengshu >= 60) {
                System.out.println("STRONG");
            } else if (fengshu >= 50) {
                System.out.println("AVERAGE");
            } else if (fengshu >= 25) {
                System.out.println("WEAK");
            } else {
                System.out.println("VERY_WEAK");
            }
        }
    }
}
