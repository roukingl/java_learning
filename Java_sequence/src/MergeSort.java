import java.util.Arrays;

public class MergeSort {

    /**
     * 归并排序
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     * 稳定性：稳定
     *
     * @param array 要排序的数组
     */
    public static void mergeSort1(int[] array) {
        dismantleArrays(array, 0, array.length - 1);
    }

    private static void dismantleArrays(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        dismantleArrays(array, left, mid);
        dismantleArrays(array, mid + 1, right);
        merge(array, left, right, mid);
    }

    private static void merge(int[] array, int start, int end, int midIndex) {
        int[] tmp = new int[end - start + 1];
        int k = 0;
        int s1 = start;
        int s2 = midIndex + 1;

        while (s1 <= midIndex && s2 <= end) {
            if (array[s1] <= array[s2]) {
                tmp[k++] = array[s1++];
            } else {
                tmp[k++] = array[s2++];
            }
        }
        // 有一边已经完了，把另一边传进去
        while (s1 <= midIndex) {
            tmp[k++] = array[s1++];
        }
        while (s2 <= end) {
            tmp[k++] = array[s2++];
        }
        for (int i = 0; i < k; i++) {
            array[i + start] = tmp[i];
        }
    }

    // 非递归实现归并排序
    public static void mergeSort(int[] array) {
        // 分组，以二倍增长
        int gap = 1;
        // 当gap=array.length或gap>array.length时已排序完
        while (gap < array.length) {
            for (int i = 0; i < array.length; i = i + gap * 2) {
                int e1 = i + gap - 1;
                if (e1 >= array.length) {
                    e1 = array.length - 1;
                }
                int e2 = e1 + gap;
                if (e2 >= array.length) {
                    e2 = array.length - 1;
                }
                merge(array, i, e2, e1);
            }
            gap *= 2;
        }
    }
}
