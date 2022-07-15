package queue.queue.Linked;

public class QueueIsEmptyException extends RuntimeException{

    public QueueIsEmptyException() {
    }

    public QueueIsEmptyException(String message) {
        super(message);
    }
}
