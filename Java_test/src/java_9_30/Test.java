package java_9_30;

import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) {

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(100);

        ExecutorService pool = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS, queue, new ThreadPoolExecutor.DiscardPolicy());
    }
}
