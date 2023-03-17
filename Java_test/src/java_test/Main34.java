package java_test;
import java.util.Scanner;

public class Main34 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            String[] names = new String[n];
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                names[i] = scanner.nextLine();
            }
            int x = 1;
            for (String str : names) {
                boolean flg = true;
                for (char ch : str.toCharArray()) {
                    if (ch == ',' || ch == ' ') {
                        flg = false;
                        break;
                    }
                }
                if (x == 1) {
                    if (flg) {
                        System.out.print(str);
                    } else {
                        System.out.print("\"" + str + "\"");
                    }
                } else {
                    if (flg) {
                        System.out.print(", " + str);
                    } else {
                        System.out.print(", \"" + str + "\"");
                    }

                }
                x++;
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            long a = 1; // 小兔子数量
            long b = 0; // 刚刚成熟兔子数量
            long c = 0; // 已经可以生小兔子的成熟兔子数量
            for (int i = 0; i < n; i++) {
                c = c + b;
                b = a;
                a = c;
            }
            System.out.println(a + b + c);
        }
    }
}