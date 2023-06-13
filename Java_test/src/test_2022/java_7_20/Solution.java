package test_2022.java_7_20;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// leetcode 236 二叉树的最近祖先节点

// 1. 普通的方法
/*
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);
        if (leftTree != null && rightTree != null) {
            return root;
        } else if (leftTree != null) {
            return leftTree;
        } else {
            return rightTree;
        }
    }
}
*/



// 2. 链表的第一个交点
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stackP = new Stack<>();
        findNodePath(root, p, stackP);
        Stack<TreeNode> stackQ = new Stack<>();
        findNodePath(root, q, stackQ);
        // 两个栈中储存着路径 求各自大小
        int pSize = stackP.size();
        int qSize = stackQ.size();

        if (pSize > qSize) {
           int len = pSize - qSize;
           for (int i = 0;i < len;i++) {
               stackP.pop();
           }
        } else {
           int len = qSize - pSize;   
           for (int i = 0;i < len;i++) {
               stackQ.pop();
           }      
        }
        while (!stackP.empty() && !stackQ.empty()) {
            if (stackP.peek() == stackQ.peek()) {
                return stackP.pop();
            } else {
                stackP.pop();
                stackQ.pop();            
            }

        }
        return null;
    }

    private boolean findNodePath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if (root == null || node == null) {
            return false;
        }
        // 两个栈，分别放p q 的路径
        // 先放根
        stack.push(root);
        // 判断这个根是不是要找的， 是的话返回true
        if (root == node) {
            return true;
        }
        // 再找左边的 找到了返回true
        boolean ret1 = findNodePath(root.left, node, stack);
        if (ret1) {
            return true;
        }
        // 找右边的
        boolean ret2 = findNodePath(root.right, node, stack);
        if (ret2) {
            return true;
        }
        stack.pop();
        return false;
    }


    // leetcode 606 根据二叉树创建字符串
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        constructString(root, sb);
        return sb.toString();
    }

    public void constructString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            tree2str(root.left);
        } else {
            if (root.right != null) {
                sb.append("()");
            } else {
                sb.append(")");
            }
        }
        if (root.right == null) {
            sb.append(")");
        } else {
            sb.append("(");
            tree2str(root.right);
        }
    }

    // 非递归前序遍历二叉树
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
        return list;
    }

    // 非递归中序遍历二叉树
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);

                cur = cur.left;
            }
            TreeNode ret = stack.pop();
            list.add(ret.val);
            cur = ret.right;
        }
        return list;
    }

    // 非递归后序遍历二叉树 (看)
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                stack.pop();
                list.add(top.val);
                prev = top;
            } else {
                cur = top.right;
            }
        }
        return list;
    }
}