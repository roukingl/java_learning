/**
 * 希尔排序
 * 时间复杂度：O(n^1.3 - n^1.6)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 */
public class ShellSort {

    private static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (tmp < array[j]) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }
    
    public static void shellSort(int[] array) {
        int gap = array.length - 1;
        while (gap > 1) {
            shell(array, gap);
            gap /= 2;
        }
        shell(array, 1);
    }

    public static void main(String[] args) {
        int[] arr = {343, 3, 45, 6, 36, 10};
        shellSort(arr);
        System.out.println();
    }
}
