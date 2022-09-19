package Test;

class MyBlockingQueue {

    private int[] elam = new int[1000]; // 用数组实现

    private volatile int size = 0; // 数组中有效数据的数目

    private volatile int head = 0; // 头

    private volatile int tail = 0; // 尾

    // 1. 加锁
    // 2. wait() , notify()
    // 3. while
    public void put(int value) throws InterruptedException {
        synchronized(this) {
            while (size >= elam.length) {
                this.wait();
            }
            elam[tail] = value;
            tail++;
            if (tail >= elam.length) {
                tail = 0;
            }
            size++;
            this.notify();
        }
    }

    public Integer take() throws InterruptedException {
        synchronized(this) {
            while (size == 0) {
                this.wait();
            }
            int ret = elam[head];
            head++;
            if (head >= elam.length) {
                head = 0;
            }
            size--;
            this.notify();
            return ret;
        }
    }
}

public class Demo {

    public static void main(String[] args) {

        MyBlockingQueue queue = new MyBlockingQueue();

        Thread t1 = new Thread( () -> {
            int i = 1;
            while (true) {
                try {
                    queue.put(i);
                    System.out.println("生产元素 " + i);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread( () -> {
            while (true) {
                try {
                    int ret = queue.take();
                    System.out.println("产出元素 " + ret);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

    }
}

