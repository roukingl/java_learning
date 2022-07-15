package stack.Array;

/**
 * 顺序表实现栈
 */
public class Stack {

    private int[] elam;

    private int userSize;

    // 初始大小
    private static final int INITIAL_AMOUNT = 10;

    public Stack() {
        userSize = 0;
        elam = new int[INITIAL_AMOUNT];
    }

    // 入栈
    public void push(int data) {
        elam[userSize] = data;
        userSize++;
    }

    // 出栈
    public int pop() {
        int ret = elam[userSize - 1];
        userSize--;
        return ret;
    }

    // 查看栈顶元素
    public int peek() {
        int ret = elam[userSize - 1];
        return ret;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return userSize == 0;
    }
}
