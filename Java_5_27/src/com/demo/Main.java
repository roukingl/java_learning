package com.demo;

import java.util.Arrays;

public class Main {

//    给定一个整型数组, 实现冒泡排序(升序排序)

    public static int[] bubbleserch(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = true;
                }
            }
            if(flag == false) {
                return array;
            }
        }
        return array;
    }

    public static void main(String[] args) {

        int[] array = {5, 6, 7, 2, 7, 32, 74, 67};

        System.out.println(Arrays.toString(bubbleserch(array)));
    }

}

/*    public static int[] search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] > target) {
                    continue;
                } else if (nums[i] + nums[j] == target) {
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 15};
        int target = 9;

        System.out.println(Arrays.toString(search(nums, target)));
    }

}*/

/*    public static void main(String[] args) {

        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }
}*/

/*
    public static void transforrm(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * 2;
        }

    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        transforrm(array);
        for (int x: array) {
            System.out.print(x + " ");
        }

    }

}
*/