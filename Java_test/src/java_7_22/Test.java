package java_7_22;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {

    public int[] smallestK(int[] arr, int k) {
        // 建立一个最大栈，比栈顶小的放进去
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            maxPQ.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (!maxPQ.isEmpty() && maxPQ.peek() > arr[i]) {
                maxPQ.poll();
                maxPQ.offer(arr[i]);
            }
        }

        int[] array = new int[k];
        for (int i = 0; !maxPQ.isEmpty(); i++) {
            array[i] = maxPQ.poll();
        }
        return array;
    }










    public static void main(String[] args) {
        int[] array = {1, 3, 6, 2, 56, 45};
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < array.length; i++) {
            maxPQ.offer(array[i]);
        }
        System.out.println(maxPQ.poll());
    }
}
