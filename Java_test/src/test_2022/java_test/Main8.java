package test_2022.java_test;

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
            int len = strings[i].length();
            if (len > maxLength) {
                maxLength = len;
            }
        }
        boolean l = isLengthSort(strings);
        boolean p = isLexicographicallySort(strings, maxLength);
        if (p && l) {
            System.out.println("both");
        } else if (p) {
            System.out.println("lexicographically");
        } else if (l) {
            System.out.println("lengths");
        } else {
            System.out.println("none");
        }

    }

    private static boolean isLengthSort(String[] strings) {
        int prevLength = strings[0].length();
        for (int i = 1; i < strings.length; i++) {
            int length = strings[i].length();
            if (length < prevLength) {
                return false;
            } else {
                prevLength = length;
            }
        }
        return true;
    }

    private static boolean isLexicographicallySort(String[] strings, int maxLength) {
        int[] maths = changeStrings(getStrings(strings, maxLength), maxLength);
        int prevMath = maths[0];
        for (int i = 1; i < strings.length; i++) {
            if (maths[i] < prevMath) {
                return false;
            } else {
                prevMath = maths[i];
            }
        }
        return true;
    }

    private static String[] getStrings(String[] strings, int maxLength) {
        String[] ret = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            int len = strings[i].length();
            StringBuilder stringBuilder = new StringBuilder(strings[i]);
            if (len < maxLength) {
                for (int j = 0; j < maxLength - len; j++) {
                    stringBuilder.append((char)('a' - 1));
                }
            }
            ret[i] = stringBuilder.toString();
        }
        return ret;
    }

    private static int[] changeStrings(String[] strings, int maxLength) {
        int[] maths = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            int math = 0;
            for (int j = 0; j < maxLength; j++) {
                math += (strings[i].charAt(j) - 'a' + 1) * Math.pow(24.0, maxLength - j - 1);
            }
            maths[i] = math;
        }
        return maths;
    }
}
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int ret = b;
        while (true) {
            if (ret % a == 0) {
                break;
            }
            ret += b;
        }
        System.out.println(ret);
    }*/

