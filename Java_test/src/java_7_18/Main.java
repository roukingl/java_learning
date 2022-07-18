package java_7_18;

import java.util.Scanner;

public class Main {
    
    public int i = 0;
    public TreeNode creatTree(String s) {
        TreeNode root = null;
        char ch = s.charAt(i);
        if (ch != '#') {
            i++;
            root = new TreeNode(ch);
            root.left = creatTree(s);
            root.right = creatTree(s);
        } else {
            i++;
        }
        return root;
    }
    
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String userScan = scan.nextLine();
            Main m = new Main();
            TreeNode ret = m.creatTree(userScan);
            m.inOrder(ret);
        }
    }
}
