package java_test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main35 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String strs = scanner.nextLine();
            String name = scanner.next();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < strs.length(); i++) {
                char ch = strs.charAt(i);
                if (ch == '\"') {
                    StringBuilder sb = new StringBuilder();
                    while (ch != '\"') {
                        i++;
                        ch = strs.charAt(i);
                        if (ch == '\"') {
                            break;
                        } else {
                            sb.append(ch);
                        }
                    }
                    list.add(sb.toString());
                } else if (ch == ',') {
                } else {
                    StringBuilder sb = new StringBuilder();
                    while (ch != ',') {
                        sb.append(ch);
                        i++;
                        if (i < strs.length()) {
                            ch = strs.charAt(i);
                        } else {
                            break;
                        }
                    }
                    list.add(sb.toString());
                }
            }
            boolean flg = true;
            for (String s : list) {
                if (s.equals(name)) {
                    System.out.println("Ignore");
                    flg = false;
                    break;
                }
            }
            if (flg) {
                System.out.println("Important!");
            }
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            double sub = 1.0;
            for (int i = n; i > 1; i--) {
                sub *= 1.0/i;
            }
            System.out.printf("%4.2f%%\n", sub * (n - 1) * 100);
        }
    }
}
