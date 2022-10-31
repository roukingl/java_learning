package java_10_31;

import java.util.*;

class Solution {

    // leetcode 235. 二叉搜索树的最近公共祖先 一次遍历**
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else if (cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return root;
    }

    // leetcode 653. 两数之和 IV - 输入二叉搜索树 中序遍历 + 双指针 + 递归
    public boolean findTarget2(TreeNode root, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        inOrder(root, list);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int leftNumber = list.get(left);
            int rightNumber = list.get(right);
            if (leftNumber + rightNumber == k) {
                return true;
            } else if (leftNumber + rightNumber < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public void inOrder(TreeNode root, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    // leetcode 653. 两数之和 IV - 输入二叉搜索树 广度搜索
    public boolean findTarget1(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (set.contains(k - cur.val)) {
                return true;
            }
            set.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }

        }
        return false;
    }

    // leetcode 653. 两数之和 IV - 输入二叉搜索树 递归
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }
        return find(root.left, k, set) || find(root.right, k, set);
    }
}