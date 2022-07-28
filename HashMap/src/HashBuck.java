
public class HashBuck {

    private Node[]  array;

    private int size;   // 当前的数据个数

    private static final double LOAD_FACTOR = 0.75;

    private static final int DEFAULT_SIZE = 8;//默认桶的大小

    /**
     * 将元素放入哈希桶中
     * @param key key值
     * @param value key对应的value值
     */
    public void put(int key, int value) {

        Node node = new Node(key, value);
        int index = key % this.array.length;
        // 判断是否有重复的，有直接替换val
        Node cur = this.array[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.val = value;
                return;
            }
            cur = cur.next;
        }
        // 头插法
        node.next = this.array[index];
        this.array[index] = node;
        size++;
        // 判断负载因子大小
        if (loadFactor() >= LOAD_FACTOR) {
            glow();
        }
}

    private void glow() {
        // 扩容后要重新分配
        Node[] newArray = new Node[this.array.length * 2];
        for (int i = 0; i < this.array.length; i++) {
            Node cur = this.array[i];
            while (cur != null) {
                Node curNext = cur.next;
                int index = cur.key % newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }
        this.array = newArray;
    }

    private double loadFactor() {
        return size * 1.0 / array.length;
    }


    public HashBuck() {
        array = new Node[DEFAULT_SIZE];
    }


    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
}

