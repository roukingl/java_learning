package insertsort;

public class Sort {

    /**
     * 直接插入排序
     *  时间复杂度：最坏情况   O(n^2)   逆序
     *             最好情况   O(n)     有序
     *  空间复杂度：O(1)
     *  稳定性：稳定
     * @param array 要排序的数组
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // 加=变不稳定
                if (tmp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
                array[j + 1] = tmp;
            }
        }
    }
}
