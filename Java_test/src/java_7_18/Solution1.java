package java_7_18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {

    // leetcode 101 判断是否是对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricSubTree(root.left, root.right);
    }

    private boolean isSymmetricSubTree(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null || rightTree == null) {
            return false;
        }
        if (leftTree.val != rightTree.val) {
            return false;
        }

        return isSymmetricSubTree(leftTree.left, rightTree.right) && isSymmetricSubTree(leftTree.right, rightTree.left);
    }

    // leetcode 102 二叉树的层序
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> row = new ArrayList<>();
        if (root == null) {
            return row;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> col = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode cur = queue.poll();
                col.add(cur.val);
                size--;
                if (cur.left != null) {
                    queue.offer(root.left);
                }
                if (cur.right != null) {
                    queue.offer(root.right);
                }
            }
            row.add(col);
        }
        return row;
    }
}
