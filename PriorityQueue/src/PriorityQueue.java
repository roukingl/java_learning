import java.util.Arrays;

public class PriorityQueue {
    // 用数组存储
    private int[] elem;
    // 数组中有效数据的个数
    private int usedSize;

    public PriorityQueue() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    // 扩容
    private void growQueue() {
        this.elem = Arrays.copyOf(elem, 2 * elem.length);
    }

    /**
     * 初始化数组
     * @param array 初始化的目标
     */
    public void initHeap(int[] array) {
        this.elem = Arrays.copyOf(array, array.length);
        this.usedSize = array.length;
    }

    /**
     * 建堆的时间复杂度：O(n)
     */
    public void createHeap() {
        for (int i = (usedSize - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(i, usedSize);
        }
    }

    /**
     * 向下调整
     * @param root 是每棵子树的根节点的下标
     * @param end  是每棵子树调整结束的结束条件
     * 向下调整的时间复杂度：O(logn)
     */
    private void shiftDown(int root,int end) {
        // 存放大的孩子的下标
        int child = 2 * root + 1;
        while (child < end) {
            // 如果右孩子大，下标指向右孩子，而且要有右孩子，
            if (child + 1 < end && elem[child + 1] > elem[child]) {
                child++;
            }
            // 比较child下标的孩子和根的大小关系
            if (elem[child] > elem[root]) {
                // 交换后还要向下判断，根变成大的孩子下标，因为要判断再下一层的大小关系
                swap(child, root);
                root = child;
                child = 2 * child + 1;
            } else {
                break;
            }
        }
    }
    private void swap(int i, int j) {
        int tmp = this.elem[i];
        this.elem[i] = this.elem[j];
        this.elem[j] = tmp;
    }

    /**
     * 入队：仍然要保持是大根堆
     * @param val 入队的数
     */
    public void push(int val) {
        // 先把要入队的放在最后一位，在向上调整
        if (isFull()) {
            growQueue();
        }
        this.elem[usedSize] = val;
        shiftUp(usedSize);
        this.usedSize++;
    }

    /**
     * 向上调整堆
     * @param child 堆元素的下标
     */
    private void shiftUp(int child) {
        int root = (child - 1) / 2;
        while (root >= 0) {
            if (elem[child] > elem[root]) {
                swap(child, root);
                child = root;
                root = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    // 判断堆有没有满
    public boolean isFull() {
        return elem.length == usedSize;
    }

    /**
     * 出队【删除】：每次删除的都是优先级高的元素
     * 仍然要保持是大根堆
     */
    public void pollHeap() {
        if (isEmpty()) {
            throw new HeapEmptyException("堆空了");
        }
        // 把最后一个元素和第一个换，usedSize--，再向下调整
        swap(0, usedSize - 1);
        this.usedSize--;
        shiftDown(0, usedSize);
    }

    // 判断堆是不是空
    public boolean isEmpty() {
        return usedSize == 0;
    }

    /**
     * 获取堆顶元素
     * @return 返回int类型的堆顶元素
     */
    public int peekHeap() {
        return elem[0];
    }

    public int[] getElem() {
        return this.elem;
    }

    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(elem[i] + " ");
        }
        System.out.println();
    }
}