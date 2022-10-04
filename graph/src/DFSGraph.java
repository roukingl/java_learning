import java.util.HashSet;
import java.util.Stack;

public class DFSGraph {

    // 图的深度优先遍历,用栈实现
    public static void DFS(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        while (!stack.empty()) {
            Node cur = stack.pop();
            for(Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(cur.value);
                    break;
                }
            }
        }

    }
}
