/**
 * 无头双向非循环链表的大概实现
 */
public class MyLinkedList {

    // 链表头
    ListNode head;

    // 链表尾
    ListNode end;

    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null && this.end == null) {
            this.head = node;
            this.end = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }

    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null && this.end == null) {
            this.head = node;
            this.end = node;
        } else {
            this.end.next = node;
            node.prev = this.end;
            this.end = node;
        }
    }

    public void checkIndexLegal(int index) {
        if (index < 0 || index > size()) {
            throw new IndexNotLegalException("index不合法");
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        // 判断index的合法性
        checkIndexLegal(index);
        if (index == 0) {
            addFirst(data);
        } else if (index == size()) {
            addLast(data);
        } else {
            node.next = cur;
            node.prev = cur.prev;
            cur.prev.next = node;
            cur.prev = node;
        }
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode cur = this.head;

        while (cur != null) {
            if (cur.val == key) {
                // 处理头节点问题
                if (cur == head) {
                    // 改变链表的头
                    head = cur.next;
                    // 判断改变后的头是不是空，是的话不管，不是的话就把头的prev置为null
                    // 本质是处理只有一个节点的情况
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    // 不是头结点
                    cur.prev.next = cur.next;
                    // 处理链表的尾
                    if (cur == end) {
                        // 尾前移
                        end = cur.prev;
                        end.next = null;
                    } else {
                        cur.next.prev = cur.prev;
                    }
                }
                return;
            }
            cur = cur.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.head;

        while (cur != null) {
            if (cur.val == key) {
                // 处理头节点问题
                if (cur == head) {
                    // 改变链表的头
                    head = cur.next;
                    // 判断改变后的头是不是空，是的话不管，不是的话就把头的prev置为null
                    // 本质是处理只有一个节点的情况
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    // 不是头结点
                    cur.prev.next = cur.next;
                    // 处理链表的尾
                    if (cur == end) {
                        // 尾前移
                        end = cur.prev;
                        end.next = null;
                    } else {
                        cur.next.prev = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    //得到单链表的长度
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    public void clear() {

    }
}
