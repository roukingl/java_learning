package queue.queue.Linked;

/**
 * 单链表实现队列
 */
public class Queue {

    // 队头
    private ListNode head;

    // 队尾
    private ListNode tail;

    // 入队
    public void offer(int data) {
        ListNode cur = new ListNode(data);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            tail.next = cur;
            tail = tail.next;
        }
    }

    // 出队
    public int poll() {
        int ret = head.value;
        if (!isEmpty()) {
            head = head.next;
        } else {
            throw new QueueIsEmptyException("队列为空");
        }
        return ret;
    }

    // 获得队头的值
    public int peek() {
        int ret = head.value;
        if (isEmpty()) {
            throw new QueueIsEmptyException("队列为空");
        }
        return ret;
    }

    private boolean isEmpty() {
        return head == null;
    }

}
