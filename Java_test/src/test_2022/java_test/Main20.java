package test_2022.java_test;

import java.util.*;

public class Main20 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        // s1是短的字符串，s2是长的字符串
        if (str1.length() > str2.length()) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        int maxLength = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = len1; j > 0; j--) {
                if (j - i < maxLength) {
                    break;
                }
                String str = str1.substring(i, j);
                int length = KMP(str, str2);
                if (length == len1) {
                    System.out.println(length);
                    return;
                }
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }
        System.out.println(maxLength);
    }

    private static int KMP(String str, String s) {
        char[] ch1 = str.toCharArray();
        char[] ch2 = s.toCharArray();
        int index1 = 0;
        int index2 = 0;
        int length = 0;
        int maxLength = 0;
        while (index1 < ch1.length && index2 < ch2.length) {
            while (index2 < ch2.length && ch1[index1] != ch2[index2]) {
                index2++;
            }
            while (index1 < ch1.length && index2 < ch2.length) {
                if (ch1[index1] == ch2[index2]) {
                    length++;
                    index1++;
                    index2++;
                } else {
                    break;
                }
            }
            if (length > maxLength) {
                maxLength = length;
            }
            if (index1 == ch1.length) {
                break;
            }


            index1 = 0;
        }
        return maxLength;
    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        int len1 = str1.length();
        int len2 = str2.length();
        // s1是短的字符串，s2是长的字符串
        if (len1 > len2) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }
        int maxLength = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = len1; j > 0; j--) {
                String str = str1.substring(i, j);
                if (str.length() < maxLength) {
                    break;
                }
                int length = KMP(str, str2);
                if (length == len1) {
                    System.out.println(length);
                    return;
                }
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }
        System.out.println(maxLength);
    }

    private static int KMP(String str, String s) {
        char[] ch = str.toCharArray();
        int index = 0;
        int length = 0;
        for (char tmp : s.toCharArray()) {
            if (length == ch.length) {
                break;
            }
            if (ch[index] == tmp) {

                index++;
                length++;
            }
        }
        return length;
    }*/

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] ch = scanner.next().toCharArray();
        int left = 0;
        int right = ch.length - 1;
        while (left < right) {
            swap(ch, left, right);
            left++;
            right--;
        }
        for (char tmp : ch) {
            System.out.print(tmp);
        }
    }

    private static void swap(char[] ch, int index1, int index2) {
        char tmp = ch[index1];
        ch[index1] = ch[index2];
        ch[index2] = tmp;
    }
}
