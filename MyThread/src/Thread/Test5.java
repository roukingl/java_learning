package Thread;

public class Test5 {

    public static void main(String[] args) {
        Thread t = new Thread( () -> {
            while (true) {
                System.out.println("Lambda");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        while (true) {
            System.out.println("Main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
