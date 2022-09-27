package algorithm_test;

// 从一个字符串中找一个字符串
public class KMP {

    /**
     * 从一个str1字符串中找到str2字符串
     * @param str1 被找的字符串
     * @param str2 要找的字符串
     * @return 找到返回真,没找到返回假
     */
    public int searchStringKMP(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < str2.length() || str2.length() < 1) {
            return -1;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int i = 0; // ch1 的下标
        int j = 0; // ch2 的下标
        int[] next = getNextArray(ch2);
        while (i < ch1.length && j < ch2.length) {
            if (ch1[i] == ch2[j]) {
                i++;
                j++;
            } else if (next[j] == -1) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == ch2.length ? i - j : -1;
    }


    private int[] getNextArray(char[] ch) {
        if (ch.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ch.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        for (int i = 2; i < next.length;) {
            if (ch[i - 1] == ch[cn]) {
                next[i] = ++cn;
                i++;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i] = 0;
                i++;
            }
        }
        return next;
    }
}
