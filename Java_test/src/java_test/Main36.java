package java_test;

import java.util.*;

public class Main36 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            List<LinkedList<String>> list = new ArrayList<>();
            LinkedList<String> linkedlistOne = new LinkedList<>();
            String first = scanner.next();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < first.length(); i++) {
                char ch = first.charAt(i);
                if (i != 0 && ch == '/') {
                    linkedlistOne.add(sb.toString());
                    sb = new StringBuilder();
                    sb.append(ch);
                } else {
                    sb.append(ch);
                }
            }
            linkedlistOne.add(sb.toString());
            LinkedList<String> linkedlist = null;
            for (int i = 0; i < n - 1; i++) {
                // 剩下的n - 1 个命令
                String mingLing = scanner.next();
                sb = new StringBuilder();
                int k = 0; // 判断链表里的第几个目录
                for (int j = 0; j < mingLing.length(); j++) {
                    char ch = mingLing.charAt(j);
                    if (j != 0 && ch == '/') {
                        // 判断
                        if (!linkedlistOne.get(k).equals(sb.toString())) {
                            linkedlist = new LinkedList<>();
                            linkedlist.add(sb.toString());
                            sb = new StringBuilder();
                            continue;
                        }

                    } else {
                        sb.append(ch);
                    }
                }
            }
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[26];
            int max = 0;
            char ch = 0;
            for (int i = 0; i < 2 * n; i++) {
                String id = scanner.next();
                if (i % 2 == 0) {
                    ch = id.charAt(0);
                    arr[ch - 'A']++;
                    max = getMax(arr);
                } else {
                    if (id.equals("connect")) {
                        arr[ch - 'A']--;
                    } else {

                    }
                }
            }
            System.out.println(max);
        }
    }

    public static int getMax(int[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            n += arr[i];
        }
        return n;
    }
}
