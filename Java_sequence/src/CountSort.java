
public class CountSort {

    /**
     * 计数排序
     * 时间复杂度：O(N + 范围)
     * 空间复杂度：O(范围)
     * 稳定性：待定
     * @param array 要排序的数组
     */
    public static void countSort(int[] array) {
        int minNum = array[0];
        int maxNum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxNum) {
                maxNum = array[i];
            }
            if (array[i] < minNum) {
                minNum = array[i];
            }
        }

        int[] count = new int[maxNum - minNum + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - minNum]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                array[index] = i + minNum;
                index++;
                count[i]--;
            }
        }
    }
}
