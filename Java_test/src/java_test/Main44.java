package java_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main44 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] str = scanner.nextLine().toCharArray();
            List<String> list = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : str) {
                if (ch >= 'a' && ch <= 'z' || (ch >= 'A' && ch <= 'Z')) {
                    stringBuilder.append(ch);
                } else {
                    if (stringBuilder.length() > 0) {
                        list.add(stringBuilder.toString());
                        stringBuilder.delete(0, stringBuilder.length());
                    }
                }
            }
            if (stringBuilder.length() > 0) {
                list.add(stringBuilder.toString());
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.println(list.get(i) + " ");
            }
            System.out.println();
        }

    }


    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] str = scanner.next().toCharArray();
            boolean flg = false;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.length; i++) {
                if (str[i] != '_') {
                    if (flg) {
                        flg = false;
                        str[i] = Character.toUpperCase(str[i]);
                    }
                    stringBuilder.append(str[i]);
                } else {
                    flg = true;
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
