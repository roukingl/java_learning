import java.util.ArrayList;

public class Node {

    public int value;
    // 一个节点的入度
    public int in;
    // 一个节点的出度
    public int out;

    // 一个节点拥有的节点
    ArrayList<Node> nexts;
    // 一个节点拥有的边
    ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
