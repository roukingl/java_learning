package Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class MyTask implements Comparable<MyTask> {

    private Runnable command;
    private long time;

    public MyTask(Runnable runnable, long time) {
        this.command = runnable;
        this.time = System.currentTimeMillis() + time;
    }

    public Runnable getCommand() {
        return command;
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTask o) {
        return (int)(this.time - o.time);
    }
}

class MyTimer {

    private PriorityBlockingQueue<MyTask> queue = new PriorityBlockingQueue<>();

    private Object locker = new Object();

    public void schedule(Runnable r, long after) {
        MyTask task = new MyTask(r, after);
        queue.put(task);
        synchronized (locker) {
            locker.notify();
        }
    }

    public MyTimer() {
        // 启动一个线程不断扫描时间到没到
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        synchronized (locker) {
                            MyTask tmp = queue.take();
                            long currentTime = System.currentTimeMillis();
                            if (currentTime >= tmp.getTime()) {
                                // 到点了,运行
                                tmp.getCommand().run();
                            } else {
                                // 没到点, 放回去,
                                queue.put(tmp);
                                locker.wait(tmp.getTime() - currentTime);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }
}

// 计时器
public class Demo1 {

    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间1到");
            }
        }, 1000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间2到");
            }
        }, 2000);

        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("时间3到");
            }
        }, 3000);


    }
}
