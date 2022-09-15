
public class PrefixTree {

    TreeNode root = new TreeNode();

    public void insertDate(String s) {
        if (s == null) {
            return;
        }
        TreeNode cur = root;
        char[] checkChar = s.toCharArray();
        int index = 0;
        cur.pass++;
        for (int i = 0; i < checkChar.length; i++) {
            index = checkChar[i] - 'a';
            cur.nodes[index] = new TreeNode();
            cur.nodes[index].pass++;
            cur = cur.nodes[index];
        }
        cur.end++;
    }

    // 得到以字符串s为前缀的字符串个数
    public int getPrefixCount(String s) {
        if (s == null) {
            return -1;
        }
        char[] checkChar = s.toCharArray();
        int index = 0;
        TreeNode cur = root;
        for (int i = 0; i < checkChar.length; i++) {
            index = checkChar[i] - 'a';
            cur = cur.nodes[index];
            if (cur == null) {
                return 0;
            }
        }
        return cur.pass;
    }

    // 判断字符串s有几个储存在前缀数中
    public int serch(String s) {
        if (s == null) {
            return 0;
        }
        if (s.equals("")) {
            return root.pass;
        }
        char[] checkChar = s.toCharArray();
        int index = 0;
        TreeNode cur = root;
        for (int i = 0; i < checkChar.length; i++) {
            index = checkChar[i] - 'a';
            cur = cur.nodes[index];
            if (cur == null) {
                return 0;
            }
        }
        return cur.end;
    }

    // 删除前缀树中的字符串
    public void remove () {

    }

}




