import java.util.Stack;

public class QuickSort {

    /**
     * 快排
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public static void quickSort1(int[] array) {
        quick(array, 0, array.length - 1);
    }

    // Hoare法
    private static int getPivotHoare(int[] array, int start, int end) {
        int i = start;
        int key = array[start];
        while (start < end) {
            while (start < end && array[end] >= key) {
                end--;
            }
            while (start < end && array[start] <= key) {
                start++;
            }
            swap(array, start, end);
        }
        // 已经相遇了
        swap(array, i, start);
        return start;
    }

    // 挖坑法
    private static int getPivotDigging(int[] array, int start, int end) {
        int key = array[start];
        while (start < end) {
            while (start < end && array[end] >= key) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start] <= key) {
                start++;
            }
            array[end] = array[start];
        }
        // 已经相遇了
        array[start] = key;
        return start;
    }


    // 前后指针法
    private static int getPivotPointer(int[] array, int start, int end) {
        int prev = start;
        int cur = start + 1;
        while (cur <= end) {
            if (array[cur] < array[start] && array[++prev] != array[cur]) {
                swap(array, cur, prev);
            }
            cur++;
        }
        swap(array, prev, start);
        return prev;
    }

    // 三数取中法
    // 把left，right，mid下标三个数求得中间大小的数的下标
    private static int getMidNum(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (array[left] < array[right]) {
            if (array[mid] < array[left]) {
                return left;
            } else if (array[mid] > array[right]) {
                return right;
            } else {
                return mid;
            }
        } else {
            if (array[mid] < array[right]) {
                return right;
            } else if (array[mid] > array[left]) {
                return left;
            } else {
                return mid;
            }
        }
    }

    // 递归到末尾时，每一个区间已经趋于有序， 使用直接插入排序减少递归深度
    public static void insertSort(int[] array, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= start; j--) {
                // 加=变不稳定
                if (tmp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    private static void quick(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        if (right - left + 1 <= 7) {
            insertSort(array, left, right);
            return;
        }

        int index = getMidNum(array, left, right);
        // 交换中间数 和 left
        swap(array, index, left);
        int pivot = getPivotDigging(array, left, right);
        quick(array, left, pivot - 1);
        quick(array, pivot + 1, right);
    }

    private static void swap(int[] array, int subOne, int subSecond) {
        int tmp = array[subOne];
        array[subOne] = array[subSecond];
        array[subSecond] = tmp;
    }


    // 非递归实现快速排序
    public static void quickSort(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length - 1;
        // 三数取中解决递归深度问题
        int index = getMidNum(array, left, right);
        swap(array, index, left);

        int pivot = getPivotDigging(array, left, right);
        if (pivot > left + 1) {
            stack.push(left);
            stack.push(pivot - 1);
        }
        if (pivot < right - 1) {
            stack.push(pivot + 1);
            stack.push(right);
        }
        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();
            index = getMidNum(array, left, right);
            swap(array, index, left);
            pivot = getPivotDigging(array, left, right);
            if (pivot > left + 1) {
                stack.push(left);
                stack.push(pivot - 1);
            }
            if (pivot < right - 1) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }
}
