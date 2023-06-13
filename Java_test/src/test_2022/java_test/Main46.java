package test_2022.java_test;

import java.util.*;

public class Main46 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Map<String, Integer>> queue = new PriorityQueue<>();
        Set<String> set = new HashSet<>(); // 记录重复文件。 重复舍弃

        while (scanner.hasNext()) {
            String path = scanner.nextLine();
            if (set.add(path)) {
                Map<String, Integer> map = new HashMap<>();
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < path.length(); i++) {
                    char ch = path.charAt(i);
                    if (ch != '\\') {
                        stringBuilder.append(ch);
                    } else {
                        stringBuilder.setLength(0);
                    }
                }
                String fileName = stringBuilder.toString();
                int len = 0;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < fileName.length(); i++) {
                    if (fileName.charAt(i) == ' ') {
                        sb.append(fileName.substring(i));
                        break;
                    } else {
                        len++;
                    }
                }
                if (len > 16) {
                    int n = len - 16;
                    String codeLines = sb.toString();
                    fileName = fileName.substring(n) + codeLines;
                }
                map.put(fileName, map.getOrDefault(fileName, 0) + 1);
                if (queue.size() > 8) {
                    queue.poll();
                    queue.offer(map);
                } else {
                    queue.offer(map);
                }
            }
        }
        for (Map<String, Integer> tmp : queue) {
            Set<String> s = tmp.keySet();
            for (String str : s) {
                System.out.println(str + " " + tmp.get(str));
            }
        }
    }

    public static void main1(String[] args) {
        System.out.println(MoreThanHalfNum_Solution2(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public static int MoreThanHalfNum_Solution1(int[] numbers) {
        // 1. 排序
        // 2. Map
        // 3. 每次拿掉不同的两个数， 还剩的那个就是真的
        Arrays.sort(numbers);
        return numbers[numbers.length / 2];
    }

    public static int MoreThanHalfNum_Solution2(int[] numbers) {
        // 1. 排序
        // 2. Map
        // 3. 每次拿掉不同的两个数， 还剩的那个就是真的
        // 4. 循环
        int[] arr = new int[10001];
        int max = 0;
        int len = 0;
        for (int number : numbers) {
            arr[number]++;
            if (arr[number] > len) {
                len = arr[number];
                max = number;
            }
        }
        return max;
    }
}
