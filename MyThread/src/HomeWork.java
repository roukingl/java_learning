import java.util.Arrays;
import java.util.Random;

public class HomeWork {

    public static void setArrayRandom(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1;
        }
    }

    public static int sum1 = 0;
    public static int sum2 = 0;
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[1000_0000];
        setArrayRandom(array);
        long begin = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array.length; i += 2) {
                    sum1 += array[i];
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < array.length; i += 2) {
                    sum2 += array[i];
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("运行时间 " + (end - begin));
        System.out.println("数据总和 " + (sum1 + sum2));
    }
}
