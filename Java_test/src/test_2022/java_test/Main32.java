package test_2022.java_test;
import java.util.Scanner;

public class Main32 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            String[] strs = str.split(" ");
            int[] numbers = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                numbers[i] = Integer.parseInt(strs[i]);
            }
            boolean[] bool = {panduanRun(numbers[0]), panduanRun(numbers[3])};
            int a = numbers[3] - numbers[0];
            boolean[] suMouth = {false, false, true, true, false, true, false, true, false, false, false, true, false};
            int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if (a > 0) {
                // 不同年份
                for (int i = numbers[1]; i < numbers[4]; i++) {

                }
            } else {
                // 相同年份
                boolean runYear = panduanRun(numbers[0]); // true 闰年
                int b = numbers[4] - numbers[1];
                if (b == 0) {
                    // 相同月份, 看这一月是否是素数
                    if (suMouth[numbers[1]]) {
                        // 每天赚一块
                        int c = numbers[5] - numbers[2] + 1;
                        System.out.println(c);
                    } else {
                        // 每天赚两块
                        int c = numbers[5] - numbers[2] + 1;
                        System.out.println(2 * c);
                    }
                } else {
                    // 不同月份
                    if (numbers[1] > 2 || numbers[4] < 2) {
                        // 没经过二月
                        int sub = 0;
                        for (int i = numbers[1]; i < numbers[4]; i++) {
                            if (i == numbers[1]) {
                                if (suMouth[i]) {
                                    sub += days[i] - numbers[2] + 1;
                                } else {
                                    sub += 2 * (days[i] - numbers[2] + 1);
                                }
                            } else {
                                if (suMouth[i]) {
                                    sub += days[i];
                                } else {
                                    sub += 2 * days[i];
                                }
                            }

                        }
                        if (suMouth[numbers[4]]) {
                            sub += numbers[5];
                        } else {
                            sub += 2 * numbers[5];
                        }
                        System.out.println(sub);
                    } else {
                        // 经过二月, 要判断是否是闰年
                        int sub = 0;
                        for (int i = numbers[1]; i < numbers[4]; i++) {
                            if (i == 2) {
                                if (panduanRun(numbers[0])) {
                                    sub += 29;
                                } else {
                                    sub += 28;
                                }
                                continue;
                            }
                            if (suMouth[i]) {
                                sub += days[i];
                            } else {
                                sub += 2 * days[i];
                            }
                        }
                        if (suMouth[numbers[5]]) {
                            sub += numbers[5];
                        } else {
                            sub += 2 * numbers[5];
                        }
                        System.out.println(sub);
                    }
                }
            }

        }
    }

    // 返回true就是闰年, 返回false就不是闰年
    private static boolean panduanRun(int year) {
        if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
            return true;
        }
        return false;
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] fib = new int[100001];
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            fib[0] = 1;
            fib[1] = 1;
            if (fib[2] == 0) {
                for (int i = 2; i < 100001; i++) {
                    fib[i] = (fib[i - 1] + fib[i - 2]) % 1000000;
                }
            }
            System.out.println(fib[n]);
        }
    }
}
