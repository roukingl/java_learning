package test_2022.java_9_30;

import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                        count.countDown();
                        System.out.println(count.getCount());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    /*public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count.getAndIncrement();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count.getAndIncrement();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);

    }*/

    /*static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                for (int i = 1; i <= 100; i++) {
                    count+=i;
                }
                return count;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();
        t.join();
        System.out.println(count);
    }*/

    /*static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 10000; i++) {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 10000; i++) {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }*/
}
    /*public static void main(String[] args) {

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(100);

        ExecutorService pool = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS, queue, new ThreadPoolExecutor.DiscardPolicy());
    }*/

