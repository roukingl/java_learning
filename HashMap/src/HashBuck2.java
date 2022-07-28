
public class HashBuck2<K, V> {
    static class Node<K, V>{
        public K key;

        public V val;

        Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private int size;

    private static final double LOAD_FACTOR = 0.75;

    private static final int DEFAULT_SIZE = 8;

    public Node<K,V> [] array = (Node<K,V> [])new Node[10];

    public void put(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K, V> cur = this.array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.val = value;
                return;
            }
            cur = cur.next;
        }
        node.next = this.array[index];
        this.array[index] = node;
        size++;
        // 扩容不写了
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K, V> cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }

}
