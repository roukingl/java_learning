package algorithm_test;

// 找出字符串中最长的回文子串的长度
public class Manacher {

    private static int manacher(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 处理字符串
        char[] str = getChar(s);
        int R = -1; // 回文有边界再往右一个位置
        int C = -1; // 到达最大有边界时的中心点
        // 最大回文半径
        int maxRight = Integer.MIN_VALUE;
        // 存储的是处理过的字符串中回文字符串的半径,就是原字符串的回文字符串的长度
        int[] radiusArray = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            radiusArray[i] = i < R ? Math.min(radiusArray[2 * C - i], R - i + 1) : 1;
            // 需要扩的
            while (i + radiusArray[i] < str.length && i - radiusArray[i] > -1) {
                if (str[i + radiusArray[i]] == str[i - radiusArray[i]]) {
                    radiusArray[i]++;
                } else {
                    break;
                }
                if (i + radiusArray[i] > R) {
                    C = i;
                    R = i + radiusArray[i];
                }
            }
            maxRight = Math.max(maxRight, radiusArray[i]);
        }
        return maxRight - 1;
    }

    private static char[] getChar(String s) {
        int len = s.length();
        char[] str = new char[len * 2 + 1];
        int indexStr = 0;
        for (int i = 0; i < len; i++) {
            str[indexStr] = '#';
            indexStr++;
            str[indexStr] = s.charAt(i);
            indexStr++;
        }
        str[indexStr] = '#';
        return str;
    }

    public static void main(String[] args) {
        String str1 = "abc123321cba";
        System.out.println(manacher(str1));
    }
}
