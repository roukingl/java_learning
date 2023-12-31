import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    // 根节点
    public TreeNode root;

    // 前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    // 中序遍历
    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        System.out.print(root.value + " ");
        preOrder(root.right);
    }

    // 后序遍历
    void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.value + " ");
    }

    // 获取树中节点的个数 子问题思路
    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    // 获取树中节点的个数 遍历思路
    private static int nodeSize = 0;

    public void size(TreeNode root) {
        if (root == null) {
            return;
        } else {
            nodeSize++;
            size(root.left);
            size(root.right);
        }
    }

    // 把下面两个的root == null 的判断去了试试对不对
    // 获取叶子节点的个数 子问题思路
    public int getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }

    // 获取叶子节点的个数 遍历思路
    private static int leafNodeSize = 0;

    public void getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafNodeSize++;
            return;
        }

        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
    }

    // 获取第K层节点的个数
    public int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k - 1) + getKLevelNodeCount(root.right, k - 1);
    }

    // 获取二叉树的高度
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    // 检测值为value的元素是否存在
    public TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.value == val) {
            return root;

        }
        TreeNode leftVal = find(root.left, val);
        if (leftVal != null) {
            return leftVal;
        }
        TreeNode rightVal = find(root.right, val);
        if (rightVal != null) {
            return rightVal;
        }
        return null;
    }

    //层序遍历
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur + " ");
            if (cur.left != null) {
                queue.offer(root.left);
            }
            if (cur.right != null) {
                queue.offer(root.right);
            }
        }
    }

    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(root.left);
                queue.offer(root.right);
            } else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            TreeNode ret = queue.poll();
            if (ret != null) {
                return false;
            }
        }
        return true;
    }

}
