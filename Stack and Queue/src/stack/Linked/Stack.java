package stack.Linked;

/**
 * 单链表实现栈
 */
public class Stack {

    private ListNode head;

    // 入栈
    public void push(int data) {
        ListNode cur = new ListNode(data);
        if (head == null) {
            head = cur;
        } else {
            cur.next = head;
            head = cur;
        }
    }

    // 出栈
    public int pop() {
        int ret = head.value;
        if (!isEmpty()) {
            head = head.next;
        } else {
            throw new StackIsEmptyException("栈为空，无法弹出");
        }
        return ret;
    }

    // 查看栈顶元素
    public int peek() {
        int ret = head.value;
        if (isEmpty()) {
            throw new StackIsEmptyException("栈为空，无法检测");
        }
        return ret;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return head == null;
    }
}
