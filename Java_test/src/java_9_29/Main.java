package java_9_29;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        for (int i = 0; i < 10; i++) {
            Thread a = new Thread(() -> {
                System.out.print("A");
            });
            Thread b = new Thread(() -> {
                try {
                    a.join();
                    System.out.print("B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread c = new Thread(() -> {
                try {
                    b.join();
                    System.out.print("C");
                    System.out.println();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            a.start();
            b.start();
            c.start();

            a.join();
            b.join();
            c.join();
        }
    }

/*    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            System.out.println("a线程名字: " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread b = new Thread(() -> {
            System.out.println("b线程名字: " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread c = new Thread(() -> {
            System.out.println("c线程名字: " + Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        c.start();
        b.start();
        a.start();
        c.join();
        b.join();
        a.join();
    }*/

/*    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    synchronized(object) {
                        count++;
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    synchronized(object) {
                        count++;
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("count = " + count);
    }*/

    /*static int number = 0;
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(() -> {
                System.out.println(number++);

            });
            t.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.join();
        }
        System.out.println("OK");
    }*/
}
