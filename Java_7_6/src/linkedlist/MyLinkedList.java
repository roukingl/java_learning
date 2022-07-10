package linkedlist;

/**
 * 无头单向非循环链表的实现
 */
public class MyLinkedList {

    ListNode head;

    // 打印该链表
    public void display() {

        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //头插法
    public void addFirst(int data) {

        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(data);
    }

    // 任意位置插入
    public boolean addIndex(int index, int data) {
        ListNode cur = this.head;
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
            ListNode node = new ListNode(data);
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

        ListNode cur = this.head;
        while (cur != null) {
            if (cur.value == key) {
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if(this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.next.value == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        ListNode ret = this.head;
        ListNode cur = this.head.next;
        while (cur != null) {
            if (cur.value == key) {
                ret.next = cur.next;
                cur = cur.next;
            } else {
                //ret.next = cur;
                ret = cur;
                cur = cur.next;

            }
        }
        if (this.head.value == key) {
            this.head = this.head.next;
        }
    }

    /**
     * 获取该链表的长度
     *
     * @return 返回该链表的长度
     */
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //清除链表
    public void clear() {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            ListNode ret = cur;
            ret.next = null;
            cur = cur.next;
        }
        this.head = null;
    }
}
