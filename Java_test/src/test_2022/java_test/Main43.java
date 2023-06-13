package test_2022.java_test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main43 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            set.add(i);
        }
        int len = Math.min(n, m);
        boolean[] flg = new boolean[len + 1];
        for (int i = 1; i <= len; i++) {
            if (set.contains(m - i) && !flg[i] && !flg[m - i]) {
                flg[i] = true;
                flg[m - i] = true;
                if (m - i == 0) {
                    System.out.println(i);
                } else {
                    System.out.println(i + " " + (m - i));
                }
            }
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[91];
            for (int i = 0; i < 10; i++) {
                arr[i + '0'] = i;
            }
            arr['A'] = arr['B'] = arr['C'] = 2;
            arr['D'] = arr['E'] = arr['F'] = 3;
            arr['G'] = arr['H'] = arr['I'] = 4;
            arr['J'] = arr['K'] = arr['L'] = 5;
            arr['M'] = arr['N'] = arr['O'] = 6;
            arr['P'] = arr['Q'] = arr['R'] = arr['S'] = 7;
            arr['T'] = arr['U'] = arr['V'] = 8;
            arr['W'] = arr['X'] = arr['Y'] = arr['Z'] = 9;
            Set<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                char[] ch = scanner.next().toCharArray();
                StringBuilder sb = new StringBuilder();
                for (char c : ch) {
                    if (c != '-') {
                        if (sb.length() == 3) {
                            sb.append('-');
                        }
                        sb.append(arr[c]);
                    }
                }
                set.add(sb.toString());
            }

            String[] strs = new String[set.size()];
            Iterator<String> iterator = set.iterator();
            for (int i = 0; iterator.hasNext(); i++) {
                strs[i] = iterator.next();
            }
            for (int i = 0; i < strs.length && strs[i] != null; i++) {
                int flg = i;
                for (int j = i + 1; j < strs.length && strs[j] != null; j++) {
                    if (strs[flg].compareTo(strs[j]) > 0) {
                        flg = j;
                    }
                }
                System.out.println(arr[flg]);
                strs[flg] = null;
            }
        }
    }
}
