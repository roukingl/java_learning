package java_test;

import java.util.*;

public class Main18 {



    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            long bigTuZi = 0;
            long tuzi_1 = 1;
            long tuzi_2 = 0;
            long tmp = 0; // 生的兔子数量
            for (int i = 2; i <= n; i++) {
                bigTuZi += tuzi_2;
                tmp = bigTuZi;
                tuzi_2 = tuzi_1;
                tuzi_1 = tmp;

            }
            System.out.println(bigTuZi + tuzi_1 + tuzi_2);
        }
    }
}
