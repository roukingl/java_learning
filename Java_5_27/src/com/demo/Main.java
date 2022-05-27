package com.demo;

import java.util.Arrays;

public class Main {

    public static String toString(int[] arary) {
        String ch = "[";
        for (int i = 0; i < arary.length; i++) {
            if (i < arary.length - 1) {
                ch = ch + arary[i] + "," + " ";
            } else {
                ch = ch + arary[i];
            }
        }
        ch += "]";
        return ch;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        System.out.println(toString(array));
    }
}

/*    public static int[] copyOf(int[] array, int length) {
        int[] copy = new int[length];

        for (int i = 0; i < length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 3, 32, 2, 5, 67, 45};

        int[] copy = copyOf(array, array.length);
        System.out.println(Arrays.toString(copy));
    }

}*/
/*
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 7;

        int subscript = binarySearch(array, target);
        System.out.println("下标subscript = " + subscript);

    }
}*/
/*
    public static void main(String[] args) {

        int[] array1 = {1, 3, 2, 4, 5};
        int[]array2 = Arrays.copyOf(array1, array1.length);
        Arrays.sort(array2);
        if (Arrays.equals(array1, array2)) {
            System.out.println("该数组是有序递增的");
        } else {
            System.out.println("该数组不是有序递增的");
        }

    }
}*/

/*//    给定一个整型数组, 实现冒泡排序(升序排序)

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

}*/

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