package linkedlist;

/**
 * 无头单向非循环链表的实现
 */
public class MyLinkedList {

    Node head = new Node();

    // 打印该链表
    public void display() {

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //头插法
    public void addFirst(int data) {

        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(data);
    }

    // 任意位置插入
    public boolean addIndex(int index, int data) {
        Node cur = this.head;
        // 检查index
        checkIndexLegal(index);

        // 插入数据
        if (index == 0) {
            // 前插
            addFirst(data);
        } else if (index == size()) {
            // 尾插
            addLast(data);
        } else {
            while ((index - 1) != 0) {
                cur = cur.next;
                index--;
            }
            Node node = new Node(data);
            node.next = cur.next;
            cur.next = node;
        }

        return false;
    }

    public void checkIndexLegal(int index) {
        if (index < 0 || index > size()) {
            throw new IndexNotLegalException("index位置不合法");
        }
    }


    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {

        Node cur = this.head;
        while (cur != null) {
            if (cur.value == key) {
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        Node cur = this.head;
        while (cur != null) {
            if(cur.value == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {

    }

    /**
     * 获取该链表的长度
     *
     * @return 返回该链表的长度
     */
    public int size() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //清除链表
    public void clear() {

    }

    public MyLinkedList() {

    }

    public MyLinkedList(int data) {
        head.value = data;
    }


}
