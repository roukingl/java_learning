/**
 * 二叉搜索树：实现搜索，插入，删除
 */
public class BinarySearchTree {

    private TreeNode root;

    /**
     * 搜索，找到返回真，找不到返回假
     * @param key 要找的数
     * @return 返回的真假
     */
    public boolean search(int key) {
        TreeNode cur = this.root;
        while (cur != null) {
            if (cur.val < key) {
                cur = cur.right;
            } else if (cur.val > key) {
                cur = cur.left;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 插入指定元素
     * @param key  指定的元素
     */
    public boolean insert(int key) {
        TreeNode node = new TreeNode(key);
        // 第一个元素
        if (root == null) {
            root = node;
            return true;
        }
        // 超过第一个元素
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.val > key) {
                prev = cur;
                cur = cur.left;
            } else if (cur.val < key) {
                prev = cur;
                cur = cur.right;
            } else {
                // 插入失败
                return false;
            }
        }
        // 找到前驱prev，判断把node放到prev左还是右
        if (key > prev.val) {
            prev.right = node;
        } else {
            prev.left = node;
        }
        return true;
    }

    /**
     * 删除，使用替换删除法
     * @param key 要删除的数据
     */
    public void remove(int key) {
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.val < key) {
                prev = cur;
                cur = cur.right;
            } else if (cur.val > key) {
                prev = cur;
                cur = cur.left;
            } else {
                removeNode(cur, prev);
                return;
            }
        }
    }

    private void removeNode(TreeNode cur, TreeNode parent) {
        if (cur.left == null) {
            if (cur == this.root) {
                root = root.right;
            } else if (parent.left == cur) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == this.root) {
                root = root.left;
            } else if (parent.left == cur) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            // 找右树的最小值
            TreeNode target = cur.right;
            TreeNode targetParent = cur;
            while (target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if (targetParent.left == target) {
                targetParent.left = target.right;
            } else {
                targetParent.right = target.right;
            }
        }
    }
}
