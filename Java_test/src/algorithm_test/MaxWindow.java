package algorithm_test;

import java.util.Arrays;
import java.util.LinkedList;

public class MaxWindow {

    public static int[] getMaxWindow(int[] arr, int width) {
        if (arr == null || width < 1 || arr.length < width) {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>();
        int[] result = new int[arr.length - width + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
                list.pollLast();
            }
            list.addLast(i);
            if (list.peekFirst() == i - width) {
                list.pollFirst();
            }
            if (i >= width - 1) {
                result[index] = arr[list.peekFirst()];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array =  {5, 2, 7, 3, 4, 5, 2, 1, 6};
        int[] result = getMaxWindow(array, 3);
        System.out.println(Arrays.toString(result));
    }
}
