package queue.queue.Linked;


public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.offer(121);
        queue.offer(56);
        queue.offer(87);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
