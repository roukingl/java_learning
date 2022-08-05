package java_8_4;

import java.util.*;

class Solution {

    // leetcode  83.删除排序链表中的重复元素
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            if (set.add(cur.val)) {
                prev = cur;
                cur = cur.next;
            } else {
                assert prev != null;
                prev.next = cur.next;
                cur = cur.next;
            }
        }
        return head;
    }

    // leetcode 108.将有序数组转换成二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return createSortTree(nums, 0, nums.length - 1);
    }

    private TreeNode createSortTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int midSub = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[midSub]);
        node.left = createSortTree(nums, left, midSub - 1);
        node.right = createSortTree(nums, midSub + 1, right);
        return node;
    }

    // leetcode 111.二叉树的最小深度
    // 广度优先
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 1;
        while (!queue.isEmpty()) {
            // 每一层的个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return height;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            height++;
        }
        return height;
    }

    // 深度优先
    /*
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minHeight = Integer.MAX_VALUE;
        if (root.left != null) {
            minHeight = Math.min(minDepth(root.left), minHeight);
        }
        if (root.right != null) {
            minHeight = Math.min(minDepth(root.right), minHeight);
        }
        return minHeight + 1;
    }
    */
}









