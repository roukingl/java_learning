package test_2022.java_test;

import java.util.*;

public class Main23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int aIndex = 0; // a
        int bIndex = 0; // b字符串的下标
        String max = null;
        String min = null;
        int lenA = a.length();
        int lenB = a.length();
        if (lenA < lenB) {
            max = b;
            min = a;
        } else {
            max = a;
            min = b;
        }
        int count = 0;
        int[] arr = new int[26];
        for (char ch : max.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (char ch : min.toCharArray()) {
            arr[ch - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            count += arr[i];
        }
//         for (int i = 0; i < a.length();) {
//             if (index < b.length() && a.charAt(i) == b.charAt(index)) {
//                 i++;
//                 index++;
//             } else {
//                 while (index < b.length() && a.charAt(i) != b.charAt(index)) {
//                     count++;
//                     index++;
//                 }
//             }
//         }
        System.out.println(count);
    }

    public int getValue(int[] gifts, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ret : gifts) {
            map.put(ret, map.getOrDefault(ret, 0) + 1);
            if (map.get(ret) > n / 2) {
                return ret;
            }
        }
        return 0;

    }

}
