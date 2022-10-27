package java_test;

import java.io.StringWriter;
import java.util.*;

public class Main16 {

    // j 106
    // q 113
    // k 107
    // a 97
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        String[] str = new String[2];
        for (char ch : s.toCharArray()) {
            if (ch == '-') {
                str[0] = sb.toString();
                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        }
        str[1] = sb.toString();
        System.out.println(compare(str));
    }

    private static String compare(String[] s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("3 ", 1);
        map.put("4 ", 2);
        map.put("5 ", 3);
        map.put("6 ", 4);
        map.put("7 ", 5);
        map.put("8 ", 6);
        map.put("9 ", 7);
        map.put("10", 8);
        map.put("J ", 9);
        map.put("Q ", 10);
        map.put("K ", 11);
        map.put("A ", 12);
        map.put("2 ", 13);
        int sum = 0;
        if (s[0].equals("joker JOKER") || s[1].equals("joker JOKER")) {
            return "joker JOKER";
        } else if (s[0].length() == 7 || s[1].length() == 7) {
            if (s[0].length() == 7 && s[1].length() == 7) {
                return map.get(s[0].substring(0, 2));
            } else if (s[0].length() == 7) {
                return s[0];
            } else {
                return s[1];
            }
        } else if (s[0].length() != s[1].length()) {
            return "ERROR";
        } else {

        }
    }*/

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 12; i <= n; i++) {
            List<Integer> list = div(i);
            int ret = 0;
            for (int j : list) {
                ret += j;
            }
            if (ret == i) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static List<Integer> div(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
