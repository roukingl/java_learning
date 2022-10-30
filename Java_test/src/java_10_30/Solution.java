package java_10_30;

class Solution {

    public static void main(String[] args) {
    }

    // leetcode 701. 二叉搜索树中的插入操作 模拟
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pos = root;
        while (pos != null) {
            if (val < pos.val) {
                if (pos.left == null) {
                    pos.left = new TreeNode(val);
                    break;
                } else {
                    pos = pos.left;
                }
            } else {
                if (pos.right == null) {
                    pos.right = new TreeNode(val);
                    break;
                } else {
                    pos = pos.right;
                }
            }
        }
        return root;
    }

    // leetcode 701. 二叉搜索树中的插入操作 递归
    /*public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }*/

    // leetcode 700. 二叉搜索树中的搜索
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        } 
        if (root.val == val) {
            return root;
        }
        TreeNode node = null;
        if (root.val > val) {
            node = searchBST(root.left, val);
        }
        if (root.val < val) {
            node = searchBST(root.right, val);
        }
        return node;
    }
}