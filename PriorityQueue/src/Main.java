
public class Main {

    public static void main(String[] args) {
        int[] array = { 27, 15, 19, 18, 28, 34, 65, 49, 25, 37};
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.initHeap(array);
        priorityQueue.createHeap();
        priorityQueue.display();
        priorityQueue.push(56);
        priorityQueue.push(99);
        priorityQueue.display();
        priorityQueue.pollHeap();
        priorityQueue.display();
    }
}
