
public class Edge {

    //该边的权重,理解为长度
    public int weight;

    // 该边从哪个节点来
    public int from;

    // 该边连接哪个节点
    public int to;

    public Edge(int weight, int from, int to) {
        this.weight = weight;
        this.from = 0;
        this.to = 0;
    }
}
