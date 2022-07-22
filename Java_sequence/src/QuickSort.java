
public class QuickSort {

    /**
     * Hoare法 快排
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public static void quickSort(int[] array) {
        quick(array, 0, array.length);
    }

    public static int getPriority(int[] array, int star, int end) {
        int i = star;
        int key = array[star];
        while (star < end) {
            while (array[end] > key) {
                end--;
            }
            while (array[star] < key) {
                star++;
            }
            swap(array, star, end);
        }
        // 已经相遇了
        swap(array, i, end);
        return i;
    }

    private static void quick(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int priority = getPriority(array, left, right);
        quick(array, left, priority - 1);
        quick(array, priority + 1, right);
    }

    private static void swap(int[] array, int subOne, int subSecond) {
        int tmp = array[subOne];
        array[subOne] = array[subSecond];
        array[subSecond] = tmp;
    }
}
