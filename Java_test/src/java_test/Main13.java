package java_test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (suShu(n).size() == 0 || suShu(m).size() == 0) {
                System.out.print(-1);
                break;
            } else if (n == m) {
                System.out.print(0);
            } else {
                int count = 0;
                HashSet<Integer> set = new HashSet<>(suShu(m));
                while (n != m) {
                    List<Integer> nList = suShu(n);
                    for (int i = nList.size() - 1; i >= 0; i--) {
                        if (set.contains(nList.get(i))) {
                            n = n + nList.get(i);
                            count++;
                            break;
                        }
                    }
                }
                System.out.print(count);
            }
        }
    }

    private static List<Integer> suShu(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String s = scanner.nextLine();
        int len = s.length();
        boolean flg = false;
        for (int i = 0; i < len;) {
            if (s.charAt(i) == '\"') {
                flg = true;
                i++;
            } else {
                StringBuilder sb = new StringBuilder();
                while (flg || (i < len && s.charAt(i) != ' ' && s.charAt(i) != '\"')) {
                    sb.append(s.charAt(i));
                    i++;
                    if (i + 1 < len && s.charAt(i + 1) == '\"') {
                        flg = false;
                    }
                }
                i++;
                if (!sb.toString().equals("")) {
                    list.add(sb.toString());
                }
            }
        }
        int index = 0;
        int size = list.size();
        System.out.println(size);
        for (String value : list) {
            System.out.println(value);
        }
    }


}
