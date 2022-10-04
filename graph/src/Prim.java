import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {

    private static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> PrimGraph(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set = new HashSet<>();
        Set<Edge> result = new HashSet<>();
        for (Node cur : graph.nodes.values()) {
            set.add(cur);
            priorityQueue.addAll(cur.edges);
            while (!priorityQueue.isEmpty()) {
                Edge edge = priorityQueue.poll();
                Node toNode = edge.to;
                if (!set.contains(toNode)) {
                    set.add(toNode);
                    result.add(edge);
                    priorityQueue.addAll(toNode.edges);
                }
            }
        }
        return result;
    }
}
