package com.company;

public class Main {

    public static int addCountProblem(int number_a, int number_b) {
        return number_a + number_b;
    }

    public static double addCountProblem(double number_a, double number_b) {
        return number_a + number_b;
    }

    public static void main(String[] args) {

        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8,};

        for (int i = 0; i < Integer.bitCount(342); i++) {
            System.out.println(arr[i]);
        }

        /*int a = 19;
        int b = 212;
        System.out.println(addCountProblem(a, b));
        double x = 324.34;
        double y = 899.43;
        System.out.println(addCountProblem(x, y));
        */
        /*
        for (int count = 1; count <= 100; count++) {
            if(count % 3 == 0 && count % 5 == 0) {
                System.out.println("count = " + count);
            } else {
                continue;
            }
        }
        */

    }


//
//    public static void main(String[] args) {
//        int sumJi = 0;
//        int sumOu = 0;
//        for (int i = 1; i <= 100; i++) {
//            if (i % 2 == 0) {
//                sumOu += i;
//            } else {
//                sumJi += i;
//            }
//        }
//        System.out.println("sumJi = " + sumJi);
//        System.out.println("sumOu = " + sumOu);
//        System.out.println("sum = " + (sumJi + sumOu));
//    }
}
