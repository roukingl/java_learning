package insertsort;

import java.util.Arrays;
import java.util.Random;

public class TestSort {

    public static void difTimeSort(int[] array) {
        array = Arrays.copyOf(array,array.length);
        long beginTime = System.currentTimeMillis();
        Sort.insertSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("直接插入排序时间差 " + (endTime - beginTime));
    }

    public static void main(String[] args) {
        //int[] array = new int[]{1, 34, 54, 67, 8768, 343, 4};
        //System.out.println(Arrays.toString(array));
        int[] array = new int[10_0000];
        //inItArraysNotSort(array);
        inItArraysSort(array);
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
            array[i] = array.length - i;
        }
    }
}
