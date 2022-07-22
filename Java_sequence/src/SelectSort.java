
public class SelectSort {

    /**
     * 直接选择排序
     * 时间复杂度：O(n^2) -- 不论有序和无序都一样，对数据不敏感
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param array 要排序的数组
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    private static void swap(int[] array, int subOne, int subSecond) {
        int tmp = array[subOne];
        array[subOne] = array[subSecond];
        array[subSecond] = tmp;
    }
}
