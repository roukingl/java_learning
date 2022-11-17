package java_11_17;

// leetcode 705.设计哈希集合

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet {

    private final int BASE_SIZE = 769;
    private LinkedList[] list = null;

    public MyHashSet() {
        list = new LinkedList[BASE_SIZE];
        for (int i = 0; i < BASE_SIZE; i++) {
            list[i] = new LinkedList<Integer>();
        }
    }
    
    public void add(int key) {
        int index = key % BASE_SIZE;
        for (Integer ret : (Iterable<Integer>) list[index]) {
            if (ret == key) {
                return;
            }
        }
        list[index].offerLast(key);
    }

    
    public void remove(int key) {
        int h = key % BASE_SIZE;
        for (Integer element : (Iterable<Integer>) list[h]) {
            if (element == key) {
                list[h].remove(element);
                return;
            }
        }
    }
    
    public boolean contains(int key) {
        int index = key % BASE_SIZE;
        for (Integer ret : (Iterable<Integer>)list[index]) {
            if (ret == key) {
                return true;
            }
        }
        return false;
    }
}