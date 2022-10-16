package java_test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        while (scanner.hasNextInt()) {
            int count = scanner.nextInt();
            int[] array = new int[count * 3];
            for (int i = 0; i < 3 * count; i++) {
                array[i] = scanner.nextInt();
            }
            // 两种组合, 第二大和倒数第二小相加,第三大和倒数第三小相加,比较,怎么取出?
            // ? 先去掉最大的和最小的? 怎么去? 换个存储结构?两个堆?大小
            PriorityQueue<Integer> queueDa = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            PriorityQueue<Integer> queueXiao = new PriorityQueue<>();
            for (int i = 0; i < array.length; i++) {
                queueXiao.add(array[i]);
                queueDa.add(array[i]);
            }
            queueDa.poll();
            queueXiao.poll();
            int maxdier = queueDa.poll() + queueXiao.poll();
            int maxdisan = queueDa.poll() + queueXiao.poll();
            if (maxdisan > maxdier) {
                max = maxdisan;
            } else {
                max = maxdier;
            }
            System.out.println(max);
            max = 0;
        }
    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            HashSet<Character> set = new HashSet<>();
            for (char ch : str2.toCharArray()) {
                set.add(ch);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : str1.toCharArray()) {
                if (!set.contains(ch)) {
                    stringBuilder.append(ch);
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }*/
}










