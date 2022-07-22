
public class HeapSort {

    /**
     * 堆排序
     * 时间复杂度：O(N*log2N)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * 大量数据时希尔排序比堆排序快
     */
    public static void heapSort(int[] array) {
        creatBigHeap(array);
        for (int end = array.length - 1; end >= 0; end--) {
            swap(array, 0, end);
            shiftDown(array, 0, end);
        }

    }

    private static void creatBigHeap(int[] array) {
        for (int parent = (array.length - 1 -1 ) / 2; parent >= 0; parent--) {
            shiftDown(array, parent, array.length);
        }
    }

    private static void shiftDown(int[] array, int root, int end) {
        int child = 2 * root + 1;
        // 有左孩子
        while (child < end) {
            if (child + 1 < end && array[child + 1] > array[child]) {
                child++;
            }
            if (array[child] > array[root]) {
                swap(array, child, root);
                root = child;
                child = 2 * root + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] array, int subOne, int subSecond) {
        int tmp = array[subOne];
        array[subOne] = array[subSecond];
        array[subSecond] = tmp;
    }
}
