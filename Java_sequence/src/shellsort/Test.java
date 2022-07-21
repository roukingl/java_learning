package shellsort;


import java.util.Arrays;
import java.util.Random;

public class Test {

    public static void difTimeSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long beginTime = System.currentTimeMillis();
        ShellSort.shellSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔排序时间差 " + (endTime - beginTime));
    }

    public static void main(String[] args) {
        int[] array = new int[10_0000];
        inItArraysNotSort(array);
        //inItArraysSort(array);
        difTimeSort(array);
    }

    public static void inItArraysNotSort(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100_0000);
        }
    }

    public static void inItArraysSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }
}
