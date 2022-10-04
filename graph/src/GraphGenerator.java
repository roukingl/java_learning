/**
 * 将矩阵式的图转化为节点连接的图
 */
public class GraphGenerator {

    public static Graph creatGraph(int[][] matrix) {
        Graph graph = new Graph();
        for (int[] ints : matrix) {
            Integer from = ints[0];
            Integer to = ints[1];
            int weight = ints[2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(from, new Node(from));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, from, to);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }
}











