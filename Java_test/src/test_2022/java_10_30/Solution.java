package test_2022.java_10_30;

import java.util.*;

class Solution {

    public static void main(String[] args) {
    }

    // leetcode 98. 验证二叉搜索树 迭代
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long min = Long.MIN_VALUE;
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            if (cur.val <= min) {
                return false;
            }
            min = cur.val;
            root = cur.right;
        }
        return true;
    }

    // leetcode 98. 验证二叉搜索树 中序递归
    public boolean isValidBST2(TreeNode root) {
        return mediumOrder(root);
    }

    long min = Long.MIN_VALUE;
    public boolean mediumOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftTree = mediumOrder(root.left);
        if (!leftTree) {
            return false;
        }
        if (root.val <= min) {
            return false;
        }
        min = root.val;
        boolean rightTree = mediumOrder(root.right);
        return leftTree && rightTree;
    }

    // leetcode 98. 验证二叉搜索树 递归
    public boolean isValidBST1(TreeNode root) {
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValid(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
    }

    // public boolean isValidBST(TreeNode root) {
    //     // if (root.left == null && root.right == null) {
    //     //     return true;
    //     // } else if (root.left == null && root.right.val > root.val) {
    //     //     return isValidBST(root.right);
    //     // } else if (root.right == null && root.left.val < root.val) {
    //     //     return isValidBST(root.left);
    //     // } else if (root.left != null && root.right != null && root.left.val < root.val && root.right.val > root.val) {
    //     //     return isValidBST(root.left) && isValidBST(root.right);
    //     // } else {
    //     //     return false;
    //     // }
    //     return isValidLeft(root.left, root.val) && isValidRight(root.right, root.val);
    // }

    // private boolean isValidLeft(TreeNode leftNode, int maxNumber) {
    //     if (leftNode == null) {
    //         return true;
    //     }
    //     if (leftNode.val >= maxNumber) {
    //         return false;
    //     }
    //     return isValidLeft(leftNode.left, leftNode.val) && isValidRight(leftNode.right, leftNode.val);
    // }

    // private boolean isValidRight(TreeNode rightNode, int minNumber) {
    //     if (rightNode == null) {
    //         return true;
    //     }
    //     if (rightNode.val <= minNumber) {
    //         return false;
    //     }
    //     return isValidLeft(rightNode.left, rightNode.val) && isValidRight(rightNode.right, rightNode.val);
    // }

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