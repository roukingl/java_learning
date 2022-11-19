package java_test;

import java.util.*;

public class Main30 {

    public static void main(String[] args) {
        int[] nums = new int[10001];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i < 10001; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
            nums[i] = nums[i] % 10000;
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int ret = nums[scanner.nextInt()];
                System.out.printf("%04d", ret);
            }
            System.out.println();
        }
    }

    // error
    /*public static String fib(int n) {
        long a = 0;
        long b = 1;
        long c = 0;
        while (n != 0) {
            c = a + b;
            a = b;
            b = c;
            n--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (c == 0) {
                sb.append(0);
            } else {
                sb.append(c % 10);
                c = c / 10;
            }
        }
        return sb.reverse().toString();
    }*/

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int count = 0;
            int i = 2;
            Set<Integer> set = new HashSet<>();
            while (n != 1) {
                if (n % i == 0) {
                    if (set.add(i)) {
                        count++;
                        i = 2;
                    }
                    n = n / i;
                } else {
                    i++;
                }
            }
            System.out.println(count);
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String lightPassword = scanner.nextLine();
            StringBuilder stringbuilder = new StringBuilder();
            for (char ch : lightPassword.toCharArray()) {
                if (ch >= 'A' && ch <= 'E') {
                    stringbuilder.append((char) (ch + 32 - 11));
                } else if (ch >= 'F' && ch <= 'Z') {
                    stringbuilder.append((char) (ch - 5));
                } else {
                    stringbuilder.append(ch);
                }
            }
            System.out.println(stringbuilder.toString());
        }
    }
}
