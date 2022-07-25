package java_7_25;

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
}
