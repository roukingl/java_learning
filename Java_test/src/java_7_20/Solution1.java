package java_7_20;

public class Solution1 {

    // newcoder JZ36 二叉搜索树与双向链表

    private TreeNode prev = null;
    public void ConvertChild(TreeNode root) {
        if (root == null) {
            return;
        }
        ConvertChild(root.left);
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        ConvertChild(root.right);
    }

    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        ConvertChild(root);
        TreeNode head = root;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

/*    // leetcode 105 从前序与中序序列构建二叉树
    public int preSub = 0;
    public TreeNode inOrderTreeSeek(int[] preorder, int[] inorder, int inBegin, int inEnd) {
        if (inBegin > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preSub]);
        int ri = findInOrder(preorder[preSub], inorder, inBegin, inEnd);
        preSub++;
        root.left = inOrderTreeSeek(preorder, inorder, inBegin, ri - 1);
        root.right = inOrderTreeSeek(preorder, inorder, ri + 1, inEnd);
        return root;
    }

    public int findInOrder(int val, int[]inorder, int ib, int ie) {
        for (int i = ib; i <= ie; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }*/
/*
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = inOrderTreeSeek(preorder, inorder, 0, inorder.length - 1);
        return root;
    }*/

    // leetcode 106 从中序与后序数组中创建二叉树
    public int postSub = 0;
    public TreeNode inOrderTreeSeek(int[] postorder, int[] inorder, int inBegin, int inEnd) {
        if (inBegin > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postSub]);
        int rootIndex = findInOrder(postorder[postSub], inorder, inBegin, inEnd);
        postSub--;
        root.right = inOrderTreeSeek(postorder, inorder, rootIndex + 1, inEnd);
        root.left = inOrderTreeSeek(postorder, inorder, inBegin, rootIndex - 1);
        return root;
    }

    public int findInOrder(int val, int[]inorder, int inBegin, int inEnd) {
        for (int i = inBegin; i <= inEnd; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postSub = postorder.length - 1;
        TreeNode root = inOrderTreeSeek(postorder, inorder, 0, inorder.length - 1);
        return root;
    }
}
