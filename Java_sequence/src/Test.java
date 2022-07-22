import java.util.Arrays;
import java.util.Random;

public class Test {

    public static void difTimeInsertSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long beginTime = System.currentTimeMillis();
        InsertSort.insertSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("直接插入排序时间差 " + (endTime - beginTime));
    }

    public static void difTimeShellSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long beginTime = System.currentTimeMillis();
        ShellSort.shellSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序时间差 " + (endTime - beginTime));
    }

    public static void difTimeSelectSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long beginTime = System.currentTimeMillis();
        SelectSort.selectSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("直接选择排序时间差 " + (endTime - beginTime));
    }

    public static void difTimeHeapSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long beginTime = System.currentTimeMillis();
        HeapSort.heapSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排序时间差 " + (endTime - beginTime));
    }

    public static void difTimeQuickSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long beginTime = System.currentTimeMillis();
        QuickSort.quickSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("快排Korae法序时间差 " + (endTime - beginTime));
    }

    public static void main1(String[] args) {
        int[] array = new int[10_0000];
        inItArraysNotSort(array); // 无序
        //inItArraysSort(array); // 有序
        //inItArraysReverseSort(array); // 逆序
        //difTimeInsertSort(array);
        difTimeShellSort(array);
        //difTimeSelectSort(array);
        difTimeHeapSort(array);
    }

    public static void main(String[] args) {
        int[] arr = {343, 3, 45, 6, 36, 10};
        QuickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 无序
    public static void inItArraysNotSort(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10_0000);
        }
    }

    // 逆序
    public static void inItArraysReverseSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
    }

    // 有序
    public static void inItArraysSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }
}
