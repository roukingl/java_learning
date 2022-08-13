
class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        while (true) {
            System.out.println("main");
            Thread.sleep(1000);
        }
    }
}
