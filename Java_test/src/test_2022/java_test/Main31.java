package test_2022.java_test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            list.add(2);
            for (int j = 3; j <= a; j += 2) {
                boolean flg = true;
                for (int i = 2; i <= Math.sqrt(j); i++) {
                    if (j % i == 0) {
                        flg = false;
                        break;
                    }
                }
                if (flg) {
                    list.add(j);
                }
            }
            int index = 0;
            System.out.print(a + " = ");
            while (a >= 2 || index > list.size()) {
                int b = list.get(index);
                if (a % b == 0) {
                    a = a / b;
                    if (a >= 2) {
                        System.out.print(b + " * ");
                    } else {
                        System.out.print(b);
                    }
                } else {
                    index++;
                }
            }
        }
    }
}
