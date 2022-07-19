package jave_7_19;

public class Solution {

    // leetcode 226.翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode ret = root.left;
        root.left = root.right;
        root.right = ret;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}