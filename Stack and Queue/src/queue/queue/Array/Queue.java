package queue.queue.Array;

import queue.queue.Linked.ListNode;
import queue.queue.Linked.QueueIsEmptyException;

/**
 * 顺序表实现普通队列
 * 不考虑扩容
 * 不使用userSize
 */
public class Queue {

    private int[] elam;

    // 队头的下标
    private int head;

    // 队尾的下标
    private int tail;

    private static final int INITIAL_AMOUNT = 10;

    public Queue() {
        this.elam = new int[INITIAL_AMOUNT];
    }

    // 入队
    public void offer(int data) {
        // 判满
        if (isFull()) {
            // 扩容
            return;
        }
        // 从tail入队
        this.elam[tail] = data;
        tail = (tail + 1) % elam.length;
    }

    // 出队
    public int poll() {
        // 判空
        if (isEmpty()) {
            throw new QueueIsEmptyException("队列为空");
        }
        int ret = elam[head];
        head = (head + 1) % elam.length;
        return ret;
    }

    // 获得队头的值
    public int peek() {
        // 判空
        if (isEmpty()) {
            throw new QueueIsEmptyException("队列为空");
        }
        int ret = elam[head];
        return ret;
    }

    // 判断队列是否为空
    private boolean isEmpty() {
        return tail == head;
    }

    // 判断队列是否满
    private boolean isFull() {
        return (tail + 1) % elam.length == head;
    }
}
