
public class TreeNode {
    // 记录经过节点的次数
    public int pass;

    // 记录结束的次数
    public int end;

    // 26条路
    public TreeNode[] nodes = new TreeNode[26];

    public TreeNode () {
        this.pass = 0;
        this.end = 0;
    }

}
