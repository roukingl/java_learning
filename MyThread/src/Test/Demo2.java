package Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyThreadPool {

    private BlockingQueue<Runnable> queue;

    public MyThreadPool(int ThreadsCount) {
        queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < ThreadsCount; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        Runnable ret = queue.take();
                        ret.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }

    public void submit (Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }
}

// 线程池
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            int stdId = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行当前任务" + stdId + " 线程id" + Thread.currentThread().getName());
                }
            });
        }
    }
    
}
