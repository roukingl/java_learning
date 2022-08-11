package java_8_11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

    // leetcode 95.不同的二叉树搜索树2
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return createTreeRoot(1, n);
    }

    private List<TreeNode> createTreeRoot(int start, int end) {
        List<TreeNode> list = new LinkedList<TreeNode>();
        if (start > end) {
            list.add(null);
            return list;
        }

        // 循环每一次都构建以i值为根节点树的所有可能
        for (int i = start; i <= end; i++) {
            // 获得左侧的所有可能的树
            List<TreeNode> leftTreeSet = createTreeRoot(start, i - 1);

            // 右侧
            List<TreeNode> rightTreeSet = createTreeRoot(i + 1, end);


            // 把左树和右树的所有可能全部拼接到根节点上
            for (TreeNode leftTree : leftTreeSet) {
                for (TreeNode rightTree : rightTreeSet) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    list.add(root);
                }
            }
        }
        return list;
    }

    // leetcode 112.路径总和
/*    public boolean hasPathSum(TreeNode root, int targetSum) {

    }*/

    // leetcode 96.不同的二叉树搜索树
    Map<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }
        int count = 0;
        for (int i = 1; i <= n ; i++) {
            int left = numTrees(i - 1);
            int right = numTrees(n - i);
            count += left * right;

        }
        map.put(n, count);
        return count;
    }

}














