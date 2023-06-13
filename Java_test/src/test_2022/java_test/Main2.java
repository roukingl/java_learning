package test_2022.java_test;

import java.util.Scanner;

public class Main2 {
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] strings = s.split(" ");
            for (int i = strings.length - 1; i >= 0; i--) {
                System.out.print(strings[i] + ' ');
            }
        }
    }*/

    private static boolean fun1(int[] array, int left, int right) {
        return array[left] <= array[right];
    }

    private static boolean fun2(int[] array, int left, int right) {
        return array[left] >= array[right];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            int count = 0;
            for (int i = 0; i < array.length - 1;) {
                boolean state1 = false;
                boolean state2 = false;
                while (i < array.length - 1 && fun1(array, i, i + 1)) {
                    i++;
                    if (!state1) {
                        state1 = true;
                    }
                }
                if (state1) {
                    count++;
                    i++;
                }
                while (i < array.length - 1 && fun2(array, i, i + 1)) {
                    i++;
                    if (!state2) {
                        state2 = true;
                    }
                }
                if (!state2) {
                    count++;
                    i++;
                }
            }
            System.out.println(count);
        }
    }
}





