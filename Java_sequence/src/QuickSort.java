
public class QuickSort {

    /**
     * 快排
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    // Hoare法
    private static int getPivotHoare(int[] array, int start, int end) {
        int i = start;
        int key = array[start];
        while (start < end) {
            while (start < end && array[end] >= key) {
                end--;
            }
            while (start < end && array[start] <= key) {
                start++;
            }
            swap(array, start, end);
        }
        // 已经相遇了
        swap(array, i, start);
        return start;
    }

    // 挖坑法
    private static int getPivotDigging(int[] array, int start, int end) {
        int key = array[start];
        while (start < end) {
            while (start < end && array[end] >= key) {
                end--;
            }
            swap(array, start, end);
            while (start < end && array[start] <= key) {
                start++;
            }
            swap(array, start, end);
        }
        // 已经相遇了
        array[start] = key;
        return start;
    }

    // 前后指针法
    private static int getPivotPointer(int[] array, int start, int end) {
        int prev = start;
        int cur = start + 1;
        while (cur <= end) {
            if (array[cur] < array[start] && array[++prev] > array[start]) {
                swap(array, cur, prev);
            }
            cur++;
        }
        swap(array, prev, start);
        return prev;
    }

    private static void quick(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = getPivotPointer(array, left, right);
        quick(array, left, pivot - 1);
        quick(array, pivot + 1, right);
    }

    private static void swap(int[] array, int subOne, int subSecond) {
        int tmp = array[subOne];
        array[subOne] = array[subSecond];
        array[subSecond] = tmp;
    }
}
