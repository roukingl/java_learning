package test_2022.java_7_25;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Test {
    // leetcode 387.字符串中的第一个唯一字符
    public int firstUniqChar(String s) {

        int[] ch = new int[26];

        for (int i = 0;i < s.length();i++) {
            ch[s.charAt(i) - 97]++;
        }
        for (int i = 0;i < s.length();i++) {
            if (ch[s.charAt(i) - 97] == 1) {
                return i;
            }
        }
        return -1;
    }

    // leetcode 136.只出现一次的字符
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer x : nums) {
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    // leetcode 138.复制带随机指针的链表
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        Node root = map.get(head);
        return root;
    }

    // leetcode 771.宝石与石头
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
