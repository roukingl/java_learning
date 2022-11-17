package java_11_17;

import java.util.Iterator;
import java.util.LinkedList;

class MyHashMap {

    static class KV {
        private int key;
        private int value;

        public KV(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }
    
        public void setKey(int key) {
            this.key = key;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private final int BASE_SIZE = 769;
    private LinkedList<KV>[] list = null;

    public MyHashMap() {
        list = new LinkedList[BASE_SIZE];
        for (int i = 0; i < BASE_SIZE; i++) {
            list[i] = new LinkedList<>();
        }
    }
    
    public void put(int key, int value) {
        int index = key % BASE_SIZE;
        Iterator<KV> iterator = list[index].iterator();
        while (iterator.hasNext()) {
            KV ret = iterator.next();
            if (ret.getKey() == key) {
                ret.setValue(value);
                return;
            }
        }
        list[index].offerLast(new KV(key, value));
    }
    
    public int get(int key) {
        int index = key % BASE_SIZE;
        Iterator<KV> iterator = list[index].iterator();
        while (iterator.hasNext()) {
            KV ret = iterator.next();
            if (ret.getKey() == key) {
                return ret.getValue();
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = key % BASE_SIZE;
        Iterator<KV> iterator = list[index].iterator();
        while (iterator.hasNext()) {
            KV ret = iterator.next();
            if (ret.getKey() == key) {
                list[index].remove(ret);
                return;
            }
        }
    }
}