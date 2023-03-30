package java_test;

import java.util.*;

public class Main45 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            List<String> strs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                strs.add(scanner.next());
            }
            // 先按字典序排序
            Collections.sort(strs);
            String x = scanner.next();
            int k = scanner.nextInt();
            Map<Character, Integer> m = new HashMap<>();
            for (int i = 0; i < x.length(); i++) {
                char ch = x.charAt(i);
                m.put(ch, m.getOrDefault(ch , 0) + 1);
            }
            Set<Character> set = m.keySet();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Map<Character, Integer> map = new HashMap<>();
                // 如果当前字符串和 x 字符串相同就不是 x 的兄弟单词， 跳过
                String tmp = strs.get(i);
                if (!tmp.equals(x) && tmp.length() == x.length()) {
                    for (int j = 0; j < tmp.length(); j++) {
                        char ch = tmp.charAt(j);
                        map.put(ch, map.getOrDefault(ch, 0) + 1);
                    }
                    // 比较 x 的 map 和 当前字符串的 map 每个对应的都相同留下， 不相同舍弃
                    boolean flg = true;
                    for (char ch : set) {
                        if (m.get(ch) != map.getOrDefault(ch, 0)) {
                            // 舍弃
                            flg = false;
                            break;
                        }
                    }
                    // 相同
                    if (flg) {
                        // 存起来
                        list.add(tmp);
                    }
                }
            }
            // 然后 输出 list size， 和第 k 个字典序 没有不输出
            int len = list.size();
            System.out.println(len);
            if (k <= len) {
                System.out.println(list.get(k - 1));
            }
        }
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] a = scanner.next().toCharArray();
            char[] b = scanner.next().toCharArray();
            Map<Character, Integer> mapA = new HashMap<>();
            Map<Character, Integer> mapB = new HashMap<>();
            for (char ch : a) {
                mapA.put(ch, mapA.getOrDefault(ch, 0) + 1);
            }
            for (char ch : b) {
                mapB.put(ch, mapB.getOrDefault(ch, 0) + 1);
            }
            Set<Character> setB = mapB.keySet();
            boolean flg = true;
            for (char ch : setB) {
                if (!mapA.containsKey(ch) || mapA.getOrDefault(ch, 0) < mapB.get(ch)) {
                    flg = false;
                    System.out.println("No");
                    break;
                }
            }
            if (flg) {
                System.out.println("Yes");
            }
        }
    }
}
