package Test;

// 阻塞队列
// 阻塞队列无法查看队头的数据,只能取出查看
public class Demo1 {

    private int[] elam; // 用数组实现

    private int size; // 数组中有效数据的数目

    private int head = 0; // 头

    private int tail = 0; // 尾

    Object locker = new Object();

    public Demo1() {
        elam = new int[10];
    }

    // 1. 加锁
    // 2. wait() , notify()
    // 3. while
    public void put(int value) throws InterruptedException {
        synchronized(locker) {
            while (size >= elam.length) {
                locker.wait();
            }
            elam[tail] = value;
            tail++;
            if (tail == elam.length) {
                tail = 0;
            }
            locker.notify();
        }
    }

    public Integer take() throws InterruptedException {
        synchronized(locker) {
            if (size <= 0) {
                locker.wait();
            }
            int ret = elam[head];
            head--;
            if (head == elam.length) {
                head = 0;
            }
            locker.notify();
            return ret;
        }
    }
}








