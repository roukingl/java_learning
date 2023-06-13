package test_2022.java_7_18;


public class Solution2 {

        // leetcode 572 判断是否是另一颗树的字数
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (q == null || p == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }


        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (isSameTree(root, subRoot)) {
                return true;
            }
            if (root == null || subRoot == null) {
                return false;
            }
            if (isSubtree(root.left, subRoot)) {
                return true;
            }
            if (isSubtree(root.right, subRoot)) {
                return true;
            }
            return false;
        }


        // leetcode 110 判断是否是平衡二叉树
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftTree = maxDepth(root.left);
            int rightTree = maxDepth(root.right);
            if (leftTree >= 0 && rightTree >= 0 && Math.abs(leftTree - rightTree) <= 1) {
                return Math.max(leftTree, rightTree) + 1;
            } else {
                return -1;
            }
        }

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return maxDepth(root) >= 0;
        }

        // leetcode 110 判断是否是平衡二叉树
        /*
        public int maxDepth(TreeNode root) {

            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            int leftTree = maxDepth(root.left);
            int rightTree = maxDepth(root.right);
            if (Math.abs(leftTree - rightTree) > 1) {
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }
         */
}
