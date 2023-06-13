package test_2022.java_test;

import java.util.*;

public class Main17 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toLowerCase();
        char ch = scanner.next().charAt(0);
        if (ch >= 'A' && ch <= 'Z') {
            ch += 32;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ret = s.charAt(i);
            if (ret == ch) {
                count += 1;
            }
        }
        System.out.println(count);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = getList(n);
        boolean flg = false;
        for (int i = 1; i < list.size() - 1; i++) {
            int ret = list.get(i);
            if (ret % 2 == 0) {
                flg = true;
                System.out.println(i + 1);
                break;
            }
        }
        if (!flg) {
            System.out.println(-1);
        }
    }

    private static List<Integer> getList(int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        list.add(first);
        for (int i = 1; i <= n - 1; i++) {
            List<Integer> ret = new ArrayList<>();
            ret.add(1);
            ret.add(i);
            List<Integer> prevList = list.get(i - 1);
            for (int j = 2; j <= i; j++) {
                ret.add(getNumber(prevList, j));
            }
            ret.add(1);
            list.add(ret);
        }
        return list.get(n - 1);
    }

    private static int getNumber(List<Integer> prevList, int j) {
        int sum = 0;
        int len = prevList.size();
        if (j >= 0 && j < len) {
            sum += prevList.get(j);
        }
        if (j - 1 >= 0 && j - 1 < len) {
            sum += prevList.get(j - 1);
        }
        if (j - 2 >= 0 && j - 2 < len) {
            sum += prevList.get(j - 2);
        }
        return sum;
    }
}
