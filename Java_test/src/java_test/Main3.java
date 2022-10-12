package java_test;

import java.util.*;

public class Main3 {

    public static int MoreThanHalfNum_Solution (int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }
        int number = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!set.contains(numbers[i])) {
                set.add(numbers[i]);
                if (map.get(numbers[i]) > numbers.length / 2) {
                    return numbers[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int len = str.length();
        int start = 0;
        int maxLength = 0;
        int index = 0;
        while (index < len) {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                int newLength = 0;
                int newStart = 0;
                while (index < len && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                    if (newLength == 0) {
                        newStart = index;
                    }
                    index++;
                    newLength++;
                }
                if (newLength > maxLength) {
                    maxLength = newLength;
                    start = newStart;
                }
            } else {
                index++;
            }
        }
        System.out.println(str.substring(start, start + maxLength));
    }
}
