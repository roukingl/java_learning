
public class Edge {

    //该边的权重,理解为长度
    public int weight;

    // 该边从哪个节点来
    public Node from;

    // 该边连接哪个节点
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
