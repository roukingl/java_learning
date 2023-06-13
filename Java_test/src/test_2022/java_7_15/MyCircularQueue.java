package test_2022.java_7_15;

// leetcode 622 设计循环队列
class MyCircularQueue {

    private int[] elam;

    // 队头的下标
    private int head;

    // 队尾的下标
    private int tail;

    public MyCircularQueue(int k) {
        this.elam = new int[k + 1];
    }
    
    public boolean enQueue(int value) {
        // 判满
        if (isFull()) {
            // 扩容
            return false;
        }
        // 从tail入队
        this.elam[tail] = value;
        tail = (tail + 1) % elam.length;
        return true;
    }
    
    public boolean deQueue() {
        // 判空
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % elam.length;
        return true;
    }
    
    public int Front() {
        // 判空
        if (isEmpty()) {
            return -1;
        }
        int ret = elam[head];
        return ret;
    }
    
    public int Rear() {
        // 判空
        if (isEmpty()) {
            return -1;
        }
        int index = tail == 0 ? elam.length - 1: tail - 1;
        int ret = elam[index];
        return ret;
    }
    
    public boolean isEmpty() {
        return tail == head;
    }
    
    public boolean isFull() {
        return (tail + 1) % elam.length == head;
    }
}