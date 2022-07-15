package queue.queue.Array;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.offer(23);
        queue.offer(456);
        queue.offer(876);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
