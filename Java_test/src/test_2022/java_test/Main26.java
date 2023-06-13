package test_2022.java_test;

import java.util.*;

public class Main26 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double cat = fun(scanner.next());
            double r = fun(scanner.next());

            if (2 * 3.14 * r < cat) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }

    private static double fun(String number) {
        double ret = 0.0;
        for (char ch : number.toCharArray()) {
            ret = ret * 10 + ch - '0';
        }
        return ret;
    }

//    public int jumpFloorII (int number) {
//         if (number == 1 || number == 2) {
//             return number;
//         }
//         int sum = 1;
//         for (int i = number - 1; i > 0; i--) {
//             sum += jumpFloorII(i);
//         }
//         return sum;
//     }

        public int jumpFloorII (int number) {
            if (number == 1 || number == 2) {
                return number;
            }
            int[] dp = new int[number + 1];
            Arrays.fill(dp, 1);
            dp[2] = 2;
            for (int i = 3; i <= number; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] += dp[j];
                }
            }
            return dp[number];
        }
}
